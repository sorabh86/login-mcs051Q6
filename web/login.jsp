<%-- 
    Document   : login
    Created on : Sep 7, 2018, 1:01:00 AM
    Author     : Sorabh86 <ssorabh.ssharma@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <style>
            *{margin:0;padding:0;}
            html,body{background:#f1f1f1;font-family:monospace;font-size:15px;}
            form{width:340px;margin:30px auto;background:#ddd;padding:20px;border-radius:8px;}
            form h1{margin:0 0 20px;padding-bottom:10px;border-bottom:1px solid #fff;}
            label,input{display:inline-block;box-sizing:border-box;padding:5px}
            label{width:100px;text-align:right;}
            input[type=text],input[type=password]{width:220px;}
            input[type=submit]{margin-left:110px;padding:10px 20px}
        </style>
    </head>
    <body>
        <%@include file="templates/navigation.html" %>
        <form action="/MCS051LoginQ6/site" method="post">
            <h1>Login</h1>
            <input type="hidden" name="action" value="dologin">
            <% if(request.getAttribute("errormessage") != "") { %>
                <h6 class="error"><%= request.getAttribute("errormessage") %></h6>
            <% } %>
            <div class="form-group">
                <label>Email : </label> 
                <input type="text" name="email" value="<%= request.getAttribute("email") %>">
            </div>
            <div class="form-group">
                <label>Password : </label>
                <input type="password" name="password">
            </div>
            <input class="btn" type="submit" value="login">
        </form>
    </body>
</html>
