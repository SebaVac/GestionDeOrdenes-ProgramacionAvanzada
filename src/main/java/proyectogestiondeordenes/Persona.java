package proyectogestiondeordenes;

/**
 *
 * @author Usuario
 */
public abstract class Persona {
    
    /**
     *
     */
    protected String rut;

    /**
     *
     */
    protected String nombre;
    
    /**
     *
     * @param rut
     */
    public void setRut(String rut){
        this.rut = rut;
    }
    
    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    /**
     *
     * @return
     */
    public String getRut(){
        return rut;
    }
    
    /**
     *
     * @return
     */
    public String getNombre(){
        return nombre;
    }
}
