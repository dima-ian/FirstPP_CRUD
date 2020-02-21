package dao;

import entities.User;
import interfaces.UserDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HiberConnector;

import java.util.List;

public class UserHibernateDAO implements UserDAO {

    private SessionFactory sesFact;

    public UserHibernateDAO() {
        this.sesFact = HiberConnector.getSessionFactory();
    }

    @Override
    public List<User> getAllUsers() {
        Session ses = sesFact.openSession();
        Transaction trx = ses.beginTransaction();
        List<User> usrs = (List<User>) ses.createQuery("From Users");
        trx.commit();
        ses.close();
        return usrs;
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
