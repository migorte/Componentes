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
                <input name="login" type="text" placeholder="Nombre de usuario" required>
                <input name="password" type="password" placeholder="Contraseña" required>
                <input type="submit" name="accion" class="login login-submit" value="Entrar">
            </form>
            <hr>
            <form action="LoginServlet" method="post">
                <input type="submit" name="accion" class="login login-submit" value="Entrar como empleado">
            </form>
        </div>
    </body>
</html>
