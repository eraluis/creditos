package co.edu.ims.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Pelicula implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
        
    @ManyToOne
    @JoinColumn(name ="fk_director")
    private Persona director;
    
    @ManyToMany
    @JoinTable(
            name="pelicula_genero",
            joinColumns = @JoinColumn(name ="pelicula_id"),
            inverseJoinColumns=@JoinColumn(name="genero_id")
    )    
    private List<Genero> generos = new ArrayList<>();

    // Contructores
    public Pelicula() {
    }
    
    public Pelicula(String t, Persona d){
        this.titulo = t;
        this.director = d;
    }
    
    // Getters & setters...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Persona getDirector() {
        return director;
    }

    public void setDirector(Persona director) {
        this.director = director;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }       
    
}








