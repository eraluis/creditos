package co.edu.ims.ejbs;

import co.edu.ims.modelo.Persona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;

@Stateless
@Path("/persona")
public class PersonaEJB {
    
    @PersistenceContext(unitName = "personaPU")
    protected EntityManager em;
    
    
    public Persona agregar(Persona entity){
        em.persist(entity);
        em.flush();
        return entity;
    }
    
}
