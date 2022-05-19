package proyectogestiondeordenes;

public class Orden {

    private String rut;
    private String Servicio;

    public Orden(String rut, String Servicio) {
        this.rut = rut;
        this.Servicio = Servicio;
    }


    /*Setters*/
    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setServicio(String Servicio) {
        this.Servicio = Servicio;
    }

    /*Getters*/
    public String getRut() {
        return rut;
    }

    public String getServicio() {
        return Servicio;
    }

}
