
package practica4_tellezjorge;

import java.util.List;
import java.util.Objects;

/**
 * Practica 4: Implementacion de busqueda binaria.
 *
 * @autor: Tellez Gonzalez Jorge Luis
 *
 *
 */
public class BusquedaBinaria {

    public static boolean busquedaValor(List<Integer> lista, int clave, int inicio, int fin) {
        if (inicio > fin) {
            return false;
        }

        int mitad = (int)(Math.floor((inicio + fin) / 2));
        

        if (lista.get(mitad) == clave) {
            System.out.println("índice de la clave: " + mitad);
            return true;
            
        } else {

            if (lista.get(mitad) < clave) {
                return busquedaValor(lista, clave, mitad + 1, fin);
            } else {
                return busquedaValor(lista, clave, inicio, mitad - 1);

            }
        }
    }

    public static int busquedaIncidencia(List<Integer> lista, int clave, int inicio, int fin) {
        int contador = 1;

        while (inicio <= fin) {

            int mitad = (int)(Math.floor((inicio + fin) / 2));
            if (lista.get(mitad) == clave) {
                int auxiliar = mitad;

                while (Objects.equals(lista.get(auxiliar), lista.get(auxiliar+1))) {
                    auxiliar++;
                    contador++;
                    System.out.println("Se ha contabilizado un valor.");
                }
                auxiliar=mitad;

                while (Objects.equals(lista.get(auxiliar), lista.get(auxiliar-1))) {
                    auxiliar--;
                    contador++;
                    System.out.println("Se ha contabilizado otro valor");
                }
                
                return contador;
            } else {

                if (lista.get(mitad) < clave) {

                    inicio = mitad + 1;
                } else {

                    fin = mitad - 1;
                }

            }

        }
        return 0;
    }

    /*
 * Métodos específicos para objetos del tipo de dato abstracto Perro.
     */
    public static int busquedaBinariaNombre(List<Perro> lista, String clave, int inicio, int fin) {
        while (inicio <= fin) {

            int mitad = (int) (Math.floor(inicio + fin) / 2);

            if ((int) lista.get(mitad).getNombre().charAt(0) == (int) clave.charAt(0)) {
                int auxiliar = mitad;

                if (clave.equals(lista.get(mitad).getNombre())) {
                    int contadorClave = 0;
                    for (int j = 0; j < lista.size(); j++) {
                        if (clave == lista.get(j).getNombre()) {
                            contadorClave++;
                        }
                    }
                    System.out.println("Frecuencia de aparación: " + contadorClave);

                    return mitad;
                }
                auxiliar++;
                while (clave != lista.get(auxiliar).getNombre() && (int) lista.get(auxiliar).getNombre().charAt(0) == (int) clave.charAt(0)) {
                    auxiliar++;

                }
                if (clave.equals(lista.get(auxiliar).getNombre())) {
                    int contadorClave = 0;
                    for (int j = 0; j < lista.size(); j++) {
                        if (clave == lista.get(j).getNombre()) {
                            contadorClave++;
                        }
                    }
                    System.out.println("Frecuencia de aparación: " + contadorClave);
                    return auxiliar;
                }

                auxiliar = mitad;
                while (clave != lista.get(auxiliar).getNombre() && (int) lista.get(auxiliar).getNombre().charAt(0) == (int) clave.charAt(0)) {
                    auxiliar--;

                }
                if (clave.equals(lista.get(auxiliar).getNombre())) {
                    int contadorClave = 0;
                    for (int j = 0; j < lista.size(); j++) {
                        if (clave == lista.get(j).getNombre()) {
                            contadorClave++;
                        }
                    }
                    System.out.println("Frecuencia de aparación: " + contadorClave);
                    return auxiliar;
                }

            } else {

                if ((int) lista.get(mitad).getNombre().charAt(0) < (int) clave.charAt(0)) {
                    inicio = mitad + 1;
                } else {
                    fin = mitad - 1;
                }

            }

        }
        return -1;
    }

    public static int busquedaBinariaRaza(List<Perro> lista, String clave, int inicio, int fin) {
        while (inicio <= fin) {

            int mitad = (int) Math.floor(inicio + fin / 2);
            if ((int) lista.get(mitad).getRaza().charAt(0) == (int) clave.charAt(0)) {
                int auxiliar = mitad;

                if (clave.equals(lista.get(mitad).getRaza())) {
                    int contadorClave = 0;
                    for (int j = 0; j < lista.size(); j++) {
                        if (clave == lista.get(j).getRaza()) {
                            contadorClave++;
                        }
                    }
                    System.out.println("Frecuencia de aparación: " + contadorClave);
                    return mitad;
                }
                auxiliar++;
                while (clave != lista.get(auxiliar).getRaza() && (int) lista.get(auxiliar).getRaza().charAt(0) == (int) clave.charAt(0)) {
                    auxiliar++;

                }
                if (clave.equals(lista.get(auxiliar).getRaza())) {
                    int contadorClave = 0;
                    for (int j = 0; j < lista.size(); j++) {
                        if (clave == lista.get(j).getRaza()) {
                            contadorClave++;
                        }
                    }
                    System.out.println("Frecuencia de aparación: " + contadorClave);
                    return auxiliar;
                }

                auxiliar = mitad;
                while (clave != lista.get(auxiliar).getRaza() && (int) lista.get(auxiliar).getRaza().charAt(0) == (int) clave.charAt(0)) {
                    auxiliar--;

                }
                if (clave.equals(lista.get(auxiliar).getRaza())) {
                    int contadorClave = 0;
                    for (int j = 0; j < lista.size(); j++) {
                        if (clave == lista.get(j).getRaza()) {
                            contadorClave++;
                        }
                    }
                    System.out.println("Frecuencia de aparación: " + contadorClave);
                    return auxiliar;
                }

            } else {

                if ((int) lista.get(mitad).getRaza().charAt(0) < (int) clave.charAt(0)) {
                    inicio = mitad + 1;
                } else {
                    fin = mitad - 1;
                }

            }

        }
        return -1;
    }

}
