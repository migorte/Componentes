<%-- 
    Document   : empleado
    Created on : 28-nov-2015, 20:28:59
    Author     : Miguel Ortega
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
            <form action = "EmpleadoServlet" method="post" >
                <input type="submit" name="accion_empleado" class="login login-submit" value="Ver pedidos pendientes">
            </form>
            <form action = "EmpleadoServlet" method="post" >
                <input type="text" name="login_usuario" placeholder="Login del usuario">
                <input type="submit" name="pedidos_usuario" class="login login-submit" value="Ver pedidos de usuario">
            </form>
            <form action = "EmpleadoServlet" method="post" >
                <input type="submit" name="cambiar_estado" class="login login-submit" value="Cambiar estado de pedido">
            </form>
        </div>
    </body>
</html>
