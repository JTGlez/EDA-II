/*
 * Practica 3: Algoritmos de ordenamiento.
 * Implementacion de Counting-Sort en Java.
 */
package pr3;

public class CountingSort {
    
    //Metodo que se encarga de contar la incidencia de valores. Se considera el codigo ASCII. 
    public int[] conteo(char[]datos, int[] contador ){
        
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j <13; j++) {
                if(datos[i]==(char) (j+65)) {
                    contador[j]++;
                    Utilerias.printArray(contador);
                }
            }
        }
        return contador;
    }
    
    //Arreglo auxiliar utilizado como intermediario.
    public int[] intermedio(int [] arreglo){
    
    int [] arregloAux;
    arregloAux=new int[arreglo.length];
    int conteo=0;
    
        for (int i = 0; i < arreglo.length; i++) {
            
            conteo=arreglo[i]+conteo;
            arregloAux[i]=conteo;
            
        }
        
    return arregloAux;
    
    }
    
    //Proceso final de ordenado. 
    public char [] ordenamiento(int [] arregloAux, int []contador){
    
        char [] arregloOrdenado = new char[15];
        int elemento=-1;
        
        for (int i = 0; i < arregloAux.length; i++) {
            
            for (int j = arregloAux[i]-1; j > elemento; j--) {
                
                arregloOrdenado[j]=(char) (i+65);
                Utilerias.printArrayC(arregloOrdenado);
            }
            elemento=arregloAux[i]-1;          
        }   
        return arregloOrdenado; 
    }
    
}
