
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        
        Statement smt;
        
        if(DBConnect.connect()) {
            try {
                smt = DBConnect.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                System.out.println("connected...");
                
                try (ResultSet rs = smt.executeQuery("select * from users")) {
                    
                    while(rs.next()) {
                        int id = rs.getInt("id");
                        String username = rs.getString("username");
                        String password = rs.getString("password");

                        System.out.println("set: id="+id+", username="+username+", password="+password);
                    }
                }
                
                DBConnect.disconnect();
                System.out.println("disconnected...");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("Database is Connected!!");
        }
    }
}
