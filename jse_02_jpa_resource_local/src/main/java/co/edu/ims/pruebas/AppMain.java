package co.edu.ims.pruebas;

import co.edu.ims.modelo.Genero;
import co.edu.ims.modelo.Pelicula;
import co.edu.ims.modelo.Persona;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AppMain {
    
    public static void main (String[] args){
        
        EntityManagerFactory emf;
        EntityManager em; 
        
        emf = Persistence.createEntityManagerFactory("peliculasPU");        
        em = emf.createEntityManager();
        
        // Se crea objeto en memoria (sin persistir aun).
        Genero accion = new Genero("Accion", "Peliculas de accion");
        Genero misterio = new Genero("Misterio", "Peliculas de misterio");
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(accion); // Se persiste objeto en base de datos.
        em.persist(misterio);
        tx.commit();
        
        // Se crea objeto en memoria (sin persistir aun).
        Persona guillermoDelToro = new Persona(
                "Guillermo del Toro", 
                "MX",
                (new GregorianCalendar(1964, 9, 9)).getTime() );
        
        Persona alexDeLaIglesia = new Persona(
                "Alex de la Iglesia", 
                "ES",
                (new GregorianCalendar(1969, 10, 9)).getTime() );
        
        tx.begin();
        em.persist(guillermoDelToro); // Se persiste objeto en base de datos.
        em.persist(alexDeLaIglesia);
        tx.commit();
        
        Pelicula laberintoDelFauno 
                = new Pelicula("Laberinto del fauno", guillermoDelToro);
        
        laberintoDelFauno.getGeneros().add(accion);
        laberintoDelFauno.getGeneros().add(misterio);
         
        tx.begin();
        em.persist(laberintoDelFauno);
        tx.commit();
        
        Pelicula habitacionDelNinio 
                = new Pelicula("La Habitacion del Niño", alexDeLaIglesia);        
        habitacionDelNinio.getGeneros().add(misterio);
        
        tx.begin();
        em.persist(habitacionDelNinio);
        tx.commit();
        
        // Se crea objeto en memoria (sin persistir aun).
        Genero romance = new Genero("Romance", "Peliculas de romance");
    }
    
}
