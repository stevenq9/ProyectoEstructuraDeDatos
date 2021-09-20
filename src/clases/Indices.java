package clases;

//Autores: Kevin López - Andrés Ponce - Steven Quispe

import estructuras.*;

//Clase que permite obtener los códigos Hash de las Tareas, se encarga de la búsqueda y guardado de elementos en una tabla.
public class Indices extends TablaHashing<Tarea>{

    //Para la clase tarea se va a utilizar la función hash por pliegue.
    //Va agrupando datos dependiendo del número de dígitos que contiene la tabla. De 1 en 1 para 1, de 2 en 2 para 2 dígitos, etc.
    //Para ello obtiene cuántos saltos debe realizar con el logaritmo de base 10 del tamaño de la tabla.
    //Por último, para asegurarse que no exista un desbordamiento porque el índice sea mayor, se retornará su módulo.
    @Override
    public int funcionHash(Tarea elemento) {
        int indice = 0;
        String auxiliar = elemento.getNombre();
        
        //Se define el número máximo de pasos a realizar. Es decir, si se agrupa de 1 en 1, 2 en 2, etc.
        int pasoMaximo = (int)Math.log10(this.getTamanioTabla()) + 1;
                
        for(int i = 0; i < auxiliar.length(); i++){
            int paso = 0;
            while(paso < pasoMaximo || i < auxiliar.length()){
                indice *= 10;
                indice += auxiliar.charAt(i);
                i++;
                paso++;
            }
        }
        //Se asegura que el resultado sea menor que el tamaño de la tabla y positivo.
        return Math.abs(indice % this.getTamanioTabla());
    }

    
    //Método que busca en la tabla de Hash si el elemento existe.
    //Utiliza la exploración lineal para que, en el peor de los casos, recorra todo el arreglo en su búsqueda.
    //Como clave de búsqueda utiliza el nombre de la tarea, debido a que es parámetro de hash.
    @Override
    public Tarea busqueda(Tarea dato) {
        int posicion = this.funcionHash(dato);
        
        Tarea auxiliar;
        
        int contador = 0;
        
        for(int i = posicion; contador < super.getTabla().length; i = (i + 1) % super.getTabla().length){//Al terminar de recorrer la posición, vuelve al inicio
            auxiliar = (Tarea)super.getTabla()[i];
            if(auxiliar != null && auxiliar.getNombre().equalsIgnoreCase(dato.getNombre())){
                return auxiliar;
            }
            contador++;
        }
        
        return null;
    }
    
}
