import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 *
 */
@ApplicationScoped
public class AuthenticationController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());


    @Inject
    UserService userService;


    private Userdetails user;


    public String authenticate() {
        logger.debug("Got request to Authenticate ");
        Userdetails userdetails = userService.authenticate();
        if (userdetails != null) {
            this.user = userdetails;
            return "success";
        } else {
            return "index";
        }

    }

    @Produces
    @SessionScoped

    public Userdetails getLoggedUser() {
        return this.user;
    }

}
