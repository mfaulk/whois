package net.ripe.db.whois.api.whois.rdap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import net.ripe.db.whois.api.AbstractRestClientTest;
import net.ripe.db.whois.api.httpserver.Audience;
import net.ripe.db.whois.api.whois.rdap.domain.Error;
import net.ripe.db.whois.common.IntegrationTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

@Category(IntegrationTest.class)
public class RdapErrorTestIntegration extends AbstractRestClientTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RdapErrorTestIntegration.class);
    private static final Audience AUDIENCE = Audience.PUBLIC;
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final RdapJsonProvider rdapJsonProvider = new RdapJsonProvider();

    @Before
    public void setup() throws Exception {
        databaseHelper.addObject("" +
                "person: Test Person\n" +
                "nic-hdl: TP1-TEST");
        databaseHelper.addObject("" +
                "mntner:        OWNER-MNT\n" +
                "descr:         Owner Maintainer\n" +
                "admin-c:       TP1-TEST\n" +
                "upd-to:        noreply@ripe.net\n" +
                "auth:          MD5-PW $1$d9fKeTr2$Si7YudNf4rUGmR71n/cqk/ #test\n" +
                "mnt-by:        OWNER-MNT\n" +
                "referral-by:   OWNER-MNT\n" +
                "changed:       dbtest@ripe.net 20120101\n" +
                "source:        TEST");
        databaseHelper.updateObject("" +
                "person:        Test Person\n" +
                "address:       Singel 258\n" +
                "phone:         +31 6 12345678\n" +
                "nic-hdl:       TP1-TEST\n" +
                "mnt-by:        OWNER-MNT\n" +
                "changed:       dbtest@ripe.net 20120101\n" +
                "source:        TEST\n");
        databaseHelper.addObject("" +
                "person:        Test Person2\n" +
                "address:       Test Address\n" +
                "phone:         +61-1234-1234\n" +
                "e-mail:        noreply@ripe.net\n" +
                "mnt-by:        OWNER-MNT\n" +
                "nic-hdl:       TP2-TEST\n" +
                "changed:       noreply@ripe.net 20120101\n" +
                "source:        TEST\n");
        databaseHelper.addObject("" +
                "person:        Pauleth Palthen\n" +
                "address:       Singel 258\n" +
                "phone:         +31-1234567890\n" +
                "e-mail:        noreply@ripe.net\n" +
                "mnt-by:        OWNER-MNT\n" +
                "nic-hdl:       PP1-TEST\n" +
                "changed:       noreply@ripe.net 20120101\n" +
                "changed:       noreply@ripe.net 20120102\n" +
                "changed:       noreply@ripe.net 20120103\n" +
                "remarks:       remark\n" +
                "source:        TEST\n");
    }

    @Before
    @Override
    public void setUpClient() throws Exception {
        ClientConfig cc = new DefaultClientConfig();
        cc.getSingletons().add(rdapJsonProvider);
        client = Client.create(cc);
    }

    @Test
    public void double_slash() {
        final ClientResponse error = createResource(AUDIENCE, "/rdap/entity/PP1-TEST")
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);
        assertThat(error.getStatus(), is(Response.Status.NOT_FOUND.getStatusCode()));

        final ClientResponse error2 = createResource(AUDIENCE, "rdap//entity/PP1-TEST")
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);
        assertThat(error2.getStatus(), is(Response.Status.NOT_FOUND.getStatusCode()));
    }

    @Test
    public void explicit_error_handling_preserved() {
        final ClientResponse clientResponse = createResource(AUDIENCE, "whois/search?query-string=TP1-TEST&source=INVALID")
                .get(ClientResponse.class);
        assertThat(clientResponse.getStatus(), is(Response.Status.BAD_REQUEST.getStatusCode()));
        System.err.println(clientResponse.getEntity(String.class));
        boolean unableToParse = false;
        try {
            Error error = clientResponse.getEntity(Error.class);
        } catch (Exception e) {
            unableToParse = true;
        }
        assertThat(unableToParse, is(true));
    }

    @Test
    public void implicit_error_handling_preserved() {
        final ClientResponse clientResponse = createResource(AUDIENCE, "whois/lookup/test/person//PP1-TEST")
                .get(ClientResponse.class);
        // Tom says "Technically speaking (according to the spec) this should be a 400, but the test in our (APNIC) repository
        // was passing when it checked for 404 (i.e. prior to the merge of upstream), and we are unsure as to why it is now
        // returning 400 in this case. However, it's not worth investigating at the moment (not a big deal), let alone that
        // this behaviour is 'more correct' anyway."
        assertThat(clientResponse.getStatus(), is(Response.Status.BAD_REQUEST.getStatusCode()));
        System.err.println(clientResponse.getEntity(String.class));
        boolean unableToParse = false;
        try {
            Error error = clientResponse.getEntity(Error.class);
        } catch (Exception e) {
            unableToParse = true;
        }
        assertThat(unableToParse, is(true));
    }

    @Test
    public void malformed_url() throws Exception {
        Socket socket = new Socket("localhost", getPort(AUDIENCE));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF8"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bufferedWriter.write("GET /rdap/ip/[::] HTTP/1.0\n\n");
        bufferedWriter.flush();

        StringBuilder response = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            response.append(line);
            response.append('\n');
        }

        String responseStr = response.toString();
        assertThat(responseStr, containsString(Response.Status.BAD_REQUEST.getStatusCode() + " " + Response.Status.BAD_REQUEST));
    }

    @Override
    protected WebResource createResource(final Audience audience, final String path) {
        WebResource resource = client.resource(String.format("http://localhost:%s/%s", getPort(audience), path));
        LOGGER.info("resource [" + resource.getURI().toASCIIString() + "]");
        return resource;
    }
}
