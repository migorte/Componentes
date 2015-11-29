/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarroCompra;

import Dominio.Referencia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel Ortega
 */
@Local
public interface CarroLocal {
    
    public void addReferencia(Referencia referencia);
    
    public void removeReferencia(int codigo);
    
    public List<Dominio.Referencia> getCarro();

}
