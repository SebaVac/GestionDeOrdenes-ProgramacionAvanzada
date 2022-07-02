
package Cliente2;

public class Cliente2 {
    
    private String nombre;
    private String rut;
    private String servicio;

    public Cliente2() {
    }

    public Cliente2(String nombre, String rut, String servicio) {
        this.nombre = nombre;
        this.rut = rut;
        this.servicio = servicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
    
    
}
