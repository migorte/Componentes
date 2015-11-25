/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinotecacliente;

import Despliegue.AbonadoControladorRemote;
import Despliegue.VinoControladorRemote;
import Dominio.Bodega;
import Dominio.Referencia;
import Dominio.Vino;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Miguel
 */
public class Main {

    @EJB
    private static VinoControladorRemote vinoControlador;
    @EJB
    private static AbonadoControladorRemote abonadoControlador;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("----------Prueba de vino-------------");
        List<Dominio.Vino> listaVinos = vinoControlador.getVinos("del anyo", "DO Rueda");

        Iterator<Dominio.Vino> iterador = listaVinos.iterator();
        System.out.println("LISTA DE VINOS DEL AÑO DE LA DO RUEDA");
        while (iterador.hasNext()) {
            Dominio.Vino vinotmp = iterador.next();
            System.out.println(vinotmp.getNombrecomercial());
            if (!vinoControlador.getReferencia(vinotmp.getId()).isEmpty()) {
                System.out.println(vinoControlador.getReferencia(vinotmp.getId()).get(0).getCodigo());
            }
        }

       // Bodega bodega = vinoControlador.getBodega(1);
        
        Bodega bodega = new Bodega();

        bodega.setCif("123120000");
        bodega.setDireccion("Calle Bodegas Serrada");
        bodega.setNombre("De Alberto");
        bodega.setId(1);
        
        Vino vino = new Vino();

        vino.setNombrecomercial("Cascarela");
        vino.setAnyo((short) 2014);
        vino.setComentario("De la tierra");
        vino.setDenominacion("DO Rueda");
        vino.setCategoria("del anyo");
        vino.setIdbodega(bodega);

        Referencia referencia = new Referencia();
        referencia.setContenidoencl((short) 75);
        referencia.setDisponible('T');
        referencia.setEsporcajas('T');
        referencia.setPrecio((float) 2.30);
        referencia.setVinoid(vino);

        vinoControlador.addReferencia(referencia);

        System.out.println("--------------------Prueba de abonado-----------------------");
        System.out.println("¿NIF de migorte?        " + abonadoControlador.getNif("migorte"));
        System.out.println("Existe un usuario rafmata?         " + abonadoControlador.isAbonado("rafmata"));
        System.out.println("Existe un usuario rafmato?         " + abonadoControlador.isAbonado("rafmato"));
        System.out.println("¿Es la password de chema ilitri?      " + abonadoControlador.isPsswdOK("chema", "ilitri"));
        System.out.println("¿Es la password de fuwood cardo?      " + abonadoControlador.isPsswdOK("fuwood", "cardo"));

        System.out.println("LISTA DE PREFERENCIAS DEL LOGIN migorte");
        List<Dominio.Preferencia> listaPreferencias = abonadoControlador.getPreferencias("migorte");
        Iterator<Dominio.Preferencia> iterador1 = listaPreferencias.iterator();
        while (iterador1.hasNext()) {
            Dominio.Preferencia preferencia = iterador1.next();
            System.out.println(preferencia.getIdpreferencia());
        }

    }

}
