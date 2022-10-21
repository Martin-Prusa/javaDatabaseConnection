package cz.martin;

import jakarta.enterprise.context.ApplicationScoped;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Service {
    private MySQLConnect con = new MySQLConnect();

    public List<String> getAllAnimals() {
        List<String> list = new ArrayList<>();
        try {
            PreparedStatement statement = con.connect().prepareStatement("SELECT * FROM Druhy;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.disconnect();
        }
        return list;
    }

    /*public void printData() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Druhy;");
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }*/
}
