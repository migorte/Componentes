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
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author Miguel
 */
@Stateful
public class Carro implements CarroRemote {

    Map<Integer, List<Dominio.Referencia>> carro;
    
    @PostConstruct
    private void initializeBean(){
        carro = new HashMap<>();
    }
    
    /**
     * Añade una nueva referencia al carro
     * @param referencia la referencia a añadir
     */
    @Override
    public void addReferencia(Referencia referencia){
        if(carro.containsKey(referencia.getCodigo()) && carro.get(referencia.getCodigo())!=null)
            carro.get(referencia.getCodigo()).add(referencia);
        else{
            List<Dominio.Referencia> lista = new ArrayList<>();
            lista.add(referencia);
            carro.put(referencia.getCodigo(), lista);
        }
    }
    
    /**
     * Borra una referencia del carro
     * @param codigo 
     */
    @Override
    public void removeReferencia(int codigo){
        carro.get(codigo).remove(0);
    }
    
    /**
     * Devuelve una lista de los elementos que hay en el carro
     * @return la lista de elementos del carro
     */
    @Override
    public List<Dominio.Referencia> getCarro(){
        List<List<Dominio.Referencia>> listaCarro = new ArrayList<>(carro.values());
        List<Dominio.Referencia> listaADevolver = new ArrayList<>();
        for(List<Dominio.Referencia> lr :listaCarro){
            listaADevolver.addAll(lr);
        }
        return listaADevolver;
    }
    
    /**
     * Devuelve el precio de todos las referencias en el carro
     * @return 
     */
    @Override
    public Float getPrecio(){
        List<Dominio.Referencia> lista = getCarro();
        
        Float precio = (float) 0.0;
        
        for(Dominio.Referencia r : lista){
            precio+=r.getPrecio();
        }
        
        return precio;
    }
    
    /**
     * Vacia el carro, borrando todos sus elementos
     */
    @Override
    public void vaciarCarro(){
        carro.clear();
    }

    @Remove
    public void remove() {
        vaciarCarro();
    }
}