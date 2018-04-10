package service.register;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import jdbi.services.Application;
import java.security.SecureRandom;
import javax.inject.Inject;
import org.apache.commons.lang3.RandomStringUtils;

final class RandomCredentialGenerator {

    @Inject
    Application applicationDao;

    private static final String PASSWORD_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";

    private static final int PASSWORD_LENGTH = 60;

    private static final String CLIENT_ID_CHARS = "abcdefghijklmnopqrstuvwxyz0123456789";

    private static final int CLIENT_ID_LENGTH = 32;


    //TODO: there is no check to see if the password generated is unique, although chances are it will be.
    String generateRandomPassword() {
        char[] possibleCharacters = (PASSWORD_CHARS).toCharArray();
        return RandomStringUtils.random(PASSWORD_LENGTH, 0, possibleCharacters.length - 1, false, false, possibleCharacters, new SecureRandom());
    }

    String generateRandomClientId() {

        boolean clientIdUnique = false;
        String clientId = "";

        while (!clientIdUnique) {
            clientId = RandomStringUtils.random(CLIENT_ID_LENGTH, CLIENT_ID_CHARS);
            if(applicationDao.clientIdIsUnique(clientId)) {
                clientIdUnique = true;
            }
        }

        return clientId;
    }
}
