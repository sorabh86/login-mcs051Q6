/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorabh86.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sorabh86 <ssorabh.ssharma@gmail.com>
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/site"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if(action == null) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else if (action.matches("login")) {

            request.setAttribute("email", "");
            request.setAttribute("errormessage", "");

            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else if (action.matches("products")) {
            request.getRequestDispatcher("/products.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        String action = request.getParameter("action");

        if(action == null) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else if(action.equals("dologin")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            request.setAttribute("email", email);

//            User user = new User(email, password);

//            if(user.validate()) {
                
                if(DBConnect.connect()) {

                    try {
                        String sql = "SELECT count(*) as count FROM users WHERE username=? AND password=?";
                        PreparedStatement stmt = DBConnect.getConnection().prepareStatement(sql);
                        
                        stmt.setString(1, email);
                        stmt.setString(2, password);
                        
                        ResultSet rs = stmt.executeQuery();
                        
                        if(rs.next()) {
                            request.getRequestDispatcher("/products.jsp").forward(request, response);
                        } else {
                            request.setAttribute("errormessage", "No User and Password Found");

                            request.getRequestDispatcher("/login.jsp").forward(request, response);
                        }
                        
                        DBConnect.disconnect();
                    } catch (SQLException ex) {
                        request.setAttribute("errormessage", ex.getMessage());

                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("errormessage", "could not connect to server");

                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
                
//            } else {
//                request.setAttribute("errormessage", user.getMessage());
//
//                request.getRequestDispatcher("/login.jsp").forward(request, response);
//            }
        } else if(action.equals("dofeedback")) {
            String feedback = request.getParameter("feedback");
            
            if(feedback.matches("")) {
                request.setAttribute("error", "Feedback message is blank.");
            } else {
                request.setAttribute("success", "Feedback successfully submitted.");
            }
            //response.sendRedirect("site?action=products");
            request.getRequestDispatcher("/products.jsp").forward(request, response);
        }

    }

}
