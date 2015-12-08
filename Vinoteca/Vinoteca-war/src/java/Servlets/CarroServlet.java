/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Despliegue.AbonadoControladorRemote;
import Despliegue.CarroRemote;
import Despliegue.VinoControladorRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.ws.WebServiceRef;
import ws.Estadopedido;
import ws.PedidoWS_Service;

/**
 *
 * @author Miguel Ortega
 */
@WebServlet(name = "CarroServlet", urlPatterns = {"/CarroServlet"})
public class CarroServlet extends HttpServlet {

    CarroRemote carro = lookupCarroRemote();

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/PedidoWS/PedidoWS.wsdl")
    private PedidoWS_Service service;

    @EJB
    private VinoControladorRemote vinoControlador;
    @EJB
    private AbonadoControladorRemote abonadoControlador;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sesion = request.getSession(false);

        String accion_carro = request.getParameter("accion_carro");

        String url = "";

        switch (accion_carro) {
            //Añadir una referencia al carro
            case "Add":
                int codigo = Integer.parseInt(request.getParameter("codigoRef"));

                carro.addReferencia(vinoControlador.getReferenciaById(codigo));

                url = "/PreferenciasAbonadoServlet";

                break;

            //Ver todos los elementos del carro
            case "Ver carro":
                sesion.setAttribute("carro", carro.getCarro());

                url = "/carro.jsp";

                break;

            //Borrar una referencia del carro
            case "Remove":
                int codigoReferencia = Integer.parseInt(request.getParameter("idref"));

                carro.removeReferencia(codigoReferencia);

                url = "/PreferenciasAbonadoServlet";

                break;

            //Realizar un pedido con los elementos del carro
            case "Realizar pedido":
                ws.Pedido pedido = new ws.Pedido();
                pedido.setNif(abonadoControlador.getNif((String) sesion.getAttribute("login")));
                pedido.setImporte(carro.getPrecio());
                 {
                    try {
                        pedido.setFecharealizacion(DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) Calendar.getInstance()));
                    } catch (DatatypeConfigurationException ex) {
                        Logger.getLogger(CarroServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                Estadopedido estado = new Estadopedido();
                estado.setClave("P");
                estado.setNombre("Pendiente");
                pedido.setEstado(estado);

                newPedido(pedido);

                carro.vaciarCarro();

                url = "/PreferenciasAbonadoServlet";
                break;

            case "Continuar comprando":
                url = "/PreferenciasAbonadoServlet";
                break;

            default:
                url = "/login.jsp";
                sesion.invalidate();
                break;
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void newPedido(ws.Pedido pedido) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.PedidoWS port = service.getPedidoWSPort();
        port.newPedido(pedido);
    }

    private CarroRemote lookupCarroRemote() {
        try {
            Context c = new InitialContext();
            return (CarroRemote) c.lookup("java:global/Vinoteca/VinotecaCarro-ejb/Carro!Despliegue.CarroRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
