package proyectogestiondeordenes;


public interface EstadoOrden {
    
    public static final String estado1 = "Pendiente";
    
    public static final String estado2 = "Instalacion Software";
    
    public static final String estado3 = "Limpieza General";
    
    public static final String estado4 = "Reparacion";
    
    public String estado(int eleccion);
    
}
