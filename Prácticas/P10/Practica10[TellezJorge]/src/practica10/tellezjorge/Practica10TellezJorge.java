/*
 * Estructura de Datos y Algoritmos II: Practica #10: Archivos
 * 
 * Clase principal y operaciones sobre archivos.
 */
package practica10.tellezjorge;

import java.util.Scanner;

/**
 *
 * @author Tellez Gonzalez Jorge Luis
 */
public class Practica10TellezJorge {

    static Scanner lectorOpcion;
    static String rutaArchivo = "./Archivos/";

    public static void main(String[] args) {

        System.out.println("Estructura de Datos y Algoritmos II - Practica #10: "
                + "Archivos.\n");

        int opcionAlgoritmo = 0;
        while (opcionAlgoritmo != 5) {

            System.out.println("¿Que actividad desea realizar?"
                    + "\n1)Creacion de un archivo.\n2)Sobreescritura de un archivo.\n3)Edicion de un archivo.\n4)Eliminacion de un archivo.\n5)Salir del programa\n");

            lectorOpcion = new Scanner(System.in);
            System.out.print("Opción: ");
            opcionAlgoritmo = lectorOpcion.nextInt();

            switch (opcionAlgoritmo) {

                case 1: {

                    CrearArchivo.genFile();
                    break;
                }

                case 2: {

                    SobreescrituraArchivo.overwriteFile();
                    break;

                }

                case 3: {

                    EdicionArchivo.modifyFile();
                    break;

                }

                case 4: {

                    EliminacionArchivo.deleteFile();
                    break;

                }

                case 5: {

                    System.out.println("\n¡Adiós!\nSaliendo del programa...\n\n");

                    break;

                }

                default: {

                    System.out.println("\nPor favor seleccione una opción correcta.\n");
                    break;
                }
            }

        }

    }

}
