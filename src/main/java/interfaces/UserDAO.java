package interfaces;

import entities.User;
import java.util.List;

public interface UserDAO {

    void addUser(User user);
    boolean deleteUser(String ssn);
    void updateUserzData(User user);
    List<User> getAllUsers();
    User getUserBySsn(String ssn);
    boolean validateUser(String ssn);

}
