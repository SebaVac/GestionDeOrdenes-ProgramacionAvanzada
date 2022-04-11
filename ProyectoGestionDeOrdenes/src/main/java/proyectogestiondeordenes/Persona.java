package proyectoremasterizado;


public class Persona {
    private int rut;                                        //atributos
    private String nombre;
    private String servicio;
    
    public Persona(int rut, String nombre, String servicio) { //constructor
        this.rut = rut;
        this.nombre = nombre;
        this.servicio = servicio;
    }
    
    public void mostrarPersona(){
        System.out.println("El RUT "+this.rut+" es de la persona "+this.nombre+", el cual necesita un servicio de "+this.servicio+".");
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
}
