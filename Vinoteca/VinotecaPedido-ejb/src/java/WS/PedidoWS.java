/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import Despliegue.PedidoControladorRemote;
import Dominio.Pedido;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Miguel
 */
@WebService(serviceName = "PedidoWS")
@Stateless()
public class PedidoWS {
    @EJB
    private PedidoControladorRemote ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "newPedido")
    @Oneway
    public void newPedido(@WebParam(name = "pedido") Pedido pedido) {
        ejbRef.newPedido(pedido);
    }

    @WebMethod(operationName = "getPedidosPendientes")
    public List<Pedido> getPedidosPendientes() {
        return ejbRef.getPedidosPendientes();
    }

    @WebMethod(operationName = "getPedidosAbonado")
    public List<Pedido> getPedidosAbonado(@WebParam(name = "nif") String nif) {
        return ejbRef.getPedidosAbonado(nif);
    }

    @WebMethod(operationName = "editPedido")
    @Oneway
    public void editPedido(@WebParam(name = "numeroPedido") int numeroPedido, @WebParam(name = "nuevoEstado") String nuevoEstado) {
        ejbRef.editPedido(numeroPedido, nuevoEstado);
    }
    
}
