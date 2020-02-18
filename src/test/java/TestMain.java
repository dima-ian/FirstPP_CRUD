import entities.User;
import service.UserService;
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

//        User usr1 = new User("Fer11 Caz", "Male", (byte) 45, "fercaz@mail.ru", "AZ9487");
//        User usr2 = new User("ZZ3C Saz", "Male", (byte) 35, "zzz_1@mail.ru", "AZ9496");
//        User usr3 = new User("USR_3", "Male", (byte) 33, "usr_3@mail.ru", "USR3AZ3");
          User usr3 = new User("q2", "q2", (byte) 13, "q2@mail.ru", "qqq");

        UserService usrSrv = new UserService();

        //usrSrv.addClient(usr1);
        //usrSrv.addClient(usr3);

        //usrSrv.deleteUser("AZ987");

        usrSrv.updateUser(usr3);

    }

}
