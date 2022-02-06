/*
 * Practica #6: Algoritmos de grafos Parte 1
 * Clase Grafo Ponderado
 * 
 */
package practica6.tellezjorge;

import java.util.Scanner;

/**
 *
 * @autor Tellez Gonzalez Jorge Luis
 */
public class GrafoPonderado extends Grafo{
    
    public GrafoPonderado(int v) {
        super(v);
    }
    
    void addEdge(int v, int w, int peso) {
        adjArray[v].add(w);
        adjArray[v].add(peso);
    }
    
    void printGraph(GrafoPonderado graph){
        for(int v = 0; v < graph.V; v++){
            System.out.println("Lista de Adyacencia del vertice "+ v); 
            System.out.println(v);
            for(int i=0; i<graph.adjArray[v].size(); i=i+2){
                System.out.print("\n -> "+graph.adjArray[v].get(i)+
                        " Costo de la arista: "+graph.adjArray[v].get(i+1)); 
            }
            System.out.println("\nnb  ");
        }
    }
    
    @Override
    public void matrizGrafo(int Vertices) {

        Scanner lectura = new Scanner(System.in);
        Integer matrizAdyacencia[][] = new Integer[Vertices][Vertices];
        Integer matrizAdyacenciaLista[][] = new Integer[Vertices][Vertices];

        for (int i = 0; i < Vertices; i++) {

            for (int j = 0; j < Vertices; j++) {
                matrizAdyacencia[i][j] = 0;

            }

        }
        
         for (int i = 0; i < Vertices; i++) {

            for (int j = 0; j < Vertices; j++) {
                matrizAdyacenciaLista[i][j] = 0;

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
                
                System.out.print("Ingrese el costo de la arista: ");
                int costoArista = lectura.nextInt();

                if (head <= Vertices && nodoDestino <= Vertices) {

                    matrizAdyacenciaLista[head][nodoDestino]++;
                    matrizAdyacencia[head][nodoDestino]=costoArista;

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
                            if (matrizAdyacenciaLista[i][j] == 1) {
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
