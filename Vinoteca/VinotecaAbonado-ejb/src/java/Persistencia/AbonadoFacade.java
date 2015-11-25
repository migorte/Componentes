/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Abonado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 *
 * @author Miguel
 */
@Stateless
public class AbonadoFacade extends AbstractFacade<Abonado> implements AbonadoFacadeLocal {
    @PersistenceContext(unitName = "VinotecaAbonado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AbonadoFacade() {
        super(Abonado.class);
    }
    
        /**
     * Devuelve el nif del abonado con el login indicado
     * @param login el login del abonado
     * @return el nif del abonado
     */
    @Override
    public String getNif(String login){
        Query query = em.createNamedQuery("Abonado.findByLogin");
        query.setParameter("login", login);
        Dominio.Abonado abonado = (Dominio.Abonado) query.getSingleResult();
        return abonado.getNif().getNif();
    }
    
    /**
     * Comprueba si existe un abonado con el login proporcionado
     * @param login el login a comprobar
     * @return true si existe el abonado
     */
    @Override
    public boolean isAbonado(String login){
        Query query = em.createNamedQuery("Abonado.findByLogin");
        query.setParameter("login", login);
        List<Dominio.Abonado> listaAbonado = (List<Dominio.Abonado>) query.getResultList();
        return !listaAbonado.isEmpty();
    }
    
    /**
     * Comprueba si la contraseÃƒÂ±a es correcta para el login
     * @param login el login del abonado
     * @param passwd el password del abonado
     * @return true si la contraseÃƒÂ±a es correcta
     */
    @Override
    public boolean isPsswdOK(String login, String passwd){
        Query query = em.createNamedQuery("Abonado.findByLogin");
        query.setParameter("login", login);
        List<Dominio.Abonado> listaAbonado = (List<Dominio.Abonado>) query.getResultList();
        return listaAbonado.get(0).getPassword().equals(passwd);
    }
    
    /**
     * Devuelve la lista de preferencias del abonado para el login indicado
     * @param login el login del abonado
     * @return la lista de preferencias del abonado
     */
    @Override
    public List<Dominio.Preferencia> getPreferencias(String login){
        Query query = em.createNamedQuery("Abonado.findByLogin");
        query.setParameter("login", login);
        Dominio.Abonado abonado = (Dominio.Abonado) query.getResultList().get(0);
        abonado.getPreferenciaCollection().size();
        return (List<Dominio.Preferencia>) abonado.getPreferenciaCollection();   
    }

    
}
