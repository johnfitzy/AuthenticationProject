package jdbi.services;

import jdbi.JDBIProducer;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class Application {

    @Inject
    private JDBIProducer jdbiProducer;

    public boolean clientIdIsUnique(final String id) {

        final String clientID = jdbiProducer.getJdbi()
                .withHandle(handle ->
                        handle.createQuery("SELECT client_id FROM clientApp WHERE client_id = ?")
                                .bind(0, id)
                                .mapTo(String.class)
                                .findFirst().orElse(null));

        return clientID == null;

    }

    public boolean applicationDoesNotExist(final String appName) {

        final String currentApp = jdbiProducer.getJdbi()
                .withHandle(handle ->
                        handle.createQuery("SELECT app_name FROM clientApp WHERE app_name = ?")
                                .bind(0, appName)
                                .mapTo(String.class)
                                .findFirst().orElse(null));

        return currentApp == null;
    }

    public int persistApplication(final String appName, final String clientSecretHash, final String clientId) {
        return jdbiProducer.getJdbi()
                .withHandle(handle ->
                        handle.execute("INSERT INTO clientApp(client_id, app_name, client_secret) VALUES(?, ?, ?)",
                                clientId, appName, clientSecretHash));

    }
}
