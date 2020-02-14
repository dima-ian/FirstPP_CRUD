import util.DBHelper;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class TestMain {

    public static void main(String[] args) throws Exception {


        DBHelper dbHelper = DBHelper.getInstance();
        Connection conn = dbHelper.getMysqlConnection();

        System.out.println(conn.getCatalog());
        System.out.println(conn.getSchema());
        System.out.println(conn.getClientInfo().toString());

    }

}
