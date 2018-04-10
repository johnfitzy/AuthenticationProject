package ws.repository;

import ws.error.ClientNotFoundException;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class ClientRepositoryImp implements Serializable, ClientRepository {

    @Inject
    JDBIProducer jdbi;

    @Override
    public String getExistingClientApiKey(final String clientId) throws ClientNotFoundException {
        return jdbi.getJdbi()
                .withHandle(handle -> handle.createQuery("SELECT client_secret FROM clientApp where client_id = ?")
                        .bind(0, clientId)
                        .mapTo(String.class)
                        .findFirst()).orElseThrow(ClientNotFoundException::new);

    }
}
