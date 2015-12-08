/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Despliegue.AbonadoControladorRemote;
import Despliegue.VinoControladorRemote;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Miguel
 */
@WebServlet(name = "PreferenciasAbonadoServlet", urlPatterns = {"/PreferenciasAbonadoServlet"})
public class PreferenciasAbonadoServlet extends HttpServlet {
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
        
        /*
        Se obtienen todas las preferencias de un abonado y se organizan en una lista
        de todas las referencias relacionadas con sus preferencias y los vinos a los
        que referencian
        */
        HttpSession sesion = request.getSession(false);
        String login = (String) sesion.getAttribute("login");
        List<Dominio.Preferencia> listaPreferencias = abonadoControlador.getPreferencias(login);
        
        List<Dominio.Vino> listaVinos = new ArrayList<>();
        
        Iterator<Dominio.Preferencia> iteradorPreferencias = listaPreferencias.iterator();
        
        while(iteradorPreferencias.hasNext()){
            Dominio.Preferencia preftmp = iteradorPreferencias.next();
            listaVinos.addAll(vinoControlador.getVinos(preftmp.getCategoria(), preftmp.getDenominacion()));
        }
        
        List<Dominio.Referencia> listaReferencias = new ArrayList<>();
        
        Iterator<Dominio.Vino> iteradorVinos = listaVinos.iterator();
        
        while(iteradorVinos.hasNext()){
            listaReferencias.addAll(vinoControlador.getReferencia(iteradorVinos.next().getId()));
        }

        sesion.setAttribute("listaVinos", listaVinos);
        sesion.setAttribute("listaReferencias", listaReferencias);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/abonado.jsp");
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

}
