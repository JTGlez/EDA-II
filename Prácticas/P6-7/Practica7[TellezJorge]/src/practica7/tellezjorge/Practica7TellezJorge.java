/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica7.tellezjorge;

import java.util.Scanner;

/**
 *
 * @author jorje
 */
public class Practica7TellezJorge {

    public static void main(String[] args) {

        int V, opcionMenu = 0;

        System.out.println("Practica #6: Algoritmos de grafos. \n");
        while (opcionMenu != 2) {

            System.out.println("\n¿Qué operacion desea realizar? \n1)Ejecucion de DFS \n2)Salir del programa.\n");

            System.out.print("Opcion: ");
            Scanner lectura = new Scanner(System.in);
            opcionMenu = lectura.nextInt();
            System.out.println("");

            switch (opcionMenu) {

                case 1: {
                    V = 8;

                    System.out.println("Creando el nuevo grafo...");
                    Grafo gDFS = new Grafo(V);

                    gDFS.addEdge(0, 2);
                    gDFS.addEdge(0, 4);
                    gDFS.addEdge(0, 6);
                    gDFS.addEdge(1, 5);
                    gDFS.addEdge(3, 7);
                    gDFS.addEdge(4, 5);
                    gDFS.addEdge(4, 7);
                    gDFS.addEdge(5, 7);           
                    
                    System.out.println("Imprimiendo la lista de adyacencia del grafo...");
                    
                    
                    gDFS.printGraph(gDFS);
                    System.out.print("Recorrido desde el vertice 0: ");
                    gDFS.DFS(0);
                    System.out.println("\n");
                    System.out.print("Recorrido desde el vertice 3: ");
                    gDFS.DFS(3);
                    System.out.println("\n");
                    System.out.print("Recorrido desde el vertice 7: ");
                    gDFS.DFS(7);
                    System.out.println("\n\n");
                    
                    V = 6;
                    
                    System.out.println("Creando otro grafo nuevo...");
                    Grafo gDFS2 = new Grafo(V);
                    
                    gDFS2.addEdge(0, 1);
                    gDFS2.addEdge(0, 2);
                    gDFS2.addEdge(1, 3);
                    gDFS2.addEdge(3, 4);
                    gDFS2.addEdge(3, 5);
                    
                    System.out.println("Imprimiendo la lista de adyacencia del grafo...");
                    gDFS2.printGraph(gDFS2);
                    System.out.print("Recorrido desde el vertice 0: ");
                    gDFS2.DFS(0);
                    System.out.println("\n");
                    System.out.print("Recorrido desde el vertice 3: ");
                    gDFS2.DFS(3);
                    System.out.println("\n");
                    System.out.print("Recorrido desde el vertice 5: ");
                    gDFS2.DFS(5);
                    System.out.println("\n\n");
                    
                    V = 7;
                    
                    System.out.println("Creando otro grafo nuevo...");
                    Grafo gDFS3 = new Grafo(V);
                    
                    gDFS3.addEdge(0, 1);
                    gDFS3.addEdge(0, 2);
                    gDFS3.addEdge(1, 3);
                    gDFS3.addEdge(1, 4);
                    gDFS3.addEdge(2, 5);
                    gDFS3.addEdge(2, 6);
                    
                    System.out.println("Imprimiendo la lista de adyacencia del grafo...");
                    gDFS3.printGraph(gDFS3);
                    System.out.print("Recorrido desde el vertice 0: ");
                    gDFS3.DFS(0);
                    System.out.println("\n");
                    System.out.print("Recorrido desde el vertice 3: ");
                    gDFS3.DFS(3);
                    System.out.println("\n");
                    System.out.print("Recorrido desde el vertice 5: ");
                    gDFS3.DFS(5);
                    System.out.println("\n\n");
                    
                    V = 5;
                    
                    System.out.println("Creando un último grafo...");
                    Grafo gDFS4 = new Grafo(V);
                    
                    gDFS4.addEdge(0, 1);
                    gDFS4.addEdge(0, 4);
                    gDFS4.addEdge(1, 2);
                    gDFS4.addEdge(1, 3);
                    gDFS4.addEdge(1, 4);
                    gDFS4.addEdge(4, 3);
                    gDFS4.addEdge(3, 2);
                    
                    System.out.println("Imprimiendo la lista de adyacencia del grafo...");
                    gDFS4.printGraph(gDFS4);
                    System.out.print("Recorrido desde el vertice 0: ");
                    gDFS4.DFS(0);
                    System.out.println("\n");
                    System.out.print("Recorrido desde el vertice 3: ");
                    gDFS4.DFS(3);
                    System.out.println("\n");
                    System.out.print("Recorrido desde el vertice 4: ");
                    gDFS4.DFS(4);
                    System.out.println("\n\n");
                    

                    break;

                }

                case 2: {

                    System.out.println("\n¡Adios!\n");

                    break;

                }

                default: {

                    System.out.println("\nPor favor ingrese una opcion correcta.\n");
                    break;
                }

            }

        }

    }

}
