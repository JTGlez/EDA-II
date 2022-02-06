/*
 * Práctica #2: Algoritmos de ordenamiento Parte 2.
 * Ejercicio 4
 */

package practica2téllez;


public class Practica2Téllez {

    public static void main(String[] args) {
        
        double arr[]={142.14,125.64, 148.9, 127.83, 130.44, 132.66, 129.18, 127.64, 130.99, 133.53, 140.65, 135.58, 125.28, 129.75, 132.34,123.92,142.84,136.57,146.8,129.18,
141.82,	125.28,	129.75,	135.07,	142.14,
135.58,	125.28,	127.64,	130.99,	129.18,
142.14,	139.8,	143.94,	131.73,	139.3,
145.06,	140.95,	135.58,	141.82,	139.3,
136.57,	127.64,	137.5,	139.8,	128.61,
133.53,	137.5,	136.57,	127.83,	136.82,
142.84,	146.5,	140.65,	133.53,	135.58};
        int n=arr.length;
        Quicksort ordenamiento= new Quicksort();
        ordenamiento.sort(arr, 0, n-1);
        System.out.println("¡Tu arreglo ha sido ordenadoo!");
        Utilidades.printArray(arr);
    }

}
   
