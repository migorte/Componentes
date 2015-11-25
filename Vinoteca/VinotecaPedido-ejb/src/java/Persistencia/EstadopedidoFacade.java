/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Estadopedido;
import Dominio.Pedido;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Miguel
 */
@Stateless
public class EstadopedidoFacade extends AbstractFacade<Estadopedido> implements EstadopedidoFacadeLocal {
    @PersistenceContext(unitName = "VinotecaPedido-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadopedidoFacade() {
        super(Estadopedido.class);
    }
    
    @Override
    public Estadopedido getEstadoPedido(String nuevoEstado) {
        Query query = em.createNamedQuery("Estadopedido.findByClave");
        query.setParameter("clave", nuevoEstado);
        return (Dominio.Estadopedido) query.getResultList().get(0);
    }
}
