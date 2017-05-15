package co.edu.ims.web;

import co.edu.ims.ejbs.PersonaEJB;
import co.edu.ims.modelo.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class PersonaBean {
    
    @Inject PersonaEJB personaEJB;
    
    private List<Persona> personas;    
    private Persona persona;
    
    public PersonaBean(){        
    }
    
    @PostConstruct
    public void init(){
        personas = personaEJB.buscarTodos();
        persona = new Persona();
    }
    
    public String guardar(){
        System.out.println("guardar...");
        personaEJB.crear(persona);        
        init();
        return null;
    }
    
    

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }           
}
