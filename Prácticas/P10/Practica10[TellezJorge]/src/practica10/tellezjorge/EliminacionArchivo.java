/*
 * Estructura de Datos y Algoritmos II: Practica #10: Archivos
 * 
 * Clase EliminacionArchivo.
 */
package practica10.tellezjorge;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Tellez Gonzalez Jorge Luis
 */
public class EliminacionArchivo {

    static Scanner lectorCadena = new Scanner(System.in);

    public static void deleteFile() {

        System.out.println("\nUsted ha seleccionado: Eliminacion de un archivo.\n");
        System.out.print("Ingrese el nombre del archivo que desea eliminar: ");
        String nombreDelArchivo = lectorCadena.nextLine();
        File archivoAEliminar = new File(Practica10TellezJorge.rutaArchivo + nombreDelArchivo + ".txt");
        if (archivoAEliminar.exists()) {

            archivoAEliminar.delete();
            System.out.println("\nEl archivo: " + nombreDelArchivo + " ha sido eliminado."
                    + "\nOperacion realizada con exito.\n");

        } else {

            System.out.println("\n¡No existe un archivo con el nombre indicado!\n");

        }

    }

}
