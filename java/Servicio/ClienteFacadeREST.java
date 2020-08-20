/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Modelo.Cliente;
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
@Path("modelo.cliente")
public class ClienteFacadeREST extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "joyeriaPU")
    private EntityManager em;

    public ClienteFacadeREST() {
        super(Cliente.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Cliente entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Cliente entity) {
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
    public Cliente find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> findAll() {
        return super.findAll();
    }
    @POST
    @Path("create")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crear(@FormParam("id") int id, @FormParam("nombre") String nombre, @FormParam("direccion") String direccion, @FormParam("correo") String correo,@FormParam("telefono") String telefono, @FormParam("ciudad") String ciudad,@FormParam("edad") String edad,@FormParam("joyeria preferida")int joyeriaPreferida) {
        Cliente objeto = new Cliente(id, nombre, direccion,correo,telefono,ciudad,edad, joyeriaPreferida);
        super.create(objeto);
        return "El objeto se inserto con exito";
    }
        @POST
    @Path("edit")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String editar (@FormParam("id") int id, @FormParam("nombre") String nombre, @FormParam("direccion") String direccion, @FormParam("correo") String correo,@FormParam("telefono") String telefono, @FormParam("ciudad") String ciudad,@FormParam("edad") String edad,@FormParam("joyeria preferida")int joyeriaPreferida){
        Cliente objeto = super.find(id);
        
        objeto.setNombre(nombre);
        objeto.setCiudad(ciudad);
        objeto.setTelefono(telefono);
        objeto.setDireccion(direccion);
        objeto.setEdad(edad);
        objeto.setJoyeriaPreferida(joyeriaPreferida);
        super.edit(objeto);
        return "El objeto se edito con exito";
    }
    @POST
@Path("delete")
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
public String eliminar(@FormParam("id")int id){
Cliente objeto = super.find(id);
super.remove(objeto);
return "El objeto se ha eliminado";
}

    @POST
    @Path("buscar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Cliente> busquedajoyeria(@FormParam("joyeriaPreferida") String joyeriaPreferida) {
        TypedQuery consulta = getEntityManager().createQuery("SELECT c FROM Cliente c WHERE c.joyeriaPreferida = :joyeriaPreferida", Cliente.class);
        consulta.setParameter("joyeriaPreferida",joyeriaPreferida);
        return consulta.getResultList();
    }
    @POST
    @Path("mayoredad")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Cliente> mayoredad(@FormParam("edad") String edad) {
        TypedQuery consulta = getEntityManager().createQuery("SELECT c FROM Cliente WHERE  c.edad >= 18", Cliente.class);
        consulta.setParameter("edad",edad);
        return consulta.getResultList();
    }
    
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
