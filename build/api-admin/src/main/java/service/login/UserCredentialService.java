package service.login;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import jdbi.services.User;
import org.mindrot.jbcrypt.BCrypt;


@Named
@RequestScoped
public class UserCredentialService {

    @Inject
    User user;

    public boolean isUsernamePasswordMatch(final String userName, final String password) {
        return BCrypt.checkpw(password, user.getUserPassword(userName));
    }
}
