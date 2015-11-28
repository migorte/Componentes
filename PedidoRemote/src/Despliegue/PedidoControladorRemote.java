/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

import Dominio.Pedido;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Miguel
 */
@Remote
public interface PedidoControladorRemote {
    
    public void newPedido(Pedido pedido);
    
    public List<Pedido> getPedidosPendientes();
    
    public List<Pedido> getPedidosAbonado(String nif);
    
    public void editPedido(int numeroPedido, String nuevoEstado);
}
