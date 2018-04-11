package jdbi.services;

import javax.inject.Inject;
import jdbi.JDBIProducer;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class User {

    @Inject
    private JDBIProducer jdbiProducer;

    private static final String GET_USER_PASSWORD = "SELECT password FROM users WHERE username = ?";

    private static final String CREATE_USER = "INSERT INTO users (`username`, `fname`, `lname`, `password`) \n"
            + "VALUES(?, ?, ?, ?)";


    public String getUserPassword(final String userNameEmail) {

        return jdbiProducer.getJdbi().withHandle(handle ->
                handle.createQuery(GET_USER_PASSWORD)
                        .bind(0, userNameEmail)
                        .mapTo(String.class)
                        .findFirst())
                .orElseGet(null);
    }


    public void persistUserCredentials(final String userNameEmail, final String firstName, final String lastName, final String password) {
        jdbiProducer.getJdbi().useHandle(handle -> handle.execute(CREATE_USER, userNameEmail, firstName, lastName, password));
    }
}
