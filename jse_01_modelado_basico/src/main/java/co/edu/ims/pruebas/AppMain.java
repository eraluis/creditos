package co.edu.ims.pruebas;

import co.edu.ims.modelo.Genero;
import co.edu.ims.modelo.Pelicula;
import com.google.gson.Gson;

public class AppMain {
    
    public static void main(String[] args){
        
        Pelicula terminator = new Pelicula("Terminator", 1985);
        Pelicula insideOut = new Pelicula("Inside Our", 2015);
        
        Pelicula titanic = new Pelicula();
        titanic.setTitulo("Titanic");
        titanic.setAnio(1996);
                
        Genero accion = new Genero("Accion");
        Genero comedia = new Genero("Comedia");
        Genero animada = new Genero("Animada");
        Genero siFi = new Genero("Ciencia Ficción");
        
        terminator.getGeneros().add(siFi);
        terminator.getGeneros().add(accion);
        //terminator.getGeneros().remove(siFi); Remover el genero
        
        insideOut.getGeneros().add(animada);
        titanic.getGeneros().add(accion);
        
        Gson gson = new Gson();
        
        String json1 = gson.toJson(terminator);        
        System.out.println(json1);
        
        String json2 = gson.toJson(comedia);        
        System.out.println(json2);
        
        String json3 = gson.toJson(terminator);        
        System.out.println(json3);
              
    }
    
}
