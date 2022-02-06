package Practica1Eda2;


public class Utilerias {
    
    public static void imprimirArreglo(int[] arreglo){
        for(int i:arreglo){ //Esta forma de realizar un ciclo for que nunca habia visto. 
            System.out.print(i+" ");  //Puedo suponer que este print imprime la posicion i del arreglo y el otro print pone un espacio entre cada dato.
        }
        System.out.println(" ");
    }

    public static void intercambiar(int[] arr, int x, int y) {
        int temp = arr[x];  //Este swap es mucho mas sencillo que el de C.
       //Tan solo guarda el primer valor recibido en una variable temporal, asigna en que arr[x] lo que estaba en arr[y]
        arr[x] = arr[y];  
        arr[y] = temp; //Finalmente, lo que estaba en arr[x] se guarda en arr[y]. Bastante intuitivo y sencillo de seguir.
                       //...a diferencia del uso de apuntadores en C. 
    }
}
