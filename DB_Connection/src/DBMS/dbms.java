/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Buddika Alwis
 */
public class dbms {

    public static Connection c;
    public static String dbs;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3307/";
            String un = "root";
            String pw = "2000";
            c = DriverManager.getConnection(url+dbs+"?useSSL=false",un,pw);
        } catch (Exception e) {
            System.out.println("error");
        }
    }
    public static void iud(String query)throws Exception{
        Statement s = c.createStatement();
        int x = s.executeUpdate(query);
        System.out.println(x);
    }
    public static ResultSet search(String query)throws Exception{
        Statement s = c.createStatement();
        ResultSet r = s.executeQuery(query);
        return r;
    }
}
