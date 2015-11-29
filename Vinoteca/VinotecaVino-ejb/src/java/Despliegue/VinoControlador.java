/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

import Dominio.Bodega;
import Dominio.Referencia;
import Persistencia.BodegaFacadeLocal;
import Persistencia.ReferenciaFacadeLocal;
import Persistencia.VinoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Controlador de toda la parte de vinos de la tienda.
 *
 * @author Miguel
 */
@Stateless
public class VinoControlador implements VinoControladorRemote {
    @EJB
    private BodegaFacadeLocal bodegaFacade;

    @EJB
    private VinoFacadeLocal vinoFacade;
    @EJB
    private ReferenciaFacadeLocal referenciaFacade;

    /**
     * Devuelve una lista de los vinos que pertenezcan a la categorÃƒÂ­a y la
     * denominaciÃƒÂ³n de origen indicados.
     *
     * @param categoria la categorÃƒÂ­a del vino
     * @param denOrigen la denominaciÃƒÂ³n de origen del vino
     * @return la lista de vinos
     */
    @Override
    public List<Dominio.Vino> getVinos(String categoria, String denOrigen) {
        return vinoFacade.getVinos(categoria, denOrigen);
    }

    /**
     * Devuelve la lista referencias para un determinado vino
     *
     * @param idVino el id del vino
     * @return la lista de referencias
     */
    @Override
    public List<Dominio.Referencia> getReferencia(int idVino) {
        return vinoFacade.getReferencia(idVino);
    }

    /**
     * AÃƒÂ±ade una referencia a la base de datos
     *
     * @param referencia la referencia a aÃƒÂ±adir
     */
    @Override
    public void addReferencia(Referencia referencia) {
//        vinoFacade.create(referencia.getVinoid());
//        referenciaFacade.create(referencia);
        referenciaFacade.edit(referencia);
    }

    @Override
    public Bodega getBodega(int id) {
        return bodegaFacade.find(id);
    }
    
    @Override
    public Referencia getReferenciaById(int codigo){
        return referenciaFacade.find(codigo);
    }
}
