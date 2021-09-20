
package clases;

//Autores: Kevin López - Andrés Ponce - Steven Quispe

import estructuras.Lista;

//La clase categoría representa a una lista de Tareas
public class ListaTareas extends Lista<Tarea>{
    //Atributos de la clase
    private Indices indices;

    //**CONSTRUCTOR POR DEFECTO DE LA CLASE**//
    public ListaTareas() {
        this.indices = new Indices();
    }
    
    //**MÉTODOS DE OBTENCIÓN Y ESTABLECIMIENTO DEL NOMBRE DE LA CATEGORÍA**
    
    //Método que, por tablas de Hash obtiene una tarea que se le solicita si existe.
    //Si no existe, se retorna null.
    public Tarea obtener(Tarea instancia){
        if(this.existe(instancia)){
            return (Tarea)indices.busqueda(instancia);
        }
        return null;
    }
    
    /**Métodos sobrecargados de la agregación y eliminación de datos. Se implementa la tabla de Hash.**/

    @Override
    public void agregarFinal(Tarea info) {
        info.setIdentificador(this.indices.exploracionLineal(info));
        indices.agregarElemento(info);
        super.agregarFinal(info);
    }
    
    @Override
    public boolean existe(Tarea instancia) {
        return indices.busqueda(instancia) != null;
    }

    @Override
    public void eliminar(Tarea instancia) {
        super.eliminar(instancia);
        this.indices.eliminarElemento(instancia);
    }
}
