package estructuras;

//Autores: Kevin López - Andrés Ponce - Steven Quispe

public class Lista<E> {
    //Clase de tipo genérica que representa a la estructura de datos de tipo Lista.
    //Es genérica porque E representa a cualquier tipo de dato. Se inicializará, por ejemplo, para strings como Lista<String>.
    
    //Atributos de la clase
    private Nodo<E> primerElemento; //Apuntador al primer elemento de la lista.
    private Nodo<E> ultimoElemento; //Apuntador al último elemento de la lista.
    private int tamanio; //Tamaño
    
    //Constructor de la clase
    //No contiene argumentos e inicia primerElemento y ultimoElemento como null. El tamaño inicia en 0.
    public Lista() {
        this.primerElemento = null;
        this.ultimoElemento = null;
        this.tamanio = 0;
    }

    /**MÉTODOS DE OBTENCIÓN DE LOS ATRIBUTOS DE LA LISTA**/
    public Nodo<E> getPrimerElemento() {
        return primerElemento;
    }

    public Nodo<E> getUltimoElemento() {
        return ultimoElemento;
    }

    public int getTamanio() {
        return tamanio;
    }
    
    //Método que obtiene verdadero cuando la lista está vacía
    public boolean estaVacia(){
        return this.primerElemento == null;
    }
    
    //***MÉTODOS DE AGREGAMIENTO DE DATOS***
    
    //Al inicio de la lista
    public void agregarInicio(E info) {
	Nodo<E> n = new Nodo<E>(info);
        n.setSiguiente(this.primerElemento);
        
	if(this.estaVacia()){
            this.ultimoElemento = n;
        }
        
        this.primerElemento = n;
	n = null;
        this.tamanio++;
    }
    
    //Al final de la lista
    public void agregarFinal(E info){
        Nodo<E> n = new Nodo<E>(info);
        
        if(this.estaVacia()){
            this.agregarInicio(info);
        }else{
            this.ultimoElemento.setSiguiente(n);
            this.ultimoElemento = n;
            this.tamanio++;
        }
    }
    
    //***MÉTODOS DE ELIMINACIÓN***
    //Borrar el primer elemento de la lista
    public void eliminarInicio(){
        if(!estaVacia()){
            if(this.tamanio == 1){
                this.limpiar();
            }else{
                this.primerElemento = this.primerElemento.getSiguiente();
            }
            tamanio--;
        }
    }
    
    //Borrar el último elemento de la lista
    public void eliminarFin(){
        if(!estaVacia()){
            if(this.tamanio == 1){
                this.limpiar();
            }else{
                Nodo<E> aux = this.primerElemento;
                while(aux.getSiguiente().getSiguiente() != null){
                    aux = aux.getSiguiente();
                }
                this.ultimoElemento = aux;
                this.ultimoElemento.setSiguiente(null);
            }
            tamanio--;
        }
    }
    
    //Borrar un elemento específico de la lista. Se borra en específico la primera instancia
    public void eliminar(E instancia){
        if(!this.estaVacia() && this.existe(instancia)){
            if(this.tamanio == 1){
                this.limpiar();
            }else{
                Nodo<E> anterior, actual;
                actual = this.primerElemento;
                anterior = null;
                while(actual != null && actual.getInfo() != instancia){
                    anterior = actual;
                    actual = actual.getSiguiente();
                }
                
                if(anterior == null){
                    this.eliminarInicio();
                    tamanio++;
                }else{
                    anterior.setSiguiente(actual.getSiguiente());
                    if(anterior.getSiguiente() == null){
                        this.ultimoElemento = anterior;
                    }
                }
            }
            tamanio--;
        }   
    }
    
    //Método que recorre la Lista en busca de su existencia.
    //Retorna verdadero cuando lo encuentra, y falso cuando no.
    public boolean existe(E instancia){
        Nodo<E> aux = this.primerElemento;
        while(aux != null){
            if(aux.getInfo() == instancia){
                return true;
            }else{
                aux = aux.getSiguiente();
            }
        }
        return false;
    }
    
    //Método que limpiar la lista al restaurar los apuntadores a su estado inicial.
    public void limpiar(){
        this.primerElemento = null;
        this.ultimoElemento = null;
        this.tamanio = 0;
    }

    //Método sobrecargado para representar una lista como String.
    @Override
    public String toString() {
        String str = "";
        Nodo<E> aux = this.primerElemento;
        
        while(aux != null){
            str += aux.getInfo().toString() + "\n";
            aux = aux.getSiguiente();
        }
        return str;
    }
}
