package Practica1Eda2;

public class Insercion{  
    
    public static void insertionSort(int array[]) {  
        int n = array.length;  //Es observable que Java ya posee un "atributo" predefinido para detectar el tamaño de un arreglo.
        for (int j = 1; j < n; j++) {  
            int key = array[j]; //El resto de la estructura es similar a la implementacion de C. La diferencia es que se intercambian las variables de control de cada ciclo.
            int i = j-1;  
            while ( (i > -1) && ( array [i] > key ) ) {  //Esta forma de hacer el ciclo me parecio un tanto confusa por el -1. El caso de C es mas natural de seguir.
                array [i+1] = array [i];  
                i--;  //Es como si estuviese "al reves" con respecto a la otra implementacion.
            }  
            array[i+1] = key;  
        }  
    } 
}