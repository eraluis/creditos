package co.edu.ims.pruebas;

import java.util.HashSet;
import java.util.Set;


public class PruebaConjuntos {
    
    public static void main(String[] args){
        Set<String> conjunto = new HashSet<>();
        String actor1 = "Chespirito";
        String actor2 = "Audrey Tatoo";
        String actor3 = "Megan Fox";
        String actor4 = "Arnold Scharzenegger";
               
        conjunto.add(actor1);
        conjunto.add(actor2);
        conjunto.add(actor3);
        conjunto.add(actor4);
        conjunto.add(actor2);
        conjunto.add(actor3);
        
        // Los conjuntos no se pueden ordenar
        // Collections.sort(conjunto);
        System.out.println(conjunto);
        System.out.println("tamaño: " +conjunto.size());
        
    }
    
}
