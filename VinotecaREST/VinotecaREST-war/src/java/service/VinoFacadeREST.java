/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Dominio.Vino;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Miguel
 */
@Stateless
@Path("dominio.vino")
public class VinoFacadeREST extends AbstractFacade<Vino> {

    @PersistenceContext(unitName = "VinotecaREST-warPU")
    private EntityManager em;

    public VinoFacadeREST() {
        super(Vino.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Vino entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Vino entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Vino find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Vino> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Vino> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("/vino/{denOrigen}")
    @Produces({"application/xml", "application/json"})
    public List<Vino> findByDenominacion(@PathParam("denOrigen") String denOrigen) {
        Query query = em.createNamedQuery("Vino.findByDenominacion");
        query.setParameter("denominacion", denOrigen);
        List<Dominio.Vino> listaVinos = (List<Dominio.Vino>) query.getResultList();
        return listaVinos;
    }

    @DELETE
    @Path("/vino/{nombre}")
    public void borrarVino(@PathParam("nombre") String nombre) {
        Query query = em.createNamedQuery("Vino.findByNombrecomercial");
        query.setParameter("nombrecomercial", nombre);
        List<Vino> listaVino = (List<Vino>) query.getResultList();
        listaVino.stream().forEach((vino) -> {
            super.remove(vino);
        });
    }
    
    @PUT
    @Path("/vino/{id}")
    @Consumes("text/plain")
    public void editarVino(@PathParam("id") int id, String comentario){
        Vino vino = super.find(id);
        vino.setComentario(comentario);
        super.edit(vino);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
