/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorabh86.beans;

/**
 *
 * @author Sorabh86 <ssorabh.ssharma@gmail.com>
 */
public class User {
    private String email = "";
    private String password = "";
    private String message = "";

    public User() {
    }
    
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean validate() {
        if(email.equals("")) {
            message = "Email address is blank.";
            return false;
        } else {
        }
        if(password.equals("")) {
            message = "Password is blank.";
            return false;
        }
        
        if(!email.matches("^([a-zA-z0-9\\_\\.]+)@([a-zA-Z0-9\\-\\.]+)\\.([a-zA-Z]{2,5})$")) {
            message = "Invalid Email address.";
            return false;
        }
        
        if(password.length() < 8) {
           message = "Password must be at least 8 characters";
           return false;
        }
        
        return true;
    }
}
