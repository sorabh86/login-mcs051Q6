/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorabh86.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sorabh86 <ssorabh.ssharma@gmail.com>
 */
public class DBConnect {
    
    private static final String USR = "HR";
    private static final String PASS = "hr";
    
    private static Connection conn;
    
    public static boolean connect() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", USR, PASS);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        
        return true;
    }
    
    public static Connection getConnection() {
        return conn;
    }
    
    public static void disconnect() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
