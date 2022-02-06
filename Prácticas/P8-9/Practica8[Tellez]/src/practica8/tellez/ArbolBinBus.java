/*
 * Estructura de Datos y Algoritmos II - Practica 8-9: Arboles
 * 
 * Clase ArbolBinBus
 */
package practica8.tellez;

/**
 *
 * @autor Tellez Gonzalez Jorge Luis
 */
public class ArbolBinBus extends ArbolBin {

    public Nodo addR(Nodo padre, int dato) {

        //Caso base: árbol vacío.
        if (padre == null) {
            return new Nodo(dato);
        }

        //Si el valor del nuevo nodo es menor que el nodo actual, se procede a revisar a su hijo izquierdo.
        if (dato < padre.getValor()) {
            padre.setIzq(addR(padre.getIzq(), dato));

            //Si el valor del nuevo nodo es mayor que el nodo actual, se procede a revisar al hijo derecho.
        } else if (dato > padre.getValor()) {
            padre.setDer(addR(padre.getDer(), dato));
        } else {
            //En caso de que el dato ya se encuentre en el arbol.
            return padre;
        }

        return padre;
    }

    public void add(int value) {
        root = addR(root, value);

    }

    public void agregarDato(ArbolBinBus arbolBin) {

        int dato = 1;

        while (dato != 2) {

            System.out.print("\nA continuacion, introduzca un valor para el nodo: ");
            dato = lectura.nextInt();
            arbolBin.add(dato);

            System.out.println("\n¿Deseas agregar más datos? \n1)Si\n2)No\n");
            System.out.print("Opcion: ");
            dato = lectura.nextInt();

        }

    }

    void eliminarDato(ArbolBinBus arbolBinBus) {
        int dato = 1;

        while (dato != 2) {

            System.out.print("\nIntroduce el valor del nodo a eliminar: ");
            dato = lectura.nextInt();
            arbolBinBus.delete(dato);

            System.out.println("\n¿Deseas eliminar mas datos? \n1)Si\n2)No\n");
            System.out.print("Opcion: ");
            dato = lectura.nextInt();

        }
    }

    void delete(int valorAEliminar) {
        root = deleteR(root, valorAEliminar);
    }

    Nodo deleteR(Nodo padre, int valorAEliminar) {
        //Caso base: árbol vacío.
        if (padre == null) {
            return padre;
        }

        /* Caso contrario, se realiza un recorrido recursivo sobre el árbol. */
        if (valorAEliminar < padre.getValor()) {
            padre.setIzq(deleteR(padre.getIzq(), valorAEliminar));

        } else if (valorAEliminar > padre.getValor()) {
            padre.setDer(deleteR(padre.getDer(), valorAEliminar));
        } // Si el valor es el mismo al valor del nodo, entonces se ha hallado
        // el nodo a eliminar.
        else {
            // Nodo con un único hijo o sin hijo.
            
            if (padre.getIzq()==null && padre.getDer()==null) {
                return null; 
            }   
            
            if (padre.getIzq() == null) {
                return padre.getDer();
                
            } else if (padre.getDer() == null) {
                return padre.getIzq();
            }

            // Nodo con 2 hijos: se obtiene al sucesor recorriendo
            // a la derecha a partir del subárbol izquierdo.
            padre.setValor(maxValor(padre.getIzq()));

            // Se reordena el árbol. 
            padre.setIzq(deleteR(padre.getIzq(), padre.getValor()));
        }

        return padre;
    }

    int maxValor(Nodo root) {
        int maxv = root.getValor();
        while (root.getDer() != null) {
            maxv = root.getDer().getValor();
            root = root.getDer();
        }
        System.out.println("Valor maximo del subarbol izq: " +maxv);
        return maxv;
    }
}
