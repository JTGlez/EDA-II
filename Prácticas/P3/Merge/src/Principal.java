
public class Principal {

    public static void main(String args[]) 
    { 
        
        //Declaracion de arreglo estatico y proceso de ordenamiento.
        int array[]= {5,3,7,6,9,1,4,8,2};
        System.out.println("El arreglo original es:");
        MergeSort.printArray(array);
        System.out.println("");
        System.out.println("Inicio del proceso de particion...");
        MergeSort ordenamiento=new MergeSort();
        ordenamiento.sort(array,0,8);
        System.out.println("");
        System.out.println("¡Felicidades! Su arreglo ha sido ordenado.");
        MergeSort.printArray(array);
        
    } 
} 
    
    

