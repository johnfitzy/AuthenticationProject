package ws.filter;

import ws.annotations.MessageFilterMapper;
import ws.error.ClientNotFoundException;
import java.io.IOException;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import ws.service.KeyService;

@Provider
@Priority(value = 1)
@MessageFilterMapper
public class MessageFilter implements ContainerRequestFilter {

    @Inject
    KeyService keyService;

    private final static String X_CLIENT_SECRET = "x-client-secret";
    private final static String X_CLIENT_ID = "x-client-id";
    private final static int FIRST_ELEMENT = 0;


    @Override
    public void filter(final ContainerRequestContext containerRequestContext) throws IOException {

        final MultivaluedMap<String, String> headers = containerRequestContext.getHeaders();

        if (!headers.containsKey(X_CLIENT_ID) || !headers.containsKey(X_CLIENT_SECRET)) {
            containerRequestContext.abortWith(Response.status(Response.Status.BAD_REQUEST).entity("No client id or api key in request").build());
            return;
        }

        try {

            final String clientId = headers.get(X_CLIENT_ID).get(FIRST_ELEMENT);
            final String clientSecret = headers.get(X_CLIENT_SECRET).get(FIRST_ELEMENT);

            if (!isApiKeyMatch(clientId, clientSecret)) {
                containerRequestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("You don't have authorisation to use this webservice").build());
            }

        } catch (ClientNotFoundException e) {
            containerRequestContext.abortWith(Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build());
            e.printStackTrace();
        }
    }

    private boolean isApiKeyMatch(final String clientId, final String clientSecret) throws ClientNotFoundException {
        return keyService.authenticateClientId(clientId, clientSecret);
    }
}
