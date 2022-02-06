/*
 * Practica 3: Algoritmos de ordenamiento.
 * Menu principal del programa.
 * Se omiten deliberadamente los acentos con fines de compatibilidad.
 */

package pr3;

import java.util.Scanner;
import java.util.ArrayList;

public class Pr3 {

    public static void main(String[] args) {

        int opcion = 0;
        System.out.println("Practica 3: Algoritmos de ordenamiento");
        while (opcion != 3) {

            System.out.println("");
            System.out.println("¿Que algoritmo desea utilizar?: 1)Counting-Sort 2)Radix-Sort 3)Salir del programa");
            Scanner menu = new Scanner(System.in);
            opcion = menu.nextInt();

            switch (opcion) {

                case 1: {

                    System.out.println("Usted ha elegido Counting-Sort.");
                    System.out.println("");
                    int[] arregloSec = new int[13];
                    char[] arregloOrdenado = new char[15];
                    char[] arreglo = new char[15];
                    Scanner entrada = new Scanner(System.in);

                    System.out.println("Escriba una cadena de 15 caracteres con rango [A-M]: ");
                    String letra = entrada.nextLine();
                    if (letra.isEmpty()) {
                        break;
                    }
                    arreglo = letra.toCharArray();
                    Utilerias.printArrayC(arreglo);

                    System.out.println("");
                    System.out.println("Ordenando el arreglo...");
                    System.out.println("");
                    CountingSort ordenCount = new CountingSort();

                    System.out.println("El arreglo introducido es: ");

                    Utilerias.printArrayC(arreglo);

                    System.out.println("Proceso de conteo de frecuencia de cada caracter: ");

                    arregloSec = ordenCount.conteo(arreglo, arregloSec);

                    Utilerias.printArray(arregloSec);

                    System.out.println("");
                    System.out.println("Creación del arreglo auxiliar de suma acumulada:");
                    System.out.println("");

                    int[] aux = ordenCount.intermedio(arregloSec);

                    Utilerias.printArray(aux);

                    System.out.println("");
                    System.out.println("Proceso final de ordenamiento...");
                    System.out.println("");

                    arregloOrdenado = ordenCount.ordenamiento(aux, arregloSec);

                    System.out.println("");
                    System.out.println("¡Felicidades! Su arreglo ha sido ordenado. :)");
                    System.out.println("");

                    Utilerias.printArrayC(arregloOrdenado);

                    break;

                }

                case 2: {

                    System.out.println("");
                    System.out.println("Usted ha elegido Radix-Sort.");
                    System.out.println("");
                    ArrayList<String> digitos = new ArrayList<String>();
                    Scanner lectura = new Scanner(System.in);

                    System.out.println("Ingrese un numero de 4 dígitos de [3-6]. Presione 2 veces Enter para proseguir.");
                    while (lectura.hasNextLine()) {
                        String numero = lectura.nextLine();
                        if (numero.isEmpty()) {
                            break;
                        }
                        digitos.add(numero);
                    }

                    System.out.println("Los numeros originales son: \n" + digitos);
                    System.out.println("");
                    System.out.println("Ordenando los numeros...");
                    System.out.println("");
                    RadixSort ordenamientoRadix = new RadixSort();
                    ordenamientoRadix.inicializacion();

                    System.out.println("¡Felicidades! Sus numeros han sido ordenados :) \n" + ordenamientoRadix.RadixSort(digitos));

                    break;

                }

                case 3: {
                    System.out.println("");
                    System.out.println("¡Adios!");
                    System.out.println("");
                    break;
                }

                default: {
                    System.out.println("");
                    System.out.println("Por favor seleccione una opcion correcta.");
                    System.out.println("");
                    break;

                }

            }

        }

    }

}
