import java.io.*;
import java.util.HashMap;

public class Empresa {
  /*Variables iniciales*/
    private int rut; //key del Hashmap
    private HashMap mapaOrdenes;

  /*Constructores*/

    public Empresa(int rut, String nombre, HashMap mapaOrdenes) {
        this.rut = rut;
        this.mapaOrdenes = mapaOrdenes;
    }
    

    /*Metodos*/
    
    /*Setter*/
    public void setRut(int rut) {
        this.rut = rut;
    }

    public void setMapaOrdenes(HashMap mapaOrdenes) {
        this.mapaOrdenes = mapaOrdenes;
    }


    /*Getter*/
    public int getRut() {
        return rut;
    }

    public HashMap getMapaOrdenes() {
        return mapaOrdenes;
    }
    
    public class Orden {
        /*Variables iniciales*/
        private String nombre;
        private String servicio;
        
        /*Constructores*/

        public Orden(String nombre, String servicio) {
            this.nombre = nombre;
            this.servicio = servicio;
        }
        
        /*Metodos*/
        
        /*Getter*/
        public String getNombre() {
            return nombre;
        }

        public String getServicio() {
            return servicio;
        }
        
        /*Setter*/

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setServicio(String servicio) {
            this.servicio = servicio;
        }
        
    }
    
    public static void main (String[] args) {
    
    /*inicializar datos*/
        
    /*se ingresan valores desde un archivo csv*/
    

    }
}
