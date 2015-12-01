/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

import Dominio.Referencia;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author Miguel
 */
@Stateful
public class Carro implements CarroRemote {

    HashMap<Integer, Dominio.Referencia> carro;
    
    @PostConstruct
    private void initializeBean(){
        carro = new HashMap<>();
    }
    
    @Override
    public void addReferencia(Referencia referencia){
        carro.put(referencia.getCodigo(), referencia);
    }
    
    @Override
    public void removeReferencia(int codigo){
        carro.remove(codigo);
    }
    
    @Override
    public List<Dominio.Referencia> getCarro(){
        return new ArrayList<>(carro.values());
    }

    @Remove
    public void remove() {
        carro = null;
    }
}
