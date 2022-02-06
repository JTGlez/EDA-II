/*
 * Estructura de Datos y Algoritmos II: Practica #10: Archivos
 * 
 * Clase SobreescrituraArchivo.
 */
package practica10.tellezjorge;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Tellez Gonzalez Jorge Luis
 */
public class SobreescrituraArchivo {
    
    static Scanner lectorCadena = new Scanner(System.in);

    public static void overwriteFile() {

        try {
            System.out.println("\nUsted ha seleccionado: Sobreescritura de un archivo.\n");
            System.out.print("Ingrese el nombre del archivo que desea sobreescribir: ");
            String nombreDelArchivo = lectorCadena.nextLine();
            File archivoTarget = new File(Practica10TellezJorge.rutaArchivo + nombreDelArchivo + ".txt");

            if (archivoTarget.exists()) {
                System.out.println("A continuacion, ingrese el nuevo contenido en el archivo: ");

                try (BufferedWriter bufferEscritor = new BufferedWriter(new FileWriter(archivoTarget, false))) {
                    bufferEscritor.write(lectorCadena.nextLine());
                    System.out.println("\nOperacion realizada con exito.\n");
                    bufferEscritor.close();
                }

            } else {

                System.out.println("\n¡No existe un archivo con el nombre indicado!\n");

            }

        } catch (IOException ex) {
            System.out.println("\nSe detectó un error en la lectura/escritura"
                    + " del archivo. Verifique su integridad. \n");
        }

    }

}
