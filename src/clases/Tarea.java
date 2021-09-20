package clases;

//Autores: Kevin López - Andrés Ponce - Steven Quispe

import java.time.LocalDate;
import java.time.LocalTime;

//La clase tarea representa una de las actividades a registrarse
public class Tarea {
    //Atributos de la clase
    private int identificador;
    private String nombre;
    private String descripcion;
    private String fechaEnvio;
    private String fechaEntrega;
    private String horaEntrega;

    //**CONSTRUCTORES DE LA CLASE TAREA**
    public Tarea() {
        this.nombre = "";
        this.descripcion = "";
        this.fechaEnvio = "";
        this.fechaEntrega = "";
        this.horaEntrega = "";
        this.identificador = -1;
    }

    public Tarea(String nombre, String descripcion, String fechaEnvio, String fechaEntrega, String horaEntrega) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaEnvio = fechaEnvio;
        this.fechaEntrega = fechaEntrega;
        this.horaEntrega = horaEntrega;
        this.identificador = -1;
    }
    
    public Tarea(String nombre) {
        this.nombre = nombre;
        this.identificador = -1;
    }
    
    public int getIdentificador() {
        return identificador;
    }

    /**MÉTODOS DE OBTENCIÓN Y ESTABLECIMIENTO DE LOS ATRIBUTOS DE LAS TAREAS**/
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(String horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    @Override
    public String toString() {
        return "Identificador Hash: " + identificador + "\n"
                + "Nombre: " + nombre + "\n";
    }
    
    public String verDetalles(){
        return "Identificador Hash: " + identificador + "\n"
                + "Nombre: " + nombre + "\n"
                + "Fecha de envío: " + fechaEnvio + "\n"
                + "Fecha de entrega: " + fechaEntrega + "\n"
                + "Hora de entrega: " + horaEntrega + "\n"
                + "Descripción:" + descripcion + "\n";
    }
}
