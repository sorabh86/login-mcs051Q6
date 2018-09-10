
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sorabh86.controller.DBConnect;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sorabh86 <ssorabh.ssharma@gmail.com>
 */
public class TestDBConnection {
    
    public static void main(String[] args) {
        System.out.println("running...");
        
        PreparedStatement smt;
        if(DBConnect.connect()) {
            System.out.println("pass connection...");
            try {
                smt = DBConnect.getConnection().prepareStatement("SELECT * FROM users");
                
                ResultSet result = smt.executeQuery();
                
                System.out.println("result: "+result.next());
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("Database is Connected!!");
        }
        
        
        
        DBConnect.disconnect();
    }
}
