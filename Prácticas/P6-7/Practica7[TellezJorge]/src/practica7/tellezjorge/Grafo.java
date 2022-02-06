/*
 * Practica #7: Algoritmos de grafos Parte 2
 * Clase Grafo
 * 
 */
package practica7.tellezjorge;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @autor Tellez Gonzalez Jorge Luis
 */
class Grafo {

    int V;
    LinkedList<Integer> adjArray[];

    public Grafo(int v) {
        V = v;
        adjArray = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjArray[i] = new LinkedList();
        }

    }

    void addEdge(int v, int w) {
        adjArray[v].add(w);
        adjArray[w].add(v);


    }

    void printGraph(Grafo graph) {
        for (int v = 0; v < graph.V; v++) {
            System.out.println("Lista de Adyacencia del vertice " + v);
            System.out.println(v);
            for (Integer node : graph.adjArray[v]) {
                System.out.print(" -> " + node);
            }
            System.out.println("\n");
        }
    }

    void BFS(int s) {
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);
        System.out.println(queue);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");
            Iterator<Integer> i = adjArray[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
    
    void DFSUtil(int v, boolean visited[]){
    
        visited[v] = true;
        System.out.print(v+ " ");
        
        Iterator<Integer> i = adjArray[v].listIterator();
        
        while (i.hasNext()) {
            
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
                
            }
            
        }
    
    }
    
    void DFS(int v){
    
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    
    }
    

    public void matrizGrafo(int Vertices) {

        Scanner lectura = new Scanner(System.in);
        Integer matrizAdyacencia[][] = new Integer[Vertices][Vertices];

        for (int i = 0; i < Vertices; i++) {

            for (int j = 0; j < Vertices; j++) {
                matrizAdyacencia[i][j] = 0;

            }

        }
        System.out.println("Matriz de adyacencia generada.\n");

        System.out.println("Desea agregar una arista?\nPresione (1) para confirmar o ingrese cualquier otro valor para salir. \n");
        System.out.print("Opcion: ");
        int opcionMatriz = lectura.nextInt();

        if (opcionMatriz == 1) {

            int repetirOp = 1;

            while (repetirOp != 0) {

                System.out.println("A continuación ingrese el nodo head y el nodo destino de la arista. ");

                System.out.print("Nodo head: ");
                int head = lectura.nextInt();

                System.out.print("Nodo destino: ");
                int nodoDestino = lectura.nextInt();

                if (head <= Vertices && nodoDestino <= Vertices) {

                    matrizAdyacencia[head][nodoDestino]++;

                    System.out.println("Matriz de adyacencia actual: \n");

                    for (int i = 0; i < Vertices; i++) {

                        for (int j = 0; j < Vertices; j++) {
                            System.out.print(matrizAdyacencia[i][j] + " ");
                        }
                        System.out.println();
                    }

                    System.out.println("");

                    for (int i = 0; i < Vertices; i++) {
                        System.out.print("El vértice " + i + " se encuentra conectado a: ");
                        for (int j = 0; j < Vertices; j++) {
                            if (matrizAdyacencia[i][j] == 1) {
                                System.out.print(j + " -> ");
                            }
                        }
                        System.out.println();
                    }

                } else {

                    System.out.println("Error: Ingrese un vértice existente en el grafo actual.");
                }

                System.out.println("\n\n¿Desea ingresar otra arista? Ingrese cualquier valor para continuar o "
                        + "introduzca (0) para salir.\n");

                System.out.print("Opcion: ");
                repetirOp = lectura.nextInt();

                if (repetirOp == 0) {

                    System.out.println("Saliendo de la opción seleccionada...\n");

                }

            }

        } else {

            System.out.println("Saliendo de la opción seleccionada...\n");

        }

    }

    public void matrizGrafoND(int Vertices) {

        Scanner lectura = new Scanner(System.in);
        Integer matrizAdyacencia[][] = new Integer[Vertices][Vertices];

        for (int i = 0; i < Vertices; i++) {

            for (int j = 0; j < Vertices; j++) {
                matrizAdyacencia[i][j] = 0;

            }

        }
        System.out.println("Matriz de adyacencia generada.\n");

        System.out.println("Desea agregar una arista?\nPresione (1) para confirmar o ingrese cualquier otro valor para salir. \n");
        System.out.print("Opcion: ");
        int opcionMatriz = lectura.nextInt();

        if (opcionMatriz == 1) {

            int repetirOp = 1;

            while (repetirOp != 0) {

                System.out.println("A continuación ingrese el nodo head y el nodo destino de la arista. ");

                System.out.print("Nodo head: ");
                int head = lectura.nextInt();

                System.out.print("Nodo destino: ");
                int nodoDestino = lectura.nextInt();

                if (head <= Vertices && nodoDestino <= Vertices) {

                    matrizAdyacencia[head][nodoDestino]++;

                    if (head != nodoDestino) {
                        matrizAdyacencia[nodoDestino][head]++;
                    }

                    System.out.println("Matriz de adyacencia actual: \n");

                    for (int i = 0; i < Vertices; i++) {

                        for (int j = 0; j < Vertices; j++) {
                            System.out.print(matrizAdyacencia[i][j] + " ");
                        }
                        System.out.println();
                    }

                    System.out.println("");

                    for (int i = 0; i < Vertices; i++) {
                        System.out.print("El vértice " + i + " se encuentra conectado a: ");
                        for (int j = 0; j < Vertices; j++) {
                            if (matrizAdyacencia[i][j] == 1) {
                                System.out.print(j + " -> ");
                            }
                        }
                        System.out.println();
                    }

                } else {

                    System.out.println("Error: Ingrese un vértice existente en el grafo actual.");
                }

                System.out.println("\n\n¿Desea ingresar otra arista? Ingrese cualquier valor para continuar o "
                        + "introduzca (0) para salir.\n");

                System.out.print("Opcion: ");
                repetirOp = lectura.nextInt();

                if (repetirOp == 0) {

                    System.out.println("Saliendo de la opción seleccionada...\n");

                }

            }

        } else {

            System.out.println("Saliendo de la opción seleccionada...\n");

        }

    }

}
