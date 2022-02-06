/*
 * Estructura de Datos y Algoritmos II - Practica #11
 * 
 * SemaphoreTest
 */

/**
 *
 * @author Edgar
 * @author Tellez Gonzalez Jorge Luis: se añaden comentarios.
 */
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    // Se establecen 4 permisos para el semaforo.
    static Semaphore semaphore = new Semaphore(4);

    //Clase estatica PruebaHilos
    static class PruebaHilos extends Thread {

        String name = "";

        //Constructor de la clase.
        PruebaHilos(String name) {
            this.name = name;
        }

        //Sobreescritura del método run de Thread. 
        @Override
        public void run() {

            try {

                System.out.println(name + " : adquiriendo un permiso...");
                System.out.println(name + " : el semaforo tiene el siguiente numero de permisos disponibles: "
                        + semaphore.availablePermits());

                semaphore.acquire();
                System.out.println(name + " : obtuvo un permiso!");

                try {

                    for (int i = 1; i <= 5; i++) {

                        System.out.println(name + " : se encuentra realizando la operacion " + i
                                + ", permisos disponibles en el semaforo : "
                                + semaphore.availablePermits());

                        // Envía el hilo a dormir un segundo. 
                        Thread.sleep(1000);

                    }

                } finally {

                    // Llamando al método release() después de un acquire() exitoso
                    System.out.println(name + " : está liberando el permiso...");
                    semaphore.release();
                    System.out.println(name + " : permisos disponibles en el semaforo: "
                            + semaphore.availablePermits());

                }

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }

    public static void main(String[] args) {

        System.out.println("El semaforo tiene el siguiente numero de permisos en total : "
                + semaphore.availablePermits());

        /*Seis hilos realizan operaciones con un total de 4 permisos.*/
        
        PruebaHilos t1 = new PruebaHilos("A");
        t1.start();

        PruebaHilos t2 = new PruebaHilos("B");
        t2.start();

        PruebaHilos t3 = new PruebaHilos("C");
        t3.start();

        PruebaHilos t4 = new PruebaHilos("D");
        t4.start();

        PruebaHilos t5 = new PruebaHilos("E");
        t5.start();

        PruebaHilos t6 = new PruebaHilos("F");
        t6.start();

    }
}
