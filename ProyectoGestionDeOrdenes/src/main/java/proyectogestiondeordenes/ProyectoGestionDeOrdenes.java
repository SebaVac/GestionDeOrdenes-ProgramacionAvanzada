package proyectogestiondeordenes;

import java.io.*;
import java.util.*;

public class ProyectoGestionDeOrdenes {
    
     public static void main (String[] arg) {
         
        Orden 1 = new Orden("Anonimo", "19857462", "Arreglo Pantalla");
        
          
    /*Crear variables*/
    
    HashMap mapaDeOrdenes = new HashMap();
    
     //Guardar las Ordenes
    Empresa od1 = new Empresa(20906578, mapaDeOrdenes);
       
    od1.put(10,od1);
    
    // agregar ordenes a empresa
        Empresa gestion = od1.get(10);
        gestion.agregarOrdenes(1);
        gestion.agregarOrdenes(13);
        
        gestion.agregarOrdenes(12);
    
    //Empresa empresa = new Empresa(,mapaDeOrdenes);
    }
    
}
