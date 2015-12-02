<%-- 
    Document   : pedidospendientes
    Created on : 30-nov-2015, 13:20:58
    Author     : Miguel
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<ws.Pedido> listaPendientes = (List<ws.Pedido>) session.getAttribute("listaPendientes");
            int flag = 0;
            for (ws.Pedido pedido : listaPendientes) {
                flag = 1;
        %>
        <div class="login-card">
            <h5>NPedido=<%=pedido.getNumero()%>  Abonado=<%=pedido.getNif()%>  Importe=<%=pedido.getImporte()%></h5>
            <h5>Fecha de entrega=<%=pedido.getFechaentrega()%></h5>
            <h5>Nota=<%=pedido.getNotaentrega()%></h5>
        </div>
        <%
            }
            if (flag == 0) {
        %>
        <div class="login-card">
            <h5>No hay pedidos pendientes</h5>
        </div>
        <%
            }
        %>
    </body>
</html>
