/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

import Dominio.Estadopedido;
import Dominio.Pedido;
import Persistencia.EstadopedidoFacadeLocal;
import Persistencia.PedidoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Miguel
 */
@Stateless
public class PedidoControlador implements PedidoControladorRemote {
    @EJB
    private EstadopedidoFacadeLocal estadopedidoFacade;
    @EJB
    private PedidoFacadeLocal pedidoFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    /**
     * Crea un nuevo pedido en la base de datos
     * @param pedido el pedido a crear
     */
    @Override
    public void newPedido(Pedido pedido){
        pedidoFacade.create(pedido);
    }
    
    /**
     * Devuelve una lista de pedidos pendientes
     * @return la lista de pedidos pendientes
     */
    @Override
    public List<Pedido> getPedidosPendientes(){
        return pedidoFacade.getPedidosPendientes();
    }
    
    /**
     * Devuelve una lista de los pedidos de un abonado
     * @param nif el nif del abonado
     * @return la lista de los pedidos del abonado
     */
    @Override
    public List<Pedido> getPedidosAbonado(String nif){
        return pedidoFacade.getPedidosAbonado(nif);
    }
    
    /**
     * Cambia el estado de un pedido
     * @param numeroPedido numero del pedido a cambiar
     * @param nuevoEstado el nuevo estado del pedido
     */
    @Override
    public void editPedido(int numeroPedido, String nuevoEstado){
        Pedido pedido = pedidoFacade.find(numeroPedido);
        Estadopedido estado = estadopedidoFacade.getEstadoPedido(nuevoEstado);
        pedido.setEstado(estado);
        pedidoFacade.edit(pedido);
    }
}
