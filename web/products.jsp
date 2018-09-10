<%-- 
    Document   : products
    Created on : Sep 7, 2018, 1:51:44 AM
    Author     : Sorabh86 <ssorabh.ssharma@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="fullheight">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body class="fullheight">
        <%@include file="/templates/navigation.html" %>
        <div class="container">
            <div class="content">
                <h1>Give Feedback on following Product</h1>
                <div class="product-list">
                    <div class="product">
                        <h3>Product 1</h3>
                        <p>Description of product 1</p>
                        <form action="site" method="post">
                            <input type="hidden" name="action" value="dofeedback">
                            <% String error = (String)request.getAttribute("error");
                            if(error != null) {%>
                                <p class="error"><%= error %></p>
                            <% } 
                            String success = (String)request.getAttribute("success");
                            if(success != null) { %>
                                <p class="success"><%= success %></p>
                            <% } %>
                            <div class="form-group">
                                <label>Your Feedback :</label>
                                <textarea name="feedback" class="form-control" rows="5" placeholder="Write your feedback here"></textarea>
                            </div>
                            <button class="btn" type="submit">submit</button>
                            
                        </form>
                    </div>
                    
                </div>
            </div>
        </div>
    </body>
</html>
