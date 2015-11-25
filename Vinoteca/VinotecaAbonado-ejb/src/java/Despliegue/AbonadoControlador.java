/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

import Persistencia.AbonadoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Controlador de toda la parte de abonados de la tienda.
 * @author Miguel
 */

@Stateless
public class AbonadoControlador implements AbonadoControladorRemote {
    @EJB
    private AbonadoFacadeLocal abonadoFacade;



    /**
     * Devuelve el nif del abonado con el login indicado
     * @param login el login del abonado
     * @return el nif del abonado
     */
    @Override
    public String getNif(String login){
        return abonadoFacade.getNif(login);
    }
    
    /**
     * Comprueba si existe un abonado con el login proporcionado
     * @param login el login a comprobar
     * @return true si existe el abonado
     */
    @Override
    public boolean isAbonado(String login){
        return abonadoFacade.isAbonado(login);
    }
    
    /**
     * Comprueba si la contraseÃƒÂ±a es correcta para el login
     * @param login el login del abonado
     * @param passwd el password del abonado
     * @return true si la contraseÃƒÂ±a es correcta
     */
    @Override
    public boolean isPsswdOK(String login, String passwd){
        return abonadoFacade.isPsswdOK(login, passwd);
    }
    
    /**
     * Devuelve la lista de preferencias del abonado para el login indicado
     * @param login el login del abonado
     * @return la lista de preferencias del abonado
     */
    @Override
    public List<Dominio.Preferencia> getPreferencias(String login){
        return abonadoFacade.getPreferencias(login);
    }
}

