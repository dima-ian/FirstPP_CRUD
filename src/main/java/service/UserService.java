package service;

import dao.UserDAO;
import entities.User;
import exception.DBException;
import util.DBHelper;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    public UserService() {  }

    public boolean addClient(User user)  {

        try {
            UserDAO dao = getUserDAO();

            if (dao.validateUser(user.getSsn())) {
                return false;
            }
            else { dao.addClient(user);
                   return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean updateUser(User user) {
        System.out.println("Updating data is: " + user.toString());

        try {
            if (user != null) {
                System.out.println("Valid user - OK.");
                getUserDAO().updateUserzData(user);
                return true;
            } else {
                System.out.println("No this SSN found!");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public boolean deleteUser(String ssn) {
        System.out.println("SSN deleting = " + ssn);

        try {
            User usr = getUserDAO().getUserBySsn(ssn);
            System.out.println(usr.toString());

            if (usr != null) {
                System.out.println("Valid user - OK.");
                getUserDAO().deleteUser(ssn);
                return true;
            } else {
                System.out.println("No this SSN found!");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<User> getAllUsers() {
        try {
            return getUserDAO().getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static UserDAO getUserDAO() {
        return new UserDAO(DBHelper.getInstance().getMysqlConnection());
    }


}
