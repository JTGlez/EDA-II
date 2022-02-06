package Practica1Eda2; 
//El paquete Practica1Eda2 contiene una clase principal, dos clases con su algoritmo de ordenamiento respectivo y una clase de utilerias.
public class Principal {
    
    public static void main(String args[]){ //Java pide que este metodo siempre se encuentre en la clase principal.
        int[] arr1 = {9,14,3,2,43,11,58,22}; //Arreglos fijos declarados.
        int[] arr2 = {10,15,4,3,44,12,59,23}; 

        System.out.println("Arreglos Originales");  
        Utilerias.imprimirArreglo(arr1); //Se llama a la clase utilerias y se le envia a uno de sus metodos los 2 arreglos para imprimirlos.
        Utilerias.imprimirArreglo(arr2);
        
        Insercion.insertionSort(arr1); //Se envia arr1 al metodo insertionSort.
        
        Seleccion seleccion = new Seleccion(); //Se crea un objeto del tipo Seleccion llamado "seleccion". No posee atributos.
        seleccion.selectionSort(arr2);  //Se usa uno de los metodos del objeto para enviar a arr2 y ordenarlo con selectionSort.
       
             
        System.out.println("Arreglos ordenados");  
        Utilerias.imprimirArreglo(arr1); //Se imprimen los arreglos ordenados.
        Utilerias.imprimirArreglo(arr2);
        
    }  
    
   
}
