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
            <hr>
            <form action = "EmpleadoServlet" method="post" >
                <input type="text" name="login_usuario" placeholder="Login del usuario" required>
                <input type="submit" name="accion_empleado" class="login login-submit" value="Ver pedidos de usuario">
            </form>
            <hr>
            <form action = "EmpleadoServlet" method="post" >
                <input type="text" name="numero_pedido" placeholder="Numero del pedido" required>
                <select name="estado">
                    <option value="Pendiente" selected="selected">Pendiente</option>
                    <option value="Tramitado">Tramitado</option>
                    <option value="Completado">Completado</option>
                    <option value="Servido">Servido</option>
                    <option value="Facturado">Facturado</option>
                    <option value="Abonado">Abonado</option>
                </select>
                <input type="submit" name="accion_empleado" class="login login-submit" value="Cambiar estado de pedido">
            </form>
        </div>
    </body>
</html>
