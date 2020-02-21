package util;

import entities.User;
import model.Car;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbMngr {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = createSessionFactory();
        }
        return sessionFactory;
    }

    private static SessionFactory createSessionFactory() {
        Configuration configuration = getMySqlConfiguration();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    @SuppressWarnings("UnusedDeclaration")
    private static Configuration getMySqlConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Car.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");

        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");

        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test?useUnicode=true&serverTimezone=UTC&useSSL=false");

        configuration.setProperty("hibernate.connection.username", "root");

        configuration.setProperty("hibernate.connection.password", "q1");

        configuration.setProperty("hibernate.show_sql", "true");

        configuration.setProperty("hibernate.hbm2ddl.auto", "create");

        return configuration;
    }

    public static SessionFactory getSessionFactorySide() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                //configuration.addAnnotatedClass(Auto.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_hiber_dm", "root", "q1");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); return null;
        }
    }
}
