/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Vino;
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
public class VinoFacade extends AbstractFacade<Vino> implements VinoFacadeLocal {
    @PersistenceContext(unitName = "VinotecaVino-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VinoFacade() {
        super(Vino.class);
    }
    
     /**
     * Devuelve una lista de los vinos que pertenezcan a la categorÃƒÂ­a y la denominaciÃƒÂ³n
     * de origen indicados.
     * @param categoria la categorÃƒÂ­a del vino
     * @param denOrigen la denominaciÃƒÂ³n de origen del vino
     * @return la lista de vinos
     */
    @Override
    public List<Dominio.Vino> getVinos (String categoria, String denOrigen){
        Query query = em.createNamedQuery("Vino.findByCategoriaAndDenominacion");
        query.setParameter("categoria", categoria);
        query.setParameter("denominacion", denOrigen);
        List<Dominio.Vino> listaVinos = (List<Dominio.Vino>) query.getResultList();
        return listaVinos;
    }
    
    /**
     * Devuelve la lista referencias para un determinado vino
     * @param idVino el id del vino
     * @return la lista de referencias
     */
    @Override
    public List<Dominio.Referencia> getReferencia (int idVino){
        Query query = em.createNamedQuery("Vino.findById");
        query.setParameter("id", idVino);
        Dominio.Vino vino = (Dominio.Vino) query.getResultList().get(0);
        vino.getReferenciaCollection().size();//Para que no de error instanciando la "LAZY relationship"
        return (List<Dominio.Referencia>) vino.getReferenciaCollection();
    }

    
}
