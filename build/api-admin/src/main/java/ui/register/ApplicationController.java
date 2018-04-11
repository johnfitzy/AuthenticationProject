package ui.register;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import jdbi.services.Application;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import service.register.ApplicationService;

@Named
@RequestScoped
public class ApplicationController {

    @Inject
    ApplicationBean applicationBean;

    @Inject
    ApplicationService applicationService;

    @Inject
    Application applicationDao;

    public void create() {

        if (applicationDao.applicationDoesNotExist(applicationBean.getApplicationName())) {
            createAndStoreAppCredentials();
        } else {
            updateMessage(FacesMessage.SEVERITY_ERROR, "Error",  "Dang it! There seems to already be an application called: " + applicationBean.getApplicationName());
        }
    }

    //TODO: rename some of these methods
    private void createAndStoreAppCredentials() {

        final ApplicationCredentials applicationCredentials = applicationService.registerApplication(applicationBean.getApplicationName());

        if (applicationCredentials != null) {

            applicationBean.setClientId(applicationCredentials.getClientId());
            applicationBean.setApplicationName(applicationCredentials.getAppName());
            applicationBean.setClientSecret(applicationCredentials.getClientSecret());
            applicationBean.setShowResult();

            updateMessage(FacesMessage.SEVERITY_INFO, "Success!",  "You have successfully registered your application!");

        }
    }

    private void updateMessage(final FacesMessage.Severity severity, final String summary, final String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(severity, summary, message) );
    }
}
