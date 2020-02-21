package service;

import dao.UserHibernateDAO;
import entities.User;
import interfaces.UserDAO;

import java.util.List;

public class UserHibrService implements UserDAO {

    private static UserHibrService uhs;
    private static UserHibernateDAO uHbrDAO = new UserHibernateDAO();

    public static UserHibrService getInstance() {
        if (uhs == null) { uhs = new UserHibrService(); }
        return uhs;
    }

    @Override
    public List<User> getAllUsers() {
        return uHbrDAO.getAllUsers();
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public boolean deleteUser(String ssn) {
        return false;
    }

    @Override
    public void updateUserzData(User user) {

    }

    @Override
    public User getUserBySsn(String ssn) {
        return null;
    }

    @Override
    public boolean validateUser(String ssn) {
        return false;
    }
}
