package service;

import dao.UserDAO;
import entities.User;
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
        try {
            if (user != null) {
                getUserDAO().updateUserzData(user);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(String ssn) {
        try {
            User usr = getUserDAO().getUserBySsn(ssn);
            if (usr != null) {
                getUserDAO().deleteUser(ssn);
                return true;
            } else {
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
