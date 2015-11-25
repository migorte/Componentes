/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

import Dominio.Pedido;
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
    private PedidoFacadeLocal pedidoFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public void newPedido(Pedido pedido){
        pedidoFacade.create(pedido);
    }
    
    public List<Pedido> getPedidosPendientes(){
        return pedidoFacade.getPedidosPendientes();
    }
}
