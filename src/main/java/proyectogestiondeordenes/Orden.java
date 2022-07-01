package proyectogestiondeordenes;

/**
 *
 * @author Usuario
 */
public class Orden {

    private String rut;
    private String Servicio;
    boolean estado;

    /**
     *
     * @param string
     * @param string1
     * @param bln
     */
    public Orden(String rut, String servicio,boolean estado) {
        this.rut = rut;
        this.Servicio = servicio;
        this.estado = estado;
    }

    /*Setters*/

    /**
     *
     * @param rut
     */

    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     *
     * @param servicio
     */
    public void setServicio(String servicio) {
        this.Servicio = servicio;
    }
    
    /**
     *
     * @param estado
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /*Getters*/

    /**
     *
     * @return
     */

    public String getRut() {
        return rut;
    }

    /**
     *
     * @return
     */
    public String getServicio() {
        return Servicio;
    }

    /**
     *
     * @return
     */
    public boolean isEstado() {
        return estado;
    }   

}
