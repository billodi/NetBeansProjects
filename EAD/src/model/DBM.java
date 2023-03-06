package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Buddika Alwis
 */
public class DBM {

    public static Connection c;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:hms.db");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void iud(String query) throws SQLException {
        Statement s = c.createStatement();
        int x = s.executeUpdate(query);
        System.out.println(x);
    }

    public static ResultSet search(String query) throws SQLException {
        Statement s = c.createStatement();
        ResultSet r = s.executeQuery(query);
        return r;
    }
}
