package dao;

import java.sql.Connection;

public class UsersDAO {

    private Connection conn;

    public UsersDAO(Connection conn) {
        this.conn = conn;
    }
}
