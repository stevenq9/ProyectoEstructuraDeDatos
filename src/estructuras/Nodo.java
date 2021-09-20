
package estructuras;

//Autores: Kevin López - Andrés Ponce - Steven Quispe

public class Nodo<E> {
    //Clase de tipo genérica que representa al elemento de una lista simplemente enlazada.
    //Es genérica porque E representa a cualquier tipo de dato. Se inicializará, por ejemplo, para enteros como Nodo<Integer>.
    
    //Atributos de la clase
    private E info; //Campo de información del nodo. Es de tipo E definido por el usuario.
    private Nodo<E> siguiente; // Campo que contiene una referencia al siguiente elemento de la lista.
    
    //Constructor de la clase.
    //Contiene como argumento el dato y su referencia será nula.

    public Nodo(E info) {
        this.info = info;
        this.siguiente = null;
    }
    
    //Métodos de obtención y establecimiento de los atributos de la clase.

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public Nodo<E> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<E> siguiente) {
        this.siguiente = siguiente;
    }
}
