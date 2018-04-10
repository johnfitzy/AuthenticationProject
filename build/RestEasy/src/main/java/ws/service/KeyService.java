package ws.service;

import java.util.Base64;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.mindrot.jbcrypt.BCrypt;
import ws.error.ClientNotFoundException;
import ws.repository.ClientRepositoryImp;

@Named
@RequestScoped
public class KeyService {

    @Inject
    ClientRepositoryImp clientRepositoryImp;

    public boolean authenticateClientId(final String clientId, final String clientSecretBase64) throws ClientNotFoundException {
        return BCrypt.checkpw(new String(Base64.getDecoder().decode(clientSecretBase64)),
                clientRepositoryImp.getExistingClientApiKey(new String(Base64.getDecoder().decode(clientId))));
    }
}
