package dao;

import entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private Connection conn;

    public UserDAO(Connection conn) {
        this.conn = conn;
    }

    public Connection getConnection() {
        return conn;
    }

    public void addClient(User user) throws SQLException {
        String sql = "INSERT INTO users (name, sex, age, email, ssn) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getSex());
        preparedStatement.setByte(3, user.getAge());
        preparedStatement.setString(4, user.getEmail());
        preparedStatement.setString(5, user.getSsn());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public boolean deleteUser(String ssn) throws SQLException {
        try {
            User usr = getUserBySsn(ssn);
            System.out.println(usr.toString());

            PreparedStatement preStmt = conn.prepareStatement("DELETE FROM users WHERE id = ?");
            preStmt.setLong(1, usr.getId());
            preStmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {throw new SQLException("Failed to delete the client!"); }
    }

    public void updateUserzData(User user) throws SQLException {

        User usr = getUserBySsn(user.getSsn());

        PreparedStatement preStmt = conn.prepareStatement("UPDATE users SET name=?, sex=?, age=?, email=? WHERE ssn=? " );
        if ( validateUser(usr.getSsn())) {
            //preStmt.setString(6, );
            //preStmt.setLong(1, usr.getId());
            preStmt.setString(1, user.getName());
            preStmt.setString(2, user.getSex());
            preStmt.setByte(3, user.getAge());
            preStmt.setString(4, user.getEmail());
            preStmt.setString(5, usr.getSsn());
            preStmt.executeUpdate();
            System.out.println("User's data updated.");
        } else {
            System.out.println("Upaditing failed...");
        }
        preStmt.close();
    }

    public List<User> getAllUsers() throws SQLException {

        List<User> list = new ArrayList<>();
        Statement stmt = conn.createStatement();
        stmt.execute("select * from users");
        ResultSet result = stmt.getResultSet();

        result.last();
        long endOfList = result.getRow();
        result.first();

        for (int i = 1; i <= endOfList; i++) {

            list.add(new User(
                    result.getLong("id"),
                    result.getString("name"),
                    result.getString("sex"),
                    result.getByte("age"),
                    result.getString("email"),
                    result.getString("ssn")));
            result.next();
        }
        result.close();
        stmt.close();

        return list;
    }

    public User getUserBySsn(String ssn) throws SQLException {

        Statement stmt = conn.createStatement();
        stmt.execute("select * from users where `ssn` = '" + ssn + "'");
        ResultSet result = stmt.getResultSet();
        result.next();
        User usr = new User(
                result.getLong("id"),
                result.getString("name"),
                result.getString("sex"),
                result.getByte("age"),
                result.getString("email"),
                result.getString("ssn"));
        stmt.close();
        return usr;
    }

    public boolean validateUser(String ssn) throws SQLException {

        User usr = null;
        Statement stmt = conn.createStatement();
        stmt.execute("select * from users where ssn='" + ssn + "'");
        ResultSet rs = stmt.getResultSet();
        while (rs.next()){
            usr = new User( rs.getLong(1), rs.getString(2), rs.getString(3), rs.getByte(4), rs.getString(5), rs.getString(6));
        }
        rs.close(); stmt.close();

        if (usr != null && usr.getSsn().equals(ssn)) return true;
        else return false;
    }

}
