import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class NewUserController {

    @Inject
    private UserService userService;

    public void createNewUser() {
    }
}
