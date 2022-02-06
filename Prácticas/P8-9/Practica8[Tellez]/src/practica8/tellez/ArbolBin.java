/*
 * Estructura de Datos y Algoritmos II - Practica 8-9: Arboles
 * 
 * Clase ArbolBin
 */
package practica8.tellez;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @autor Tellez Gonzalez Jorge Luis
 */
public class ArbolBin {

    Nodo root;
    Scanner lectura = new Scanner(System.in);

    public ArbolBin() {
        root = null;

    }

    public ArbolBin(int val) {
        root = new Nodo(val);

    }

    public ArbolBin(Nodo root) {
        this.root = root;

    }

    /**
     * @return the root
     */
    public Nodo getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(Nodo root) {
        this.root = root;
    }

    public void add(Nodo padre, Nodo hijo, int lado) {

        if (lado == 0) {
            padre.setIzq(hijo);

        } else {
            padre.setDer(hijo);
        }

    }

    /**
     *
     * @param padre
     * @param dato
     * @return
     */
    public int add(Nodo padre, int dato) {

        if (padre.getIzq() == null) {

            padre.setIzq(new Nodo(dato));
            System.out.println("El nodo padre no tiene valor izquierdo. Dato añadido exitosamente a la izquierda de: " + padre.getValor());
            return 0;

        } else if (padre.getDer() == null) {
            padre.setDer(new Nodo(dato));
            System.out.println("El nodo padre no tiene valor derecho. Dato añadido exitosamente a la derecha de: " + padre.getValor());
            return 0;

        } else {

            if ((padre.getIzq()).getValor() < (padre.getDer()).getValor()) {
                add(padre.getIzq(), dato);
                return 0;
            } else {
                add(padre.getDer(), dato);
                return 0;

            }

        }

    }

    /**
     *
     * @param arbolBin
     */
    public void agregarDato(ArbolBin arbolBin) {

        int dato = 1;

        while (dato != 2) {

            System.out.print("\nA continuacion, introduzca un valor para el nodo: ");
            dato = lectura.nextInt();
            arbolBin.add(arbolBin.getRoot(), dato);

            System.out.println("\n¿Deseas agregar más datos? \n1)Si\n2)No\n");
            System.out.print("Opcion: ");
            dato = lectura.nextInt();

        }

    }
    


    protected void visit(Nodo n) {

        System.out.println(n.getValor() + " ");

    }

    public void breadthFirst() {

        Nodo r = getRoot();
        Queue<Nodo> queue = new LinkedList();

        if (r != null) {
            queue.add(r);

            while (!queue.isEmpty()) {

                r = (Nodo) queue.poll();
                visit(r);

                if (r.getIzq() != null) {
                    queue.add(r.getIzq());

                }

                if (r.getDer() != null) {
                    queue.add(r.getDer());

                }

            }

        }

    }

    public boolean breadthFirstSearch(int valorABuscar) {

        Nodo r = this.getRoot();
        Queue<Nodo> queue = new LinkedList();

        if (r != null) {

            if (r.getValor() == valorABuscar) {
                System.out.println("El nodo " + valorABuscar + " SI se ha encontrado en el arbol.\n");
                return true;
            }
            queue.add(r);

            while (!queue.isEmpty()) {

                r = (Nodo) queue.poll();

                if (r.getValor() == valorABuscar) {
                    System.out.println("El nodo " + valorABuscar + " SI se ha encontrado en el arbol.\n");
                    return true;
                }

                if (r.getIzq() != null) {
                    queue.add(r.getIzq());

                }

                if (r.getDer() != null) {
                    queue.add(r.getDer());

                }

            }
            System.out.println("El nodo " + valorABuscar + " NO se ha encontrado en el arbol.\n");

        }
        return false;

    }

    public void preOrden(Nodo padre) {

        if (padre != null) {
            System.out.print(padre.getValor() + " ");

            if (padre.getIzq() != null) {
                preOrden(padre.getIzq());

            }

            if (padre.getDer() != null) {
                preOrden(padre.getDer());

            }

        }

    }

    public void printPreOrden() {

        if (this.root != null) {
            preOrden(this.root);

        }
        System.out.println("");

    }

    public void inOrden(Nodo padre) {

        if (padre != null) {

            if (padre.getIzq() != null) {
                inOrden(padre.getIzq());

            }

            System.out.print(padre.getValor() + " ");
            if (padre.getDer() != null) {
                inOrden(padre.getDer());

            }

        }

    }

    public void printInOrden() {

        if (this.root != null) {
            inOrden(this.root);

        }
        System.out.println("");

    }

    public void postOrden(Nodo padre) {

        if (padre != null) {

            if (padre.getIzq() != null) {
                postOrden(padre.getIzq());

            }

            if (padre.getDer() != null) {
                postOrden(padre.getDer());

            }
            System.out.print(padre.getValor() + " ");

        }

    }

    public void printPostOrden() {

        if (this.root != null) {
            postOrden(this.root);

        }
        System.out.println("");

    }

    public String traversePreOrder(Nodo root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.getValor());

        String pointerRight = "└──";
        String pointerLeft = (root.getDer() != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, root.getIzq(), root.getDer() != null);
        traverseNodes(sb, "", pointerRight, root.getDer(), false);

        return sb.toString();
    }

    public void traverseNodes(StringBuilder sb, String padding, String pointer, Nodo node,
            boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getValor());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.getDer() != null) ? "├──" : "└──";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.getIzq(), node.getDer() != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.getDer(), false);
        }
    }

    public void print(PrintStream os) {
        os.print(traversePreOrder(this.getRoot()));
    }

}
