/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Abonado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */
@Local
public interface AbonadoFacadeLocal {

    void create(Abonado abonado);

    void edit(Abonado abonado);

    void remove(Abonado abonado);

    Abonado find(Object id);

    List<Abonado> findAll();

    List<Abonado> findRange(int[] range);

    int count();
    
    public String getNif(String login);
    
    public boolean isAbonado(String login);
    
    public boolean isPsswdOK(String login, String passwd);
    
    public List<Dominio.Preferencia> getPreferencias(String login);

    
}
