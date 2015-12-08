<%-- 
    Document   : pedidosusuario
    Created on : 30-nov-2015, 14:02:34
    Author     : Miguel
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <%
            List<ws.Pedido> listaPedidosUsuario = (List<ws.Pedido>) session.getAttribute("listaPedidosUsuario");
            int flag = 0;
            for (ws.Pedido pedido : listaPedidosUsuario) {
                flag = 1;
        %>
        <div class="login-card">
            <h5>NPedido=<%=pedido.getNumero()%>  Abonado=<%=pedido.getNif()%>  Importe=<%=pedido.getImporte()%></h5>
            <h5>Fecha de entrega=<%=pedido.getFechaentrega()%></h5>
            <h5>Nota: <%=pedido.getNotaentrega()%></h5>
        </div>
        <%
            }
            if (flag == 0) {
        %>
        <div class="login-card">
            <h5>El usuario no tiene pedidos</h5>
        </div>
        <%
            }
        %>
        <div class="login-card">
            <form action="CarroServlet" method="post">
                <input type="submit" name="accion_carro" class="login login-submit" value="Cerrar sesión">
            </form>
        </div>
    </body>
</html>
