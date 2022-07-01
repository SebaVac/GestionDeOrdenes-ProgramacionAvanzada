package proyectogestiondeordenes;

public class Orden {

    private String rut;
    private String Servicio;
    boolean estado;

    public Orden(String rut, String servicio,boolean estado) {
        this.rut = rut;
        this.Servicio = servicio;
        this.estado = estado;
    }

    /*Setters*/
    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setServicio(String servicio) {
        this.Servicio = servicio;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /*Getters*/
    public String getRut() {
        return rut;
    }

    public String getServicio() {
        return Servicio;
    }

    public boolean isEstado() {
        return estado;
    }   

}
