package net.ripe.db.whois.common.source;

import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mchange.v2.c3p0.DataSources;
import net.ripe.db.whois.common.domain.CIString;
import net.ripe.db.whois.common.jdbc.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.CheckForNull;
import javax.annotation.Nullable;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import static net.ripe.db.whois.common.domain.CIString.ciString;

@Component
public class SourceContext {
    private static final Logger LOGGER = LoggerFactory.getLogger(SourceContext.class);

    private final Source masterSource;
    private final Source slaveSource;

    private final Map<Source, SourceConfiguration> sourceConfigurations = Maps.newLinkedHashMap();

    private final Set<CIString> grsSourceNames;
    private final Set<CIString> mirrorSourceNames;
    private final Set<CIString> allSourceNames;
    private final Map<CIString, CIString> aliases;

    private ThreadLocal<SourceConfiguration> current = new ThreadLocal<SourceConfiguration>();

    @Autowired
    public SourceContext(
            @Value("${whois.source}") final String mainSourceNameString,
            @Value("${grs.sources}") final String grsSourceNames,
            @Value("${mirror.sources}") final String mirrorSourceNames,
            @Value("${whois.db.grs.master.baseurl}") final String grsMasterBaseUrl,
            @Value("${whois.db.mirror.master.baseurl}") final String mirrorMasterBaseUrl,
            @Value("${whois.db.master.username}") final String whoisMasterUsername,
            @Value("${whois.db.master.password}") final String whoisMasterPassword,
            @Value("${whois.db.grs.slave.baseurl}") final String grsSlaveBaseUrl,
            @Value("${whois.db.mirror.slave.baseurl}") final String mirrorSlaveBaseUrl,
            @Value("${whois.db.slave.username}") final String whoisSlaveUsername,
            @Value("${whois.db.slave.password}") final String whoisSlavePassword,
            @Qualifier("whoisMasterDataSource") final DataSource whoisMasterDataSource,
            @Qualifier("whoisSlaveDataSource") final DataSource whoisSlaveDataSource,
            final DataSourceFactory dataSourceFactory) {

        final CIString mainSourceName = ciString(mainSourceNameString);
        this.masterSource = Source.master(mainSourceName);
        this.slaveSource = Source.slave(mainSourceName);

        final Set<CIString> grsSources = Sets.newLinkedHashSet();
        final Set<CIString> mirrorSources = Sets.newLinkedHashSet();
        final Map<CIString, CIString> aliases = Maps.newLinkedHashMap();

        sourceConfigurations.put(masterSource, new SourceConfiguration(masterSource, whoisMasterDataSource));
        sourceConfigurations.put(slaveSource, new SourceConfiguration(slaveSource, whoisSlaveDataSource));

        final Iterable<CIString> grsSourceNameIterable = Iterables.transform(Splitter.on(',').split(grsSourceNames), new Function<String, CIString>() {
            @Nullable
            @Override
            public CIString apply(final String input) {
                return ciString(input);
            }
        });

        for (final CIString grsSourceName : grsSourceNameIterable) {
            if (!grsSourceName.endsWith(ciString("-GRS"))) {
                LOGGER.warn("Skipped non-GRS source: {}", grsSourceName);
                continue;
            }

            grsSources.add(grsSourceName);

            final Source grsMasterSource = Source.master(grsSourceName);
            final Source grsSlaveSource = Source.slave(grsSourceName);

            if (grsSourceName.contains(mainSourceName)) {
                LOGGER.info("Delegating source {} to {}", grsSourceName, mainSourceName);
                aliases.put(grsSourceName, slaveSource.getName());
                sourceConfigurations.put(grsMasterSource, new SourceConfiguration(grsMasterSource, whoisMasterDataSource));
                sourceConfigurations.put(grsSlaveSource, new SourceConfiguration(grsSlaveSource, whoisSlaveDataSource));
            } else {
                final String grsSlaveUrl = createGrsUrl(grsSlaveBaseUrl, grsSourceName);
                final DataSource grsSlaveDataSource = dataSourceFactory.createDataSource(grsSlaveUrl, whoisSlaveUsername, whoisSlavePassword);
                sourceConfigurations.put(grsSlaveSource, new SourceConfiguration(grsSlaveSource, grsSlaveDataSource));

                final String grsMasterUrl = createGrsUrl(grsMasterBaseUrl, grsSourceName);
                final DataSource grsMasterDataSource = dataSourceFactory.createDataSource(grsMasterUrl, whoisMasterUsername, whoisMasterPassword);
                sourceConfigurations.put(grsMasterSource, new SourceConfiguration(grsMasterSource, grsMasterDataSource));
            }
        }

        final Iterable<CIString> mirrorSourceNameIterable = Iterables.transform(Splitter.on(',').split(mirrorSourceNames), new Function<String, CIString>() {
            @Nullable
            @Override
            public CIString apply(final String input) {
               return ciString(input);
            }
        });


        for (final CIString mirrorSourceName : mirrorSourceNameIterable) {

            mirrorSources.add(mirrorSourceName);

            final Source mirrorMasterSource = Source.master(mirrorSourceName);
            final Source mirrorSlaveSource = Source.slave(mirrorSourceName);

            if (mirrorSourceName.contains(mainSourceName)) {
                LOGGER.info("Delegating source {} to {}", mirrorSourceName, mainSourceName);
                aliases.put(mirrorSourceName, slaveSource.getName());
                sourceConfigurations.put(mirrorMasterSource, new SourceConfiguration(mirrorMasterSource, whoisMasterDataSource));
                sourceConfigurations.put(mirrorSlaveSource, new SourceConfiguration(mirrorSlaveSource, whoisSlaveDataSource));
            } else {
                final String mirrorSlaveUrl =  createMirrorUrl(mirrorSlaveBaseUrl, mirrorSourceName);
                final DataSource mirrorSlaveDataSource = dataSourceFactory.createDataSource(mirrorSlaveUrl, whoisSlaveUsername, whoisSlavePassword);
                sourceConfigurations.put(mirrorSlaveSource, new SourceConfiguration(mirrorSlaveSource, mirrorSlaveDataSource));

                final String mirrorMasterUrl = createMirrorUrl(mirrorMasterBaseUrl, mirrorSourceName);
                final DataSource mirrorMasterDataSource = dataSourceFactory.createDataSource(mirrorMasterUrl, whoisMasterUsername, whoisMasterPassword);
                sourceConfigurations.put(mirrorMasterSource, new SourceConfiguration(mirrorMasterSource, mirrorMasterDataSource));
            }
        }

        this.grsSourceNames = Collections.unmodifiableSet(grsSources);
        this.mirrorSourceNames = Collections.unmodifiableSet(mirrorSources);
        this.aliases = Collections.unmodifiableMap(aliases);
        this.allSourceNames = Collections.unmodifiableSet(Sets.newLinkedHashSet(Iterables.transform(sourceConfigurations.keySet(), new Function<Source, CIString>() {
            @Nullable
            @Override
            public CIString apply(final Source source) {
                return source.getName();
            }
        })));

        LOGGER.info("Using sources: {}", sourceConfigurations.keySet());
    }

