package proyectogestiondeordenes;

import java.io.*;

    public class Orden {
        /*Variables iniciales*/
        private String nombre;
        private int rut;
        private String servicio;
        
        /*Constructores*/
        public Orden(String nombre, int rut, String servicio) {
            this.nombre = nombre;
            this.rut = rut;
            this.servicio = servicio;
        }
        
        
        //Metodos

        /*Getter*/
        public String getNombre() {
            return nombre;
        }

        public int getRut() {
            return rut;
        }

        public String getServicio() {
            return servicio;
        }


        /*Setter*/
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setRut(int rut) {
            this.rut = rut;
        }

        public void setServicio(String servicio) {
            this.servicio = servicio;
        }

    }
