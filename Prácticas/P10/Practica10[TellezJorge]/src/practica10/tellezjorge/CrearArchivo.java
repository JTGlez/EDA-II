/*
 * Estructura de Datos y Algoritmos II: Practica #10: Archivos
 * 
 * Clase CrearArchivo.
 */
package practica10.tellezjorge;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Tellez Gonzalez Jorge Luis
 */
public class CrearArchivo {

    static Scanner lectorCadena = new Scanner(System.in);

    public static void genFile() {

        try {
            System.out.println("\nUsted ha seleccionado: Creacion de un archivo.\n");
            System.out.print("Ingrese el nombre del archivo que desea crear: ");
            String nombreDelArchivo = lectorCadena.nextLine();
            File archivoCreado = new File(Practica10TellezJorge.rutaArchivo + nombreDelArchivo + ".txt");

            if (archivoCreado.exists()) {
                System.out.println("\n¡Ya existe un archivo con el nombre indicado!\n");

            } else {
                archivoCreado.createNewFile();
                System.out.println("A continuacion, ingrese contenido en el archivo: ");

                try (BufferedWriter bufferEscritor = new BufferedWriter(new FileWriter(archivoCreado))) {
                    bufferEscritor.write(lectorCadena.nextLine());
                    System.out.println("\nOperacion realizada con exito.\n");
                    bufferEscritor.close();
                }

            }

        } catch (IOException ex) {
            System.out.println("\nSe detectó un error en la lectura/escritura"
                    + " del archivo. Verifique su integridad. \n");
        }

    }

}
