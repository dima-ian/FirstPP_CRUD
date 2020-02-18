package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbMngr {

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
