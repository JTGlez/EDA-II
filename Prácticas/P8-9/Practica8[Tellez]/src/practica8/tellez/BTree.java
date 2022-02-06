/*
 * Estructura de Datos y Algoritmos II - Practica 8-9: Arboles
 * 
 * Clase BTree
 */
package practica8.tellez;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BTree {

    int ordenArbolB;
    BNode root;

    public BTree(int m) {
        this.ordenArbolB = m;
        root = new BNode();
        root.setM(m);
    }

    public void add(int n) {
        if (find(n)) {
            System.out.println("La clave ya existe en el Ã¡rbol.");
        } else {
            BNode hoja = leafNode(root, n);
            addToNode(hoja, n);
        }

    }

    private BNode leafNode(BNode nodo, int n) {
        if (nodo.leaf) {
            return nodo;
        } else {
            int i = 0;
            for (; i < nodo.key.size(); i++) {
                if (n < nodo.getKey(i)) {
                    i++;
                    break;
                }
            }

            if (n < nodo.getKey(i - 1)) {
                i--;
            }

            return leafNode(nodo.getChild(i), n);

        }
    }

    private void addToNode(BNode nodo, int n) {
        if (nodo.key.size() < ordenArbolB - 1) {
            System.out.println("nodo key size" + nodo.key.size());
            insert(nodo, n);
        } else {
            divisionCelular(nodo, n);
        }

    }

    private void insert(BNode nodo, int n) {
        int i = 0;
        while (i < nodo.key.size() && n > nodo.getKey(i)) {
            i++;
        }
        nodo.key.add(i, n);
    }

    private void divisionCelular(BNode nodo, int n) {

        int halfMinIndex = (ordenArbolB - 1) / 2;
        if (ordenArbolB % 2 != 0) {
            insert(nodo, n);
        }
        int medio = nodo.key.get(halfMinIndex);

        ArrayList<Integer> key1 = new ArrayList(nodo.key.subList(0, halfMinIndex));
        ArrayList<Integer> key2 = new ArrayList(nodo.key.subList(halfMinIndex + 1, 2 * halfMinIndex + 1));
        ArrayList<BNode> child1 = new ArrayList();
        ArrayList<BNode> child2 = new ArrayList();

        if (nodo == root) {

            BNode nuevoNodo1 = new BNode();
            BNode nuevoNodo2 = new BNode();
            nuevoNodo1.leaf = nuevoNodo2.leaf = nodo.leaf;

            nuevoNodo1.setKeys(key1);
            nuevoNodo2.setKeys(key2);
            nodo.key.clear();
            nodo.key.add(medio);

            if (ordenArbolB % 2 == 0) {
                if (n < medio) {
                    insert(nuevoNodo1, n);
                } else {
                    insert(nuevoNodo2, n);
                }
            }

            if (!nodo.leaf) {
                if (ordenArbolB % 2 != 0) {
                    child1 = new ArrayList(nodo.child.subList(0, halfMinIndex + 1));
                    child2 = new ArrayList(nodo.child.subList(halfMinIndex + 1, ordenArbolB + 1));
                } else {
                    if (n < medio) {
                        child1 = new ArrayList(nodo.child.subList(0, halfMinIndex + 2));
                        child2 = new ArrayList(nodo.child.subList(halfMinIndex + 2, ordenArbolB + 1));
                    }
                    if (n > medio) {
                        child1 = new ArrayList(nodo.child.subList(0, halfMinIndex + 1));
                        child2 = new ArrayList(nodo.child.subList(halfMinIndex + 1, ordenArbolB + 1));
                    }
                }

                nuevoNodo1.setChildren(child1);
                nuevoNodo2.setChildren(child2);
                for (BNode i : nuevoNodo1.child) {
                    i.parent = nuevoNodo1;
                }
                for (BNode i : nuevoNodo2.child) {
                    i.parent = nuevoNodo2;
                }

            }

            nodo.child.clear();
            nodo.child.add(nuevoNodo1);
            nodo.child.add(nuevoNodo2);
            nuevoNodo1.parent = nuevoNodo2.parent = root;
            nodo.leaf = false;

        } else {

            BNode nuevoNodo = new BNode();
            nuevoNodo.leaf = nodo.leaf;
            nuevoNodo.parent = nodo.parent;

            int childIndex = nodo.getChildIndex();

            nodo.setKeys(key1);
            nuevoNodo.setKeys(key2);

            if (ordenArbolB % 2 == 0) {
                if (n < medio) {
                    insert(nodo, n);
                } else {
                    insert(nuevoNodo, n);
                }
            }

            if (!nodo.leaf) {
                if (ordenArbolB % 2 != 0) {
                    child1 = new ArrayList(nodo.child.subList(0, halfMinIndex + 1));
                    child2 = new ArrayList(nodo.child.subList(halfMinIndex + 1, ordenArbolB + 1));
                } else {
                    if (n < medio) {
                        child1 = new ArrayList(nodo.child.subList(0, halfMinIndex + 2));
                        child2 = new ArrayList(nodo.child.subList(halfMinIndex + 2, ordenArbolB + 1));
                    }
                    if (n > medio) {
                        child1 = new ArrayList(nodo.child.subList(0, halfMinIndex + 1));
                        child2 = new ArrayList(nodo.child.subList(halfMinIndex + 1, ordenArbolB + 1));
                    }
                }
                nodo.setChildren(child1);
                nuevoNodo.setChildren(child2);
                for (BNode i : nodo.child) {
                    i.parent = nodo;
                }
                for (BNode i : nuevoNodo.child) {
                    i.parent = nuevoNodo;
                }
            }

            nodo.parent.child.add(childIndex + 1, nuevoNodo);

            addToNode(nodo.parent, medio);

        }

    }

    public void mostrarArbol() {
        if (root.child.isEmpty() == true && root.key.isEmpty() == true) {
            System.out.println("No hay elementos aun");
            return;
        }
        Queue<BNode> nodos = new LinkedList<>();
        nodos.add(root);
        BNode parent = null;
        while (!nodos.isEmpty()) {

            BNode v = nodos.poll();
            if (v.parent == null) {
                System.out.print("Nodo Raiz: ");
            }
            if (parent != v.parent) {
                System.out.print("\n\n\nNodo Padre: ");
                v.parent.mostrarLlaves();
                parent = v.parent;
                System.out.print("\n\t\tNodos:");
            }
            System.out.print("\n\t\t");
            v.mostrarLlaves();

            for (int i = 0; i < v.child.size(); i++) {
                nodos.add(v.child.get(i));
            }
        }
        System.out.println("\n");
    }

    public boolean find(int value) {
        if (root.child.isEmpty() == true && root.key.isEmpty() == true) {
            return false;
        }
        return find(value, root);
    }

    private boolean find(int v, BNode n) {
        if (n == null) {
            return false;
        }

        int i;

        if (n.getKey(0) > v) {
            return find(v, n.getChild(0));
        }

        for (i = 0; i < n.key.size() - 1; i++) {

            if (n.getKey(i) == v) {
                return true;
            }

            if (n.getKey(i) < v && n.getKey(i + 1) > v) {
                return find(v, n.getChild(i + 1));
            }

        }

        if (n.getKey(i) == v) {
            return true;
        } else {
            if (n.getKey(i) < v) {
                return find(v, n.getChild(i + 1));
            } else {
                return find(v, n.getChild(i));
            }
        }

    }

}
