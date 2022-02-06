
public class MergeSort {

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    //Metodo creado para imprimir un sub-arreglo.
    static void printArray(int arr[], int inicio, int fin) {
        for (int i = inicio; i < fin; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    

    void merge(int arr[], int l, int m, int r) {
        /*El metodo recibe al arreglo, su posicion inicial/izquierda, 
        intermedia y final/derecha.
        */
        
        
        //Se calcula el tamaño de los sub-arreglos.
        int n1 = m - l + 1;
        int n2 = r - m;
        
        //Creacion de los arreglos secundarios.
        int L[] = new int[n1];
        int R[] = new int[n2];
        
        /*Los dos ciclos for a continuacion copian el contenido del arreglo
        original en los dos subarreglos.
        */
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }

        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        //Proceso de mezcla:
        
        //Indices iniciales del primer y segundo sub-arreglo.
        int i = 0, j = 0;
        
        
        //Primer indice del arreglo mezclado.
        int k = l;
        
        /* Procedimiento de comparacion y ordenamiento en el arreglo recibido.
        
        */
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        /*Se ordenan y copian los elementos restantes de L[] y  R[].
        
        */

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
         System.out.println("Arreglo izquierdo:");
         MergeSort.printArray(L);
         System.out.println("Arreglo derecho");
         MergeSort.printArray(R);
        
        
         System.out.println("Mezcla de sub-arreglos: ");
         MergeSort.printArray(arr, l, r+1);
    }

    void sort(int arr[], int l, int r) {
        /*El caso base de Merge-Sort sucede cuando l>=r, es decir, se tiene
        un sub arreglo que contiene menos de 2 elementos. Por tanto, la 
        condicion de division y combinacion es l<r.
         */
        if (l < r) {
            int m = (l + r) / 2;
            /*A continuacion se calcula el punto medio con el cual se 
            dividira recursivamente el arreglo de entrada en 2 partes.
            */
            sort(arr, l, m);
            sort(arr, m + 1, r);
            /*Finalmente, se unen los sub-arreglos en el arreglo ordenado.
            */
            
            merge(arr, l, m, r);
        }
    }

}
