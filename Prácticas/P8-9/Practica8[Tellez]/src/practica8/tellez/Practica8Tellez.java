/*
 * Estructura de Datos y Algoritmos II - Practica 8-9: Arboles
 * 
 * Clase Principal
 */
package practica8.tellez;

import java.util.Scanner;

/**
 *
 * @autor Tellez Gonzalez Jorge Luis
 */
public class Practica8Tellez {

    public static void main(String[] args) {

        int opcionMenu = 0;

        System.out.println("Practica #8: Arboles \n");
        while (opcionMenu != 5) {

            System.out.println("\n¿Sobre que tipo de arbol desea trabajar? \n1)Arboles binarios."
                    + "\n2)Arboles binarios de busqueda. \n3)Ejemplo de la implementacion de arboles binarios.\n4)Arboles B\n5)Salir del programa.");

            System.out.print("\nOpcion: ");
            Scanner lectura = new Scanner(System.in);
            opcionMenu = lectura.nextInt();
            System.out.println("");

            switch (opcionMenu) {

                case 1: {

                    ArbolBin arbol = new ArbolBin();

                    System.out.println("\nSe ha creado un arbol binario exitosamente.");

                    int opcionBin = 0;

                    while (opcionBin != 6) {

                        System.out.println("\n\n¿Que operacion desea realizar?\n1)Agregar. "
                                + "\n2)Recorrido BFS.\n3)Notacion Prefija.\n4)Notacion Infija.\n5)Notacion Posfija.\n6)Salir de la opcion");

                        System.out.print("\nOpcion: ");
                        opcionBin = lectura.nextInt();
                        System.out.println("");

                        switch (opcionBin) {

                            case 1: {

                                if (arbol.getRoot() == null) {
                                    System.out.print("\nEl arbol no contiene una raiz. A continuacion, introduce un valor para su raiz: ");
                                    arbol.setRoot(new Nodo(lectura.nextInt()));

                                }

                                arbol.agregarDato(arbol);

                                break;

                            }

                            case 2: {

                                System.out.println("\nLa impresión del arbol actual por BFS es la siguiente: ");
                                arbol.breadthFirst();

                                System.out.println("\nImpresión gráfica del árbol actual:\n");

                                arbol.print(System.out);

                                break;

                            }

                            case 3: {

                                System.out.println("\nLa impresion del arbol en Preorden es la siguiente:\n");
                                arbol.printPreOrden();

                                break;

                            }

                            case 4: {

                                System.out.println("\nLa impresion del arbol en Inorden es la siguiente:\n");
                                arbol.printInOrden();

                                break;

                            }

                            case 5: {

                                System.out.println("\nLa impresion del arbol en Postorden es la siguiente:\n");
                                arbol.printPostOrden();

                                break;

                            }

                            case 6: {

                                System.out.println("\nSaliendo de la opcion...\n");

                                break;

                            }

                            default: {

                                System.out.println("\nPor favor ingrese una opcion correcta.\n");
                                break;

                            }

                        }

                    }

                    break;

                }

                case 2: {

                    ArbolBinBus arbolBin = new ArbolBinBus();

                    System.out.println("\nSe ha creado un arbol binario de busqueda exitosamente.");

                    int opcionBinBus = 0;

                    while (opcionBinBus != 5) {

                        System.out.println("\n¿Qué operacion desea realizar?\n1)Agregar."
                                + "\n2)Eliminar. \n3)Buscar.\n4)Imprimir arbol (BFS).\n5)Salir de la opcion");

                        System.out.print("\nOpcion: ");
                        opcionBinBus = lectura.nextInt();
                        System.out.println("");

                        switch (opcionBinBus) {

                            case 1: {

                                if (arbolBin.getRoot() == null) {
                                    System.out.print("\nEl arbol no contiene una raiz. A continuacion, introduce un valor para su raiz: ");
                                    arbolBin.setRoot(new Nodo(lectura.nextInt()));

                                }
                                arbolBin.agregarDato(arbolBin);

                                break;

                            }

                            case 2: {

                                arbolBin.eliminarDato(arbolBin);

                                break;

                            }

                            case 3: {

                                System.out.print("\n¿Que elemento desea buscar en el arbol?: ");
                                int valorABuscar = lectura.nextInt();
                                arbolBin.breadthFirstSearch(valorABuscar);

                                break;

                            }

                            case 4: {

                                System.out.println("\nLa impresión del arbol actual por BFS es la siguiente: ");
                                arbolBin.breadthFirst();

                                System.out.println("\nImpresión gráfica del árbol actual:\n");

                                arbolBin.print(System.out);

                                System.out.print("\nEl recorrido en PreOrden es: ");
                                arbolBin.printPreOrden();
                                System.out.print("\nEl recorrido en InOrden es: ");
                                arbolBin.printInOrden();
                                System.out.print("\nEl recorrido en PostOrden es: ");
                                arbolBin.printPostOrden();

                                break;

                            }

                            case 5: {

                                System.out.println("\nSaliendo de la opcion...\n");

                                break;

                            }

                            default: {

                                System.out.println("\nPor favor ingrese una opcion correcta.\n");
                                break;

                            }

                        }

                    }

                    break;

                }

                case 3: {

                    System.out.println("Ejemplo inicial.");

                    ArbolBin arbol;
                    Nodo n7 = new Nodo(7);
                    Nodo n9 = new Nodo(9);
                    Nodo n1 = new Nodo(1, n7, n9);
                    Nodo n15 = new Nodo(15);
                    Nodo n8 = new Nodo(8);
                    Nodo n4 = new Nodo(4);
                    Nodo n2 = new Nodo(2);
                    Nodo n16 = new Nodo(16);
                    Nodo n3 = new Nodo(3);

                    arbol = new ArbolBin(n1);
                    arbol.add(n7, n15, 0);
                    arbol.add(n7, n8, 1);
                    arbol.add(n9, n4, 0);
                    arbol.add(n9, n2, 1);
                    arbol.add(n15, n16, 1);
                    arbol.add(n8, n3, 0);
                    arbol.breadthFirst();

                    System.out.println("\nSe imprime el arbol de forma grafica a continuacion: \n");

                    arbol.print(System.out);

                    System.out.println("\n¿Se encuentre el nodo 15 en el arbol anterior?\n");
                    arbol.breadthFirstSearch(15);

                    System.out.println("\n¿Y el nodo 19?\n");
                    arbol.breadthFirstSearch(19);

                    System.out.println("\nRecorrido en PreOrden del arbol: ");
                    arbol.printPreOrden();
                    System.out.println("\nRecorrido en InOrden del arbol: ");
                    arbol.printInOrden();
                    System.out.println("\nRecorrido en PostOrden del arbol: ");
                    arbol.printPostOrden();

                    break;

                }

                case 4: {

                    System.out.print("\nA continuacion introduzca el orden del arbol B a construir: ");
                    int ordenB = lectura.nextInt();

                    BTree arbolB = new BTree(ordenB);
                    System.out.println("\nSe ha creado un arbol B exitosamente.");

                    int opcionB = 0;

                    while (opcionB != 4) {

                        System.out.println("\n\n¿Que operacion desea realizar?\n1)Agregar un valor. "
                                + "\n2)Buscar Valor.\n3)Imprimir arbol.\n4)Salir de la opcion");

                        System.out.print("\nOpcion: ");
                        opcionB = lectura.nextInt();
                        System.out.println("");

                        switch (opcionB) {

                            case 1: {

                                System.out.print("\nIntroduzca el valor a insertar: ");
                                int valorAInsertar = lectura.nextInt();
                                arbolB.add(valorAInsertar);

                                break;

                            }

                            case 2: {

                                System.out.print("\nIntroduzca el valor a buscar: ");
                                int valorABuscar = lectura.nextInt();

                                boolean encontrado = arbolB.find(valorABuscar);

                                if (encontrado == true) {
                                    System.out.println("\nEl elemento introducido SI se encuentra en el arbol B actual.\n");

                                } else {
                                    System.out.println("\nEl elemento introducido NO se encuentra en el arbol B actual.\n");
                                }

                                break;

                            }

                            case 3: {

                                System.out.println("\nEl arbol B actual tiene la siguiente estructura: ");
                                arbolB.mostrarArbol();

                                break;

                            }

                            case 4: {

                                System.out.println("\nSaliendo de la opcion...\n");

                                break;

                            }

                            default: {

                                System.out.println("\nPor favor ingrese una opcion correcta.\n");
                                break;

                            }

                        }

                    }

                    break;

                }

                case 5: {

                    System.out.println("¡Adios!");
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
