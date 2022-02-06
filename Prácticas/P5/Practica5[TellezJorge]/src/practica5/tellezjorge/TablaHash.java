/*
 * P5: Algoritmos de busqueda: Parte 2
 * 
 * 
 */
package practica5.tellezjorge;

import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @autor: Téllez González Jorge Luis
 */
public class TablaHash {

    private Hashtable<Integer, ArrayList<String>> alumnos;
    private Hashtable<Integer, String> individuales, equiparables;

    public void aplicacionTabla() {

        int opcionReinicio=0;
        System.out.println("Bienvenido a los ejemplos del uso de los métodos asociados a Hashtable.\n");

        while (opcionReinicio!=2) {

            System.out.println("\n*********Prueba de los métodos de HashTable*********\n");

            System.out.println("A continuacion sera creada una Tabla Hash que almacene el nombre "
                    + "completo de un alumno y su numero de cuenta como su respectiva clave. \n");

            individuales = new Hashtable<>();

            System.out.println("1. Metodo put:");
            System.out.println("");

            individuales.put(315132726, "Tellez Gonzalez Jorge Luis");
            individuales.put(452727153, "Alfonso Perez Manuel");
            individuales.put(583738267, "Arteaga Roberto Carlos");
            individuales.put(203846379, "Garcia Saavedra Miguel");
            individuales.put(310383625, "Gonzalez Noreen Xiadani");

            System.out.println("La Tabla Hash creada contiene los siguientes elementos iniciales...");
            System.out.println("");
            System.out.println(individuales);
            System.out.println("\n");

            System.out.println("2. Metodo contains:");
            System.out.println("¿Existe el alumno Cervantes Moreno Gabriel en la tabla individuales?: " 
                    + individuales.contains("Cervantes Moreno Gabriel"));
            System.out.println("");

            System.out.println("3. Metodo containsKey:");
            System.out.println("¿Existe el alumno Téllez González Jorge Luis en la tabla individuales?: " 
                    + individuales.containsKey(315132726));
            System.out.println("");

            System.out.println("4. Metodo containsValue:");
            System.out.println("¿El alumno con cuenta 203846379 se encuentra en la lista?: " 
                    + individuales.containsValue("Garcia Saavedra Miguel"));
            System.out.println("");

            System.out.println("5. Metodo equals:");
            equiparables = new Hashtable<>();
            equiparables.put(315132726, "Tellez Gonzalez Jorge Luis");
            equiparables.put(452727153, "Alfonso Perez Manuel");
            equiparables.put(583738267, "Arteaga Roberto Carlos");
            equiparables.put(203846379, "Garcia Saavedra Miguel"); //Falta un nombre, la salida resulta false.

            System.out.println("¿La Tabla Hash equiparables e individuales contienen las mismas claves y elementos?: " 
                    + individuales.equals(equiparables));
            System.out.println("");

            System.out.println("6. Metodo get:");
            System.out.println("El Nombre del alumno con cuenta 452727153 es: " 
                    + individuales.get(452727153));
            System.out.println("");

            System.out.println("7. Metodo remove:");
            System.out.println("Expulsaron a Alfonso...");
            individuales.remove(452727153);
            System.out.println("");

            System.out.println("8. Metodo size:");
            System.out.println("¿Cuantos alumnos quedan en la tabla?: " + individuales.size());
            System.out.println("Jajajaj eso le pasa por reirse en los honores.");
            System.out.println(individuales);
            System.out.println("");

        /*
        Lo anterior es un experimento utilizando HashTables y ArrayLists para almacenar listas con una clave asociada, donde la clave representa
        el grado de los alumnos y la lista contiene los nombres de cada alumno en ese grado. 
        */
            
            System.out.print("¿Desea observar un ejemplo adicional con listas? \n1)Si \n2)No\n\nSeleccion: ");
            Scanner lectura = new Scanner(System.in);
            int opcion = lectura.nextInt();

            if (opcion == 1) {

                System.out.println("*********Segunda Prueba de los métodos de HashTable*********\n");

                System.out.println("A continuacion sera creada una Tabla Hash que almacene listas con nombres de alumnos y su respectivo grado escolar como identificador asociado. \n");

                alumnos = new Hashtable<>();
                ArrayList listaA = new ArrayList<>();

                listaA.add("Téllez González Jorge Luis");
                listaA.add("Salazar Fuentes Enrique Antonio");

                System.out.println("La lista A contiene a los alumnos de primer grado: " + listaA);

                ArrayList listaB = new ArrayList<>();

                listaB.add("Fuentes de Ortiz Manuel");
                listaB.add("Barbosa Mendez Alejandro ");
                listaB.add("Roberto Carlos");

                System.out.println("La lista B contiene a los alumnos de tercer grado: " + listaB);
              

                System.out.println("\n1. Metodo put:");
                System.out.println("");
                alumnos.put(1, listaA);
                alumnos.put(3, listaB);
                System.out.println("\nSe han añadido los alumnos de ambos grados a la tabla hash.\n");
                System.out.println("\nImpresión de la tabla hash de registro: ");
                System.out.println(alumnos);
                System.out.println("");

                System.out.println("2. Metodo contains:");
                System.out.println("¿La tabla contiene a los alumnos de la lista A?: " + this.alumnos.contains(listaA));
                System.out.println("");

                System.out.println("3. Metodo containsKey:");
                System.out.println("¿Se encuentran registrados los alumnos de sexto grado en la tabla Hash?: " + this.alumnos.containsKey(6));
                System.out.println("");

                System.out.println("4. Metodo containsValue:");
                System.out.println("¿La tabla contiene a los alumnos de la lista B?: " + this.alumnos.containsValue(listaB));
                System.out.println("");

                System.out.println("5. Metodo equals:");
                System.out.println("¿Solo los alumnos de la lista A se encuentran registrados en la tabla?: " + this.alumnos.equals(listaA));
                System.out.println("");

                System.out.println("6. Metodo get:");
                System.out.println("Los alumnos de primer grado registrados son: " + this.alumnos.get(1));
                System.out.println("");

                System.out.println("7. Metodo remove:");
                System.out.println("¡Se cayó el sistema! Perdimos los registros de los alumnos de tercer grado...");
                alumnos.remove(3);
                System.out.println("");

                System.out.println("8. Metodo size:");
                System.out.println("¿Cuantos grados contiene en total registrados la tabla?: " + alumnos.size());
                System.out.println("");

            }
            
            System.out.print("¿Desea volver a ver los ejemplos? \n1)Si\n2)No\n\nSeleccion: " );
            opcionReinicio= lectura.nextInt();

        }

        System.out.println("Saliendo de las tablas hash...\n");

    }

}
