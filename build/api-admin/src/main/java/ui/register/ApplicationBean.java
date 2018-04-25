package ui.register;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named
@RequestScoped
public class ApplicationBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String applicationName;
    private String clientId;
    private String clientSecret;
    private String commonName;
    private boolean isShowResult;

    public boolean isShowResult() {
        return isShowResult;
    }

    public void setShowResult() {
        isShowResult = true;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(final String applicationName) {
        this.applicationName = applicationName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(final String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(final String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(final String commonName) {
        this.commonName = commonName;
    }
}
