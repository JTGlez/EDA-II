/*
 * Practica 3: Algoritmos de ordenamiento.
 * Implementacion de Radix-Sort en Java.
 * 
 */
package pr3;

import java.util.ArrayList;

/**
 *
 * @author jorje
 */
public class RadixSort {

    //Declaracion de listas para cada digito.
    private ArrayList<String> lista3;
    private ArrayList<String> lista4;
    private ArrayList<String> lista5;
    private ArrayList<String> lista6;

    public void inicializacion() {

        lista3 = new ArrayList<String>();
        lista4 = new ArrayList<String>();
        lista5 = new ArrayList<String>();
        lista6 = new ArrayList<String>();
        
    }
    
    //Proceso iterativo de adicion al arreglo. Limpieza posterior. 

    public ArrayList<String> RadixSort(ArrayList<String> lista) {

        int k=0;
        for (int j = 4; j >= 1; j--) {
            for (String i : lista) {
                switch (i.charAt(j - 1)) {
                    case '3':
                        this.lista3.add(i);
                        break;
                    case '4':
                        this.lista4.add(i);
                        break;
                    case '5':
                        this.lista5.add(i);
                        break;
                    case '6':
                        this.lista6.add(i);
                        break;

                }
            }
            lista.clear();
            lista.addAll(lista3);
            lista.addAll(lista4);
            lista.addAll(lista5);
            lista.addAll(lista6);
            lista3.clear();
            lista4.clear();
            lista5.clear();
            lista6.clear();
            k++;
            System.out.println("Iteracion: " +k);
            System.out.println(lista);
        }
        return lista;
    }

}
