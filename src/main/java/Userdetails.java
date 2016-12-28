import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userdetails")
/*@NamedQueries(
        @NamedQuery(name = "userDetails.findByUserName", query = "SELECT U FROM Userdetails U WHERE U.userId=:userName")

)*/
@Model
@SessionScoped
public class Userdetails implements Serializable {
    @Basic
    @Column(name = "userId", nullable = true, insertable = true, updatable = true, length = 20)
    private String userId;
    @Basic
    @Column(name = "userPassword", nullable = true, insertable = true, updatable = true, length = 20)
    private String userPassword;


    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private Address address;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Userdetails that = (Userdetails) o;

        if (id != that.id)
            return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null)
            return false;
        if (userPassword != null ? !userPassword.equals(that.userPassword) : that.userPassword != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
