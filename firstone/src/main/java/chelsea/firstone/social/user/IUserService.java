package chelsea.firstone.social.user;



import java.util.List;

public interface IUserService {


    List<User> getAllUsers();

    User getUserById(String id);

    boolean userExists(User user);

    void addNewUser(User user);

    void deleteAllUsers();

    void deleteById(String id);

    void updateUser(String id, User user);

}
