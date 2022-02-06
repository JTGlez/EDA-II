package practica4_tellezjorge;

import java.util.List;

/**
 * Practica 4: Implementacion de busqueda lineal.
 *
 * @autor: Tellez Gonzalez Jorge Luis
 *
 *
 */
public class BusquedaLineal {

    public static boolean busquedaCentinela(List<Integer> lista, int clave) {
        int centinela = lista.set(lista.size() - 1, clave); //Elemento en posicion previa.
        int contador = 0;
        while (lista.get(contador) != clave) {
            contador++;
        }
        lista.set(lista.size() - 1, centinela); //Coloca el elemento reemplazado de nuevo.
        if (contador < lista.size() - 1 || lista.get(lista.size() - 1) == clave) {
            return true;

        } else {
            return false;
        }

    }

    public static int busquedaIndice(List<Integer> lista, int clave) {
        for (int i = 0; i < lista.size(); i++) {
            if (clave == lista.get(i)) {
                return i;
            }
        }
        return -1;
    }

    public static int busquedaIncidencia(List<Integer> lista, int clave) {
        int contadorClave = 0;
        for (Integer i : lista) {
            if (clave == i) {
                contadorClave++;
            }
        }
        return contadorClave;
    }

    /*
 * Métodos específicos para objetos del tipo de dato abstracto Perro.
     */
    public static int busquedaLinealNombre(List<Perro> lista, String clave) {

        for (int i = 0; i < lista.size(); i++) {

            if (clave == lista.get(i).getNombre()) {
                int contadorClave = 0;
                for (int j = 0; j < lista.size(); j++) {
                    if (clave == lista.get(j).getNombre()) {
                        contadorClave++;
                    }
                }
                System.out.println("Frecuencia de aparación: " + contadorClave);
                return i;

            }

        }
        return -1;

    }

    public static int busquedaLinealRaza(List<Perro> lista, String clave) {

        for (int i = 0; i < lista.size(); i++) {

            if (clave == lista.get(i).getRaza()) {
                int contadorClave = 0;
                for (int j = 0; j < lista.size(); j++) {
                    if (clave == lista.get(j).getRaza()) {
                        contadorClave++;
                    }
                }
                System.out.println("Frecuencia de aparación: " + contadorClave);
                return i;

            }

        }
        return -1;

    }
}
