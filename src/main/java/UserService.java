import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;

//@Named(value = "userSerivce")
@ApplicationScoped
public class UserService implements Serializable {

    @EJB(beanName = "userDao")
    private UserDao userDao;


    public boolean createNewUse() {
        return true;
    }


    public Userdetails authenticate() {
        return null;
    }

}
