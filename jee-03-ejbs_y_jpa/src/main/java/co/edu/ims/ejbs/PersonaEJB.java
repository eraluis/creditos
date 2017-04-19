package co.edu.ims.ejbs;

import co.edu.ims.modelo.Persona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Stateless
@Path("/persona")
public class PersonaEJB {
    
    @PersistenceContext(unitName = "peliculasPU")
    protected EntityManager em;
    
    @GET
    @Path("{id}")
    @Produces("application/json")       
    public Persona buscar(@PathParam("id") Integer pId){
        return em.find(Persona.class, pId);        
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Persona agregar(Persona entity){
        em.persist(entity);
        em.flush();
        return entity;
    }
    
}
