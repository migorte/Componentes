/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

import Dominio.Bodega;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Miguel
 */
@Remote
public interface VinoControladorRemote {
    public List<Dominio.Vino> getVinos (String categoria, String denOrigen);
    
    public List<Dominio.Referencia> getReferencia(int idVino);
    
    public void addReferencia(Dominio.Referencia referencia);
    
//    public Bodega getBodega(int id); 
}
