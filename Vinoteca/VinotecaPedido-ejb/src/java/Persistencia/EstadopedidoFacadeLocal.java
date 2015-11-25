/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Estadopedido;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */
@Local
public interface EstadopedidoFacadeLocal {

    void create(Estadopedido estadopedido);

    void edit(Estadopedido estadopedido);

    void remove(Estadopedido estadopedido);

    Estadopedido find(Object id);

    List<Estadopedido> findAll();

    List<Estadopedido> findRange(int[] range);

    int count();
    
}
