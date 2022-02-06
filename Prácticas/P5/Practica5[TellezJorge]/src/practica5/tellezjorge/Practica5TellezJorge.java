/*
 * P5: Algoritmos de busqueda: Parte 2
 * 
 * 
 */
package practica5.tellezjorge;

import java.util.Scanner;

/**
 *
 * @autor: Tellez Gonzalez Jorge Luis
 */
public class Practica5TellezJorge {

    public static void main(String[] args) {

        int seleccion = 0;
        System.out.println("P5: Algoritmos de busqueda. ");
        while (seleccion != 4) {

            System.out.println("¿Que operacion desea utilizar?: ");
            System.out.println("1)Tablas Hash en Java.");
            System.out.println("2)Funcion Hash por modulo.");
            System.out.println("3)Encadenamiento.");
            System.out.println("4)Salir del programa.\n");
            System.out.print("Seleccion: ");


            Scanner menu = new Scanner(System.in);
            seleccion = menu.nextInt();

            switch (seleccion) {

                case 1: {

                    TablaHash opcionHash = new TablaHash();

                    opcionHash.aplicacionTabla();

                    break;
                }

                case 2: {

                    FuncionHash opcionFuncion = new FuncionHash();
                    
                    opcionFuncion.submenuHash(opcionFuncion);
                    break;
                }

                case 3: {

                    Encadenamiento opcionEnc = new Encadenamiento();
                    
                    opcionEnc.submenuEncad();

                    break;
                }

                case 4: {

                    System.out.println("¡Adios!");
                    break;

                }

                default: {

                    System.out.println("\nPor favor seleccione una opcion correcta.\n");


                    break;
                }

            }

        }

    }

}
