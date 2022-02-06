/*
 * P5: Algoritmos de busqueda: Parte 2
 * 
 * 
 */
package practica5.tellezjorge;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @autor: Téllez González Jorge Luis
 */
public class Encadenamiento {

    private Hashtable<Integer, ArrayList<Integer>> listasEnteros;
    private ArrayList<Integer> listaEntero;
    private ArrayList<ArrayList<Integer>> listaAEntero;
    public Scanner lectura;

    public void inicializacion() {

        listasEnteros = new Hashtable<>();
        
        for (int i = 0; i < 15; i++) {
            
            listasEnteros.put(i, new ArrayList<>());
            
        }
        
    }
    
    public void inicializacionAnidada(){
        
        listaAEntero = new ArrayList<>();
        
        for (int i = 0; i < 15; i++) {
            
            listaAEntero.add(i, new ArrayList<>());
            
        }
    
    
    
    }

    public void submenuEncad() {

        inicializacion();
        inicializacionAnidada();
        int seleccion3 = 0;
        while (seleccion3 != 3) {

            System.out.println("¿Que desea hacer?: ");
            System.out.println("1)Agregar elementos (Uso de tablas hash).");
            System.out.println("2)Agregar elementos (Uso de arreglos anidados)");
            System.out.println("3)Salir de la opcion seleccionada.\n");
            System.out.print("Seleccion: ");

            lectura = new Scanner(System.in);
            seleccion3 = lectura.nextInt();

            switch (seleccion3) {

                case 1: {

                    System.out.print("\nIngrese el número que desea agregar a la lista: ");
                    int valorAInsertar = lectura.nextInt();
                    int claveLista = funcionAleatoria(valorAInsertar);
                    listasEnteros.get(claveLista).add(valorAInsertar);
                    System.out.println(listasEnteros);

                    break;
                }

                case 2: {

                    System.out.print("\nIngrese el número que desea agregar a la lista: ");
                    int valorAInsertar = lectura.nextInt();
                    int claveLista = funcionAleatoria(valorAInsertar);
                    listaAEntero.get(claveLista).add(valorAInsertar);
                    System.out.println(listaAEntero);
                    break;
                }
                
                case 3: {
                
                    System.out.println("\nRegresando al menu principal...");
                    System.out.println("");
                    break;
                
                }

                default: {
                    System.out.println("\nPor favor seleccione una opcion correcta.\n");
                    break;
                }

            }
        }

    }

    public int funcionAleatoria(int valorIngresado) {

        Random posicionAleatoria = new Random(System.currentTimeMillis());
        int posicion = posicionAleatoria.nextInt(15);
        System.out.println("El elemento " + valorIngresado +
                " ha sido ingresado a la lista: " + posicion);
        return posicion;
    }

}
