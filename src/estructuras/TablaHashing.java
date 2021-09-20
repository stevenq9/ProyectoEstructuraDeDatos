
package estructuras;

    //Autores: Kevin López - Andrés Ponce - Steven Quispe
public abstract class TablaHashing <E>{
    //Clase de tipo genérica que representa a la tabla de Hashing.
    //Es genérica porque E representa a cualquier tipo de dato. Se inicializará, por ejemplo, para strings como TablaHashing<Tarea>.

    //Atributos de la clase
    private Object[] tabla;
    private final float gradoOcupacionMinimo = 0.65f;
    private final float gradoOcupacionMaximo = 0.8f;
    private int numeroElementos;

    //Constructor de la tabla Hash. Inicia una tabla de 2 elementos.
    public TablaHashing() {
        this.tabla = new Object[2];
        this.numeroElementos = 0;
    }
    
    //Métodos de obtención del número de elementos.
    public int getTamanioTabla() {
        return this.tabla.length;
    }
    
    //Método de obtención de la tabla de Hashing
    public Object[] getTabla() {
        return tabla;
    }
    
    //Función Hash que se definirá para los objetos. Es abstracta porque dependerá del tipo de dato
    public abstract int funcionHash(E elemento);
    
    //Método que amplia el arreglo de la tabla Hash, con el fin de generar un número ilimitado de casos. Aunque su costo es alto.
    private void ampliarArreglo(){
        Object[] copia = tabla.clone();
        int tamanioNuevo = (int)(Math.round(copia.length / gradoOcupacionMinimo));
        tabla = new Object[tamanioNuevo];
        
        //Función de Java que permite copiar la información del arreglo anterior al nuevo ampliado.
        System.arraycopy(copia, 0, tabla, 0, copia.length);
    }
    
    //Auxiliar del método agregar datos a la tabla de hash para todos los usuarios.
    public void agregarElemento(E dato){
        this.agregarElemento(dato, funcionHash(dato));
    }
    
    //Auxiliar del método eliminar datos a la tabla de hash para todos los usuarios.
    public void eliminarElemento(E dato){
        if(this.busqueda(dato) != null){
            this.eliminarElemento(this.busqueda(dato), funcionHash(dato));
        }
    }
    
    //Método que retorna la posición Hash de un elemento teniendo en cuenta las colisiones.
    public int exploracionLineal(E elemento){
        return exploracionLineal(this.funcionHash(elemento));
    }
    
    private int exploracionLineal(int posicion){
        int contador = 0;
        for(int i = posicion; contador < this.tabla.length; i = (i + 1) % this.tabla.length){//Al terminar de recorrer la posición, vuelve al inicio
            if(this.tabla[i] == null){
                return i;
            }
            contador++;
        }
        return -1;
    }

    //Método que contiene la función de agregar un elemento a una determinada posición de Hashing.
    //Si el grado de ocupación actual = elementos registrados / tamaño de la tabla es mayor a 0.8, se procederá a ampliar la tabla.
    //Además, se implementa la solución de colisiones por la exploración cuadrática.
    //Se usa el valor null para saber que no existe colisión
    private void agregarElemento(E dato, int posicion){
        posicion = exploracionLineal(posicion);
        
        tabla[posicion] = dato;
        this.numeroElementos++;
        
        if((this.numeroElementos / this.tabla.length) > this.gradoOcupacionMaximo){
            this.ampliarArreglo();
        }
    }
    
    //Método que elimina un dato de la tabla de Hash en caso de que exista.
    //Realiza una exploración lineal, para que la búsqueda sea consistente.
    private void eliminarElemento(E dato, int posicion){
        int contador = 0;
        for(int i = posicion; contador < this.tabla.length; i = (i + 1) % this.tabla.length){//Al terminar de recorrer la posición, vuelve al inicio
            if(this.tabla[i] == dato){
                this.tabla[i] = null;//Se anula el elemento si se encuentra
                break;
            }
            contador++;
        }
        this.numeroElementos--;
    }
    
    //Método abstracto de búsqueda de datos. Dependerá de su tipo de dato.
    public abstract E busqueda(E dato);
}
