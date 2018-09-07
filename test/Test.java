/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import sorabh86.beans.User;

/**
 *
 * @author Sorabh86 <ssorabh.ssharma@gmail.com>
 */
public class Test {
    public static void main(String[] args) {
        
        User user = new User("sorabh@fdkd.com", "hellosfds");
        
        if(!user.validate()) {
            System.out.println(user.getMessage());
        } else {
            System.out.println("Validation OK");
        }
    }
}