    private String createGrsUrl(final String baseUrl, final CIString sourceName) {
        return String.format("%s_%s", baseUrl, sourceName.toString().replace('-', '_'));
    }

    private String createMirrorUrl(final String baseUrl, final CIString sourceName) {
        return String.format("%s_%s", baseUrl, sourceName.toString().replace('-', '_'));
    }

    public SourceConfiguration getCurrentSourceConfiguration() {
        return getCurrentConfiguration();
    }

    public Collection<SourceConfiguration> getAllSourceConfigurations() {
        return sourceConfigurations.values();
    }

    public SourceConfiguration getSourceConfiguration(final Source source) {
        final SourceConfiguration sourceConfiguration = sourceConfigurations.get(source);
        if (sourceConfiguration == null) {
            throw new SourceNotConfiguredException(source.toString());
        }

        return sourceConfiguration;
    }

    @PreDestroy
    public void destroyDataSources() {
        for (final SourceConfiguration sourceConfig : sourceConfigurations.values()) {
            try {
                DataSources.destroy(sourceConfig.getDataSource());
            } catch (SQLException e) {
                LOGGER.error("Destroying datasource", e);
            }
        }
    }

    public Set<CIString> getAllSourceNames() {
        return allSourceNames;
    }

    public Set<CIString> getGrsSourceNames() {
        return grsSourceNames;
    }

    public Set<CIString> getMirrorSourceNames() {
        return mirrorSourceNames;
    }

    @CheckForNull
    public CIString getAlias(final CIString source) {
        return aliases.get(source);
    }

    public void setCurrentSourceToWhoisMaster() {
        setCurrent(masterSource);
    }

    public void setCurrent(final Source source) {
        final SourceConfiguration sourceConfiguration = sourceConfigurations.get(source);
        if (sourceConfiguration == null) {
            throw new SourceNotConfiguredException(source.getName().toString());
        }

        current.set(sourceConfiguration);
    }

    public Source getWhoisSlaveSource() {
        return slaveSource;
    }

    public Source getCurrentSource() {
        return getCurrentConfiguration().getSource();
    }

    public void removeCurrentSource() {
        current.remove();
    }

    SourceConfiguration getCurrentConfiguration() {
        final SourceConfiguration sourceConfiguration = current.get();
        if (sourceConfiguration == null) {
            return sourceConfigurations.get(masterSource);
        }

        return sourceConfiguration;
    }

    public boolean isAcl() {
        return !grsSourceNames.contains(getCurrentSource().getName());
    }

    public boolean isDummificationRequired() {
        final CIString sourceName = getCurrentSource().getName();
        return grsSourceNames.contains(sourceName);
    }
}
