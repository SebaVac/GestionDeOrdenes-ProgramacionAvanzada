import java.io.*;

public class Orden {
  /*Variables iniciales*/
    private int rut; 
    private String[] nombre = new String[20];
    private int numeroOrden;

  /*Constructores*/
    public Orden(int rut, int numeroOrden) {
        this.rut = rut;
        this.numeroOrden = numeroOrden;
    }

    /*Metodos*/
    
    /*Setter*/
    public void setRut(int rut) {
        this.rut = rut;
    }

    public void setNombre(String[] nombre) {
        this.nombre = nombre;
    }

    public void setNumeroOrden(int numeroOrden) {    
        this.numeroOrden = numeroOrden;
    }

    /*Getter*/
    public int getRut() {
        return rut;
    }

    public String[] getNombre() {
        return nombre;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    
    public static void main (String[] args) {
    
    /*inicializar datos*/
        
    /*se ingresan valores por teclado*/
    BufferedReader nombreUsuario = new BufferedReader (new InputStreamReader(System.in));  
    BufferedReader rutUsuario = new BufferedReader (new InputStreamReader(System.in));
    
    //setNombre(nombreUsuario.readLine());
    
    }
}
