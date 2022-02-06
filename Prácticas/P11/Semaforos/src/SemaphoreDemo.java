/*
 * Estructura de Datos y Algoritmos II - Practica #11
 * 
 * SemaphoreDemo
 */

/**
 *
 * @author Edgar
 * @author Tellez Gonzalez Jorge Luis: se traducen comentarios.
 */
import java.util.concurrent.*;

//Clase que representa el recurso compartido.
class Shared {

    static int contador = 0;
}

//Clase MyThread que hereda de Thread.
class MyThread extends Thread {

    //Declaración del semaforo y el nombre del hilo como atributos. 
    Semaphore sem;
    String threadName;
    
    //Constructor de la clase MyThread. 
    public MyThread(Semaphore sem, String threadName) {
        super(threadName);
        this.sem = sem;
        this.threadName = threadName;
    }

    //Sobreescritura del metodo run de la clase Thread. 
    @Override
    public void run() {

        // Ejecucion del hilo A
        if (this.getName().equals("A")) {
            System.out.println("Iniciando " + threadName);
            
            try {
                // Primero, se obtiene el permiso para acceder al recurso.
                System.out.println(threadName + " está esperando por un permiso.");

                // Adquieriendo el permiso, evitando el bloqueo del recurso para el hilo en cuestion. 
                sem.acquire();

                System.out.println(threadName + " ha obtenido un permiso.");

                // Ahora, se accede al recurso compartido.
                // Otros hilos en espera permaneceran en ese estado hasta que 
                // este hilo libere el permiso.
                for (int i = 0; i < 5; i++) {
                    //Se incrementa el valor de la variable compartida. 
                    Shared.contador++;
                    System.out.println(threadName + ": " + Shared.contador);

                    // Ahora, permitiendo un cambio en la ejecucion,
                    // de ser posible, para permitir al hilo B ejecutarse.
                    Thread.sleep(10);
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }

            // Se libera el permiso. 
            System.out.println(threadName + " ha liberado el permiso.");
            sem.release();
            
        } // Ejecucion del hilo B.
        else {
            System.out.println("Iniciando " + threadName);
            try {
                // Primero, se obtiene el permiso para acceder al recurso.
                System.out.println(threadName + " esta esperando por un permiso.");

                // Adquieriendo el permiso, evitando el bloqueo del recurso para el hilo en cuestion. 
                sem.acquire();

                System.out.println(threadName + " ha obtenido un permiso.");

                // Ahora, se accede al recurso compartido.
                // Otros hilos en espera permaneceran en ese estado hasta que 
                // este hilo libere el permiso.
                for (int i = 0; i < 5; i++) {
                    //Se decrementa el valor de la variable compartida. 
                    Shared.contador--;
                    System.out.println(threadName + ": " + Shared.contador);

                    // Ahora, permitiendo un cambio en la ejecucion,
                    // de ser posible, para permitir al hilo A ejecutarse.
                    Thread.sleep(10);
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
            // Se libera el permiso.
            System.out.println(threadName + " ha liberado el permiso.");
            sem.release();
        }
    }
}

// Clase de prueba.
public class SemaphoreDemo {

    public static void main(String args[]) throws InterruptedException {
        // Se crea un objeto de tipo Semaphore
        // con un unico permiso (Numero de permisos: 1)
        Semaphore sem = new Semaphore(1);

        // Se crean dos hilos con nombres A y B, respectivamente
        // Notese que el hilo A incrementara el contador
        // y el hilo B lo decrementara
        MyThread mt1 = new MyThread(sem, "A");
        MyThread mt2 = new MyThread(sem, "B");

        // Iniciando los hilos A y B
        mt1.start();
        mt2.start();

        // Esperando por los hilos A y B
        mt1.join();
        mt2.join();

        // El contador siempre permanecera en 0 despues
        // de que ambos hilos terminen su ejecucion
        System.out.println("Contador: " + Shared.contador);
    }
}
