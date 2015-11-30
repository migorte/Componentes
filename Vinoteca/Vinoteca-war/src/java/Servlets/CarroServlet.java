/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import CarroCompra.CarroLocal;
import Despliegue.VinoControladorRemote;
import java.io.IOException;
import java.io.PrintWriter;
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

/**
 *
 * @author Miguel Ortega
 */
@WebServlet(name = "CarroServlet", urlPatterns = {"/CarroServlet"})
public class CarroServlet extends HttpServlet {

    @EJB
    private VinoControladorRemote vinoControlador;

    CarroLocal carro = lookupCarroLocal();

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
            case "Add":
                int codigo = Integer.parseInt(request.getParameter("codigoRef"));

                carro.addReferencia(vinoControlador.getReferenciaById(codigo));

                url = "/PreferenciasAbonadoServlet";

                break;

            case "Ver carro":
                sesion.setAttribute("carro", carro.getCarro());

                url = "/carro.jsp";

                break;

            case "Remove":
                int codigoReferencia = Integer.parseInt(request.getParameter("idref"));

                carro.removeReferencia(codigoReferencia);
                
                url = "/PreferenciasAbonadoServlet";
                
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

    private CarroLocal lookupCarroLocal() {
        try {
            Context c = new InitialContext();
            return (CarroLocal) c.lookup("java:global/Vinoteca/Vinoteca-war/Carro!CarroCompra.CarroLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
