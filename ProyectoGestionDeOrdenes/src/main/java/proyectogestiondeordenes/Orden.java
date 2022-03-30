package proyectogestiondeordenes;

import java.io.*;

    public class Orden {
        /*Variables iniciales*/
        private String nombre;
        private String servicio;
        
        /*Constructores*/
        public Orden(String nombre, String servicio) {
            this.nombre = nombre;
            this.servicio = servicio;
        }
        
        
        //Metodos

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