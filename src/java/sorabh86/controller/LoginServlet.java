/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorabh86.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sorabh86.beans.User;

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

        String action = request.getParameter("action");

        if(action == null) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else if(action.equals("dologin")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            request.setAttribute("email", email);

            User user = new User(email, password);

            if(user.validate()) {
                request.getRequestDispatcher("/products.jsp").forward(request, response);
            } else {
                request.setAttribute("errormessage", user.getMessage());

                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
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
