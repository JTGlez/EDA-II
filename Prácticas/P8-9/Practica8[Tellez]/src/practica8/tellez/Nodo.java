/*
 * Estructura de Datos y Algoritmos II - Practica 8-9: Arboles
 * 
 * Clase Nodo
 */
package practica8.tellez;

/**
 *
 * @autor Tellez Gonzalez Jorge Luis
 */
class Nodo {

    private int valor;
    private Nodo izq = null;
    private Nodo der = null;

    public Nodo() {
        izq = der = null;
    }

    public Nodo(int data) {
        this(data, null, null);
    }

    public Nodo(int data, Nodo lt, Nodo rt) {
        valor = data;
        izq = lt;
        der = rt;

    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    /**
     * @return the valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @return the izq
     */
    public Nodo getIzq() {
        return izq;
    }

    /**
     * @return the der
     */
    public Nodo getDer() {
        return der;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

}
