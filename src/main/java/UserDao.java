public interface UserDao extends BaseDao {
    Userdetails getUserDetailsByUserName(String userName);

    Userdetails getUserById(Integer id);

}
