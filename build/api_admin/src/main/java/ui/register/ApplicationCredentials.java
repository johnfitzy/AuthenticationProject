package ui.register;

/**
 *
 */
public class ApplicationCredentials {

    final private String clientId;
    final private String appName;
    final private String clientSecret;

    public ApplicationCredentials(final String clientId, final String appName, final String clientSecret) {
        this.clientId = clientId;
        this.appName = appName;
        this.clientSecret = clientSecret;
    }

    public String getClientId() {
        return clientId;
    }

    public String getAppName() {
        return appName;
    }

    public String getClientSecret() {
        return clientSecret;
    }
}
