/*
 * Practica #6: Algoritmos de grafos Parte 1
 * Clase principal del programa.
 * 
 */
package practica6.tellezjorge;

import java.util.Scanner;

/**
 *
 * @autor Tellez Gonzalez Jorge Luis
 */
public class Practica6TellezJorge {

    public static void main(String[] args) {

        int V, opcionMenu = 0;

        System.out.println("Practica #6: Algoritmos de grafos. \n");
        while (opcionMenu != 5) {

            System.out.println("\n¿Qué operación desea realizar? \n1)Crear un grafo dirigido."
                    + "\n2)Crear un grafo ponderado. \n3)Crear un grafo con matrices de adyacencia. "
                    + "\n4)Breadth First Search \n5)Salir del programa.\n");

            System.out.print("Opcion: ");
            Scanner lectura = new Scanner(System.in);
            opcionMenu = lectura.nextInt();
            System.out.println("");

            switch (opcionMenu) {

                case 1: {

                    int opcionArista = 1;
                    System.out.print("Ingrese el número de vértices del grafo: ");
                    V = lectura.nextInt();
                    Grafo grafoDirigido = new Grafo(V);
                    while (opcionArista != 0) {

                        System.out.println("A continuación ingrese el nodo head y el nodo destino de la arista. ");

                        System.out.print("Nodo head: ");
                        int head = lectura.nextInt();

                        System.out.print("Nodo destino: ");
                        int nodoDestino = lectura.nextInt();

                        if (head <= V && nodoDestino <= V) {
                            grafoDirigido.addEdge(head, nodoDestino);

                            System.out.println("\nOperación realizada con éxito.\n");
                            grafoDirigido.printGraph(grafoDirigido);

                            System.out.println("¿Desea ingresar otra arista?\nIngrese cualquier valor para continuar o "
                                    + "introduzca (0) para salir.");

                            System.out.print("Opcion: ");
                            opcionArista = lectura.nextInt();

                        } else {

                            System.out.println("\nError: Ingrese un vértice existente en el grafo actual.\n");
                        }

                    }

                    break;

                }

                case 2: {

                    int opcionArista = 1;
                    System.out.print("Ingrese el número de vértices del grafo: ");
                    V = lectura.nextInt();
                    GrafoPonderado grafoP = new GrafoPonderado(V);
                    while (opcionArista != 0) {

                        System.out.println("A continuación ingrese el nodo head y el nodo destino de la arista. ");

                        System.out.print("Nodo head: ");
                        int head = lectura.nextInt();

                        System.out.print("Nodo destino: ");
                        int nodoDestino = lectura.nextInt();

                        System.out.print("Ingrese el costo de la arista: ");
                        int costoArista = lectura.nextInt();

                        if (head <= V && nodoDestino <= V) {
                            grafoP.addEdge(head, nodoDestino, costoArista);

                            System.out.println("\nOperación realizada con éxito.\n");
                            grafoP.printGraph(grafoP);

                            System.out.println("¿Desea ingresar otra arista?\nIngrese cualquier valor para continuar o "
                                    + "introduzca (0) para salir.");

                            System.out.print("Opcion: ");
                            opcionArista = lectura.nextInt();

                        }

                    }

                    break;

                }

                case 3: {

                    System.out.print("Ingrese el número de vértices del grafo: ");
                    V = lectura.nextInt();
                    Grafo opcionMatriz = new Grafo(V);
                    
                    System.out.println("\n¿Qué tipo de grafo desea representar matricialmente?\n1)No Dirigido\n2)Dirigido\n3)Ponderado.");
                    System.out.print("\nOpcion: ");
                    int tipoGrafo = lectura.nextInt();
                    
                    switch(tipoGrafo){ 
                        
                        case 1:{
                            
                            opcionMatriz.matrizGrafoND(V);
                        
                        break;
                        }
                        
                        case 2:{
                            
                             opcionMatriz.matrizGrafo(V);
                        
                        break;
                        }
                        
                        case 3:{
                            
                            GrafoPonderado opcionMP = new GrafoPonderado(V);
                            opcionMP.matrizGrafo(V);
                         
                        
                        break;
                        }
                        
                        default:{
                            
                            System.out.println("\nPor favor ingrese una opción correcta.\n");
                        
                        break;
                        }    
                    
                    }

                    break;

                }

                case 4: {
                    V = 6;

                    System.out.println("Creando un nuevo grafo...");
                    Grafo gBFS = new Grafo(V);

                    gBFS.addEdge(0, 1);
                    gBFS.addEdge(0, 2);
                    gBFS.addEdge(1, 3);
                    gBFS.addEdge(3, 4);
                    gBFS.addEdge(3, 5);


                    System.out.println("\nBFS: Grafo 1 - Vertice 0.\n");
                    gBFS.BFS(0);

                    System.out.println("\nBFS: Grafo 1 - Vertice 1.\n");
                    gBFS.BFS(1);

                    int V2 = 7;
                    System.out.println("\nCreando otro grafo...\n");
                    Grafo gBFS2 = new Grafo(V2);

                    gBFS2.addEdge(0, 1);
                    gBFS2.addEdge(0, 2);
                    gBFS2.addEdge(1, 3);
                    gBFS2.addEdge(1, 4);
                    gBFS2.addEdge(2, 5);
                    gBFS2.addEdge(2, 6);

                    System.out.println("\nBFS: Grafo 2 - Vertice 0.\n");
                    gBFS2.BFS(0);

                    System.out.println("\nBFS: Grafo 2 - Vertice 1.\n");
                    gBFS2.BFS(1);

                    System.out.println("\nBFS: Grafo 2 - Vertice 2.\n");
                    gBFS2.BFS(2);
                    break;

                }

                case 5: {

                    System.out.println("\n¡Adios!\n");

                    break;

                }

                default: {

                    System.out.println("\nPor favor ingrese una opción correcta.\n");
                    break;
                }

            }

        }

    }

}
