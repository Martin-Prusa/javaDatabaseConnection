package cz.martin;

import java.sql.*;

public class MySQLConnect {

    private Connection con;

    public Connection connect() {
        if(con == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/zoo", "root", "password");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }

    public void disconnect() {
        if (con != null) {
            try {
                con.close();
                con = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
