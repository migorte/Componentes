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
    </head>
    <body>
        <%
            List<Dominio.Referencia> carro = (List<Dominio.Referencia>) session.getAttribute("carro");
            List<Dominio.Vino> listaVinos = (List<Dominio.Vino>) session.getAttribute("listaVinos");
            for (Dominio.Referencia referencia : carro) {
        %>
        <div class="login-card">
            <%
                for (Dominio.Vino vino : listaVinos) {
                    if (vino.getId().equals(referencia.getVinoid().getId())) {
            %>    
            <h5><%=vino.getNombrecomercial()%>  ||  <%=vino.getDenominacion()%>  ||  <%=vino.getCategoria()%>  ||  <%=vino.getAnyo()%></h5>
            <p><%=referencia.getContenidoencl()%>  ||  <%=referencia.getPrecio()%></p>
            <form action = "BorrarReferencia?idref=<%=referencia.getCodigo()%>" method="post">
                <input type="submit" name="remove" class="login login-submit" value="Remove">
            </form>
        </div>
        <%
                    }
                    break;
                }
            }
        %>
    </body>
</html>
