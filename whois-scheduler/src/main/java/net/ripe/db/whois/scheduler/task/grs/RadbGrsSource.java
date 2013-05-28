package net.ripe.db.whois.scheduler.task.grs;

import com.google.common.base.Charsets;
import net.ripe.db.whois.common.DateTimeProvider;
import net.ripe.db.whois.common.grs.AuthoritativeResourceData;
import net.ripe.db.whois.common.io.Downloader;
import net.ripe.db.whois.common.source.SourceContext;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.zip.GZIPInputStream;

@Component
class RadbGrsSource extends GrsSource {
    private String download;

    @Value("${grs.import.radb.download:}")
    public void setDownload(final String download) {
        this.download = download;
    }

    @Autowired
    RadbGrsSource(
            @Value("${grs.import.radb.source:}") final String source,
            final SourceContext sourceContext,
            final DateTimeProvider dateTimeProvider,
            final AuthoritativeResourceData authoritativeResourceData) {
        super(source, sourceContext, dateTimeProvider, authoritativeResourceData);
    }

    @Override
    public void acquireDump(final File file) throws IOException {
        Downloader.downloadToFile(logger, new URL(download), file);
    }

    @Override
    public void handleObjects(final File file, final ObjectHandler handler) throws IOException {
        FileInputStream is = null;

        try {
            is = new FileInputStream(file);

            final BufferedReader reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(is), Charsets.UTF_8));
            handleLines(reader, new LineHandler() {
                @Override
                public void handleLines(final List<String> lines) {
                    if (!lines.isEmpty() && !lines.get(0).startsWith("*xx")) {
                        handler.handle(lines);
                    }
                }
            });
        } finally {
            IOUtils.closeQuietly(is);
        }
    }
}
