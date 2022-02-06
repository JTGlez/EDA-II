package Practica1Eda2;

public class Seleccion {  
   
    public void selectionSort(int[] arr){  
        int n = arr.length; //Se obtiene el tamaño del arreglo.
        for (int i = 0; i < n - 1; i++){  
            int min = i;  //Flujo similar a la implementacion de C.
            for (int j = i + 1; j < n; j++){  
                if (arr[j] < arr[min]){  
                    min = j;  
                }                      
            }  
            //Aqui se carece de la condicional del if y prosigue directamente llamar al metodo intercambiar.
            //Por que aqui se envian tres parametros? 
            Utilerias.intercambiar(arr, i,min);
            //Despues de observar la clase Utilerias comprendo mejor el por que. Me parece que ya se parte del hecho
            //que i!=min. Tengo que admitir que me queda un poco la duda con respecto al flujo del metodo.
                 
        }  
    }  

}  