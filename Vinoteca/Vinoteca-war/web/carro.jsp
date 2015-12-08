<%-- 
    Document   : carro
    Created on : 28-nov-2015, 22:53:17
    Author     : Miguel Ortega
--%>

<%@page import="java.util.ArrayList"%>
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
            List<Dominio.Referencia> carro = (List<Dominio.Referencia>) session.getAttribute("carro");
            List<Dominio.Vino> listaVinos = (List<Dominio.Vino>) session.getAttribute("listaVinos");
            int flag = 0;
            for (Dominio.Referencia referencia : carro) {
                flag = 1;
        %>
        <div class="login-card">
            <%
                for (Dominio.Vino vino : listaVinos) {
                    if (vino.getId().equals(referencia.getVinoid().getId())) {
            %>    
            <h5><%=vino.getNombrecomercial()%>  ||  <%=vino.getDenominacion()%>  ||  <%=vino.getCategoria()%>  ||  <%=vino.getAnyo()%></h5>
            <p>Contenido: <%=referencia.getContenidoencl()%>  ||  Precio: <%=referencia.getPrecio()%> euros</p>
            <form action = "CarroServlet?idref=<%=referencia.getCodigo()%>" method="post">
                <input type="submit" name="accion_carro" class="login login-submit" value="Remove">
            </form>
            <%
                    }
                }
            %>
        </div>
        <%
            }
            if (flag == 0) {
        %>
        <div class="login-card">
            <p> No hay productos en su carro</p>
        </div>       
        <%
            }
        %>
        <div class="login-card">
            <form action="CarroServlet" method="post">
                <input type="submit" name="accion_carro" class="login login-submit" value="Realizar pedido">
            </form>
            <form action="CarroServlet" method="post">
                <input type="submit" name="accion_carro" class="login login-submit" value="Continuar comprando">
            </form>
        </div>
        <div class="login-card">
            <form action="CarroServlet" method="post">
                <input type="submit" name="accion_carro" class="login login-submit" value="Cerrar sesión">
            </form>
        </div>
    </body>
</html>
