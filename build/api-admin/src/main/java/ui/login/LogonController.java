package ui.login;

import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.webapp.FacesServlet;
import javax.inject.Inject;
import javax.inject.Named;
import service.login.UserCredentialService;
import service.properties.AppProperties;


@Named
@RequestScoped
public class LogonController {

    private static final String USER_AUTHENTICATED = "user_authenticated";
    private static final String LOGIN_PAGE = "login_page";


    @Inject
    UserCredentialBean userCredentialBean;

    @Inject
    UserCredentialService userCredentialService;

    public void login() {

        FacesContext facesContext = FacesContext.getCurrentInstance();

        if(userCredentialService.isUsernamePasswordMatch(userCredentialBean.getUsername(), userCredentialBean.getPassword())) {
            facesContext.getExternalContext().getSessionMap().put(AppProperties.getInstance().getProperty(USER_AUTHENTICATED), userCredentialBean.getUsername());
            try {
                facesContext.getExternalContext().redirect(AppProperties.getInstance().getProperty("register_application_page"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                facesContext.getExternalContext().redirect(AppProperties.getInstance().getProperty(LOGIN_PAGE));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void logout () {

        FacesContext facesContext = FacesContext.getCurrentInstance();

        if (facesContext.getExternalContext().getSessionMap().containsKey(AppProperties.getInstance().getProperty(USER_AUTHENTICATED))){
            facesContext.getExternalContext().getSessionMap().remove(AppProperties.getInstance().getProperty(USER_AUTHENTICATED));
            try {
                facesContext.getExternalContext().redirect(AppProperties.getInstance().getProperty(LOGIN_PAGE));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new RuntimeException("Something went bad!");
        }
    }
}
