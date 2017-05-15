package co.edu.ims.ejbs;

import co.edu.ims.modelo.Pelicula;
import co.edu.ims.modelo.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Stateless
@Path("/persona")
public class PersonaEJB {
    
    @PersistenceContext(unitName = "peliculasPU")
    protected EntityManager em;
    
    @Inject SingletonEJB singletonEJB;
    
    @GET
    @Path("{id}")
    @Produces("application/json")       
    public Persona buscar(@PathParam("id") Integer pId){
        
        singletonEJB.incrementarCodigo();
        System.out.println(singletonEJB.getCodigoOperacion());                               
        return em.find(Persona.class, pId);        
    }
    
    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    public Persona crear(Persona p){
        em.persist(p);
        em.flush();
        singletonEJB.incrementarCodigo();
        System.out.println(singletonEJB.getCodigoOperacion());
        return p;
    }          

    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public Response elminar(@PathParam("id") Integer pId){
        Persona p = em.find(Persona.class, pId);
        if( p != null){
            em.remove(p);
        }
        
        singletonEJB.incrementarCodigo();
        System.out.println(singletonEJB.getCodigoOperacion());
        return Response.noContent().build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Persona actualizar(Persona p){
        em.merge(p);  
        singletonEJB.incrementarCodigo();
        System.out.println(singletonEJB.getCodigoOperacion());
        return p;
    }
    
    @GET
    @Produces("application/json")       
    public List<Persona> buscarTodos(){                
        String jpql = "SELECT per FROM Persona per";  
        TypedQuery<Persona> q = em.createQuery(jpql, Persona.class);
        List<Persona> resultado = q.getResultList();
        singletonEJB.incrementarCodigo();
        System.out.println(singletonEJB.getCodigoOperacion());
        return resultado;              
    }
    
    @GET
    @Path("/nombre/{nombre}")
    @Produces("application/json")       
    public List<Persona> buscarPorNombre(@PathParam("nombre") String nombre){                
        String jpql = "SELECT per FROM Persona per WHERE per.nombre LIKE :pNombre ";        
        TypedQuery<Persona> q = em.createQuery(jpql, Persona.class);
        q.setParameter("pNombre", "%"+nombre+"%");
        List<Persona> resultado = q.getResultList();        
        return resultado;              
    }
    
    @PUT
    @Path("/agregarpelicula/{id}")
    @Produces("application/json")      
    @Consumes("application/json")
    public Pelicula agregarPelicula(@PathParam("id") Integer pId, Pelicula p){       
        Persona director = this.buscar(pId);
        p.setDirector(director);
        em.persist(p);
        em.flush();        
        return p;
    }
}
