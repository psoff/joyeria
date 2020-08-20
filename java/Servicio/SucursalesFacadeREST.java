/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Modelo.Cliente;
import Modelo.Sucursales;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author FRANCO
 */
@Stateless
@Path("modelo.sucursales")
public class SucursalesFacadeREST extends AbstractFacade<Sucursales> {

    @PersistenceContext(unitName = "joyeriaPU")
    private EntityManager em;

    public SucursalesFacadeREST() {
        super(Sucursales.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Sucursales entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Sucursales entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Sucursales find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sucursales> findAll() {
        return super.findAll();
    }
        @POST
    @Path("create")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crear(@FormParam("id") int id, @FormParam("nombre") String nombre,@FormParam("ubicacion")String ubicacion, @FormParam("direccion") String direccion, @FormParam("encargado") String encargado,@FormParam("dimension") String dimension, @FormParam("ciudad") String ciudad) {
        Sucursales objeto = new Sucursales(id, nombre, ubicacion, direccion, encargado, dimension, ciudad);
        super.create(objeto);
        return "El objeto se inserto con exito";
    }
        @POST
    @Path("edit")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String editar (@FormParam("id") int id, @FormParam("nombre") String nombre,@FormParam("ubicacion")String ubicacion, @FormParam("direccion") String direccion, @FormParam("encargado") String encargado,@FormParam("dimension") String dimension, @FormParam("ciudad") String ciudad){
        Sucursales objeto = super.find(id);
        
        objeto.setNombre(nombre);
        objeto.setCiudad(ciudad);
        objeto.setEncargado(encargado);
        objeto.setDireccion(direccion);
        objeto.setCiudad(ciudad);
        objeto.setDimension(dimension);
        super.edit(objeto);
        return "El objeto se edito con exito";
    }
    @POST
@Path("delete")
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
public String eliminar(@FormParam("id")int id){
Sucursales objeto = super.find(id);
super.remove(objeto);
return "El objeto se ha eliminado";
}
    @POST
    @Path("buscar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Sucursales> busquedajoyeria(@FormParam("ciudad") String ciudad) {
        TypedQuery consulta = getEntityManager().createQuery("SELECT s FROM Sucursales s WHERE s.ciudad = :ciudad", Cliente.class);
        consulta.setParameter("ciudad",ciudad);
        return consulta.getResultList();
    }
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sucursales> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
