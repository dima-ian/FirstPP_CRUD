package util;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

//import org.apache.tomcat.jdbc.pool.DataSource;
//import org.apache.tomcat.jdbc.pool.PoolProperties;

public class DBHelper {

    private DBHelper() { }

    private static DBHelper dbHelper;

    @Resource(name = "jdbc/ppf")
    private DataSource ds;


    public static DBHelper getInstance() {
        if (dbHelper == null) {
            dbHelper = new DBHelper();
        }
        return dbHelper;
    }

    public Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("crud_hiber_dm?").          //db name
                    append("user=root&").          //login
                    append("password=q1&").       //password
                    append("serverTimezone=UTC");

            System.out.println("URL: " + url + "\n");

            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }



        public Connection getTrueMysqlConnection() {

            Connection conn = null;

            try {
                // check datasource
                System.out.println("ds=" + ds);
                conn = ds.getConnection();
                System.out.println("ds.getConnection()=" + conn);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }

}
