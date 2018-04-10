package service.register;

import java.util.Base64;
import jdbi.JDBIProducer;
import jdbi.services.Application;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.mindrot.jbcrypt.BCrypt;
import ui.register.ApplicationCredentials;


@Named
@RequestScoped
public class ApplicationService {

    @Inject
    JDBIProducer jdbiProducer;

    @Inject
    RandomCredentialGenerator randomCredentialGenerator;

    @Inject
    Application applicationDao;

    public ApplicationCredentials registerApplication(final String appName) {

        final String clientSecret = randomCredentialGenerator.generateRandomPassword();
        final String clientSecretHash = BCrypt.hashpw(clientSecret, BCrypt.gensalt());
        final String clientId = randomCredentialGenerator.generateRandomClientId();

        if(applicationDao.persistApplication(appName, clientSecretHash, clientId) > 0){
            return new ApplicationCredentials(new String(Base64.getEncoder().encode(clientId.getBytes())),
                    appName, new String(Base64.getEncoder().encode(clientSecret.getBytes())));
        }

        return null;
    }
}
