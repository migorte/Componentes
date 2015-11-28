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
    
    @Override
    public void newPedido(Pedido pedido){
        pedidoFacade.create(pedido);
    }
    
    @Override
    public List<Pedido> getPedidosPendientes(){
        return pedidoFacade.getPedidosPendientes();
    }
    
    @Override
    public List<Pedido> getPedidosAbonado(String nif){
        return pedidoFacade.getPedidosAbonado(nif);
    }
    
    @Override
    public void editPedido(int numeroPedido, String nuevoEstado){
        Pedido pedido = pedidoFacade.find(numeroPedido);
        Estadopedido estado = estadopedidoFacade.getEstadoPedido(nuevoEstado);
        pedido.setEstado(estado);
        pedidoFacade.edit(pedido);
    }
}
