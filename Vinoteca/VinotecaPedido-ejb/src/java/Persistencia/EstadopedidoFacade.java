/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Estadopedido;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
