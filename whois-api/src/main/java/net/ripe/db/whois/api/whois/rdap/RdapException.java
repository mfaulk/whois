package net.ripe.db.whois.api.whois.rdap;

import com.google.common.collect.Lists;
import net.ripe.db.whois.api.whois.rdap.domain.Error;
import net.ripe.db.whois.api.whois.rdap.NoticeFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.Response;
import java.util.List;

public class RdapException {

    public static Object build (final Response.StatusType status, final String selfUrl, final NoticeFactory noticeFactory) {
        return build(status, selfUrl, Lists.<String>newArrayList(), noticeFactory, false);
    }

    public static Object build (final Response.StatusType status, final String selfUrl, List<String> descriptions, final NoticeFactory noticeFactory, boolean suppressDefaultDescription) {
        final Error exception = new Error();
        exception.setErrorCode(status.getStatusCode());
        exception.setTitle(status.getReasonPhrase());
        exception.getRdapConformance().addAll(RdapObjectMapper.RDAP_CONFORMANCE_LEVEL);
        /* todo: This shouldn't be null. The check should only be here temporarily. */
        if (noticeFactory != null) {
            exception.getNotices().addAll(noticeFactory.generateResponseNotices(selfUrl));
        }

        if (!suppressDefaultDescription) {
            switch (status.getStatusCode()) {
                case 400:
                    exception.getDescription().add("The request could not be understood by the server due to malformed syntax.");
                    break;
                case 403:
                    exception.getDescription().add("Authorization required.");
                    break;
                case 404:
                    exception.getDescription().add("The server has not found anything matching the Request-URI.");
                    break;
                case 429:
                    exception.getDescription().add("Request limit exceeded for this resource. Please try again later.");
                    break;
                default:
                    exception.getDescription().add("The server encountered an unexpected condition which prevented it from fulfilling the request.");
                    break;
            }
        }
        exception.getDescription().addAll(descriptions);
        return exception;
    }
}
