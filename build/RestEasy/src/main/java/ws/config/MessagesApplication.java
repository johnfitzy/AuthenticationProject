package ws.config;

import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class MessagesApplication extends Application {

    public MessagesApplication() {
        super();
    }
}
