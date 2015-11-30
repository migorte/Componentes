<%-- 
    Document   : abonado
    Created on : 28-nov-2015, 12:45:10
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
            List<Dominio.Vino> listaVinos = (List<Dominio.Vino>) session.getAttribute("listaVinos");
            List<Dominio.Referencia> listaReferencias = (List<Dominio.Referencia>) session.getAttribute("listaReferencias");

            int flag = 0;

            for (Dominio.Vino vino : listaVinos) {
        %>
        <div class="login-card">
            <h5><%=vino.getNombrecomercial()%>  ||  <%=vino.getDenominacion()%>  ||  <%=vino.getCategoria()%>  ||  <%=vino.getAnyo()%></h5>
            <h5><%=vino.getComentario()%></h5>
            <%
                for (Dominio.Referencia referencia : listaReferencias) {
                    if (referencia.getVinoid().getId().equals(vino.getId())) {
                        flag = 1;
            %>
            <p><%=referencia.getContenidoencl()%>  ||  <%=referencia.getPrecio()%></p>
            <form action = "CarroServlet?codigoRef=<%=referencia.getCodigo()%>" method="post">
                <input type="submit" name="accion_carro" class="login login-submit" value="Add">
            </form>
            <%          }
                }
                if (flag == 0) {
            %>
            <p>No hay referencias para este vino</p>
            <%
                }
            %>
        </div>
        <%
            }
        %>
        <div class="login-card">
            <form action = "CarroServlet" method="post">
                <input type="submit" name="accion_carro" class="login login-submit" value="Ver carro">
            </form>
        </div>
    </body>
</html>
