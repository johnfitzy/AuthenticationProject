package ws.repository;

import ws.error.ClientNotFoundException;

public interface ClientRepository {
    String getExistingClientApiKey(final String clientId) throws ClientNotFoundException;
}
