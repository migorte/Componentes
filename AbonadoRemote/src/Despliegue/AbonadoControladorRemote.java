/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Miguel
 */
@Remote
public interface AbonadoControladorRemote {
    public String getNif(String login);
            
    public boolean isAbonado(String login);
    
    public boolean isPsswdOK(String login, String passwd);
    
    public List<Dominio.Preferencia> getPreferencias(String login);

}
