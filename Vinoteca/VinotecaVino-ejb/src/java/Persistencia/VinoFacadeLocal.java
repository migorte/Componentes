/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Vino;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */
@Local
public interface VinoFacadeLocal {

    void create(Vino vino);

    void edit(Vino vino);

    void remove(Vino vino);

    Vino find(Object id);

    List<Vino> findAll();

    List<Vino> findRange(int[] range);

    int count();
    
    public List<Dominio.Vino> getVinos (String categoria, String denOrigen);
    
    public List<Dominio.Referencia> getReferencia (int idVino);

    
}
