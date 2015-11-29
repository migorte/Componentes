<%-- 
    Document   : login
    Created on : 28-nov-2015, 12:28:59
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div class="login-card">
            <h1>Acceso</h1><br>
            <form action = "LoginServlet" method="post" >
                <input name="login" type="text" placeholder="Nombre de usuario">
                <input name="password" type="password" placeholder="Contraseña">
                <input type="submit" name="login" class="login login-submit" value="Entrar">
            </form>
        </div>
    </body>
</html>
