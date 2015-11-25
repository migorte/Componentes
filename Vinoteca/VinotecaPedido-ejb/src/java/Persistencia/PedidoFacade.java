/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Pedido;
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
public class PedidoFacade extends AbstractFacade<Pedido> implements PedidoFacadeLocal {

    @PersistenceContext(unitName = "VinotecaPedido-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoFacade() {
        super(Pedido.class);
    }

    @Override
    public List<Pedido> getPedidosPendientes() {
        Query query = em.createNamedQuery("Pedido.findPendientes");
        query.setParameter("estado", 'P');
        return (List<Dominio.Pedido>) query.getResultList();
    }

    @Override
    public List<Pedido> getPedidosAbonado(String nif) {
        Query query = em.createNamedQuery("Pedido.findByNif");
        query.setParameter("nif", nif);
        return (List<Dominio.Pedido>) query.getResultList();
    }
    
    @Override
    public Pedido getPedido(int numeroPedido) {
        Query query = em.createNamedQuery("Pedido.findByNumero");
        query.setParameter("numero", numeroPedido);
        return (Dominio.Pedido) query.getResultList().get(0);
    }
}
