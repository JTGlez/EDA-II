/*
 * P5: Algoritmos de busqueda: Parte 2
 * 
 * 
 */
package practica5.tellezjorge;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @autor: Téllez González Jorge Luis
 */
public class FuncionHash {

    private ArrayList<Integer> arrayInt;
    public Scanner lectura;
    
    public static int moduloHash(int valorIngresado) {

        System.out.println("El valor ingresado es " + valorIngresado + 
                " con identificador: " + (valorIngresado%13));
        int identificador = valorIngresado%13;
        return identificador;

    }

    public void inicializacion() {

        arrayInt = new ArrayList<>();
        for (int i = 0; i < 15; i++) {

            this.arrayInt.add(null);

        }

    }

    public void submenuHash(FuncionHash hash) {

        int seleccion2 = 0;
        inicializacion();
        while (seleccion2 != 4) {

            System.out.println("\n¿Que desea hacer?: ");
            System.out.println("1)Agregar elementos.");
            System.out.println("2)Imprimir lista.");
            System.out.println("3)Buscar elementos.");
            System.out.println("4)Salir de la opcion seleccionada.\n");
            System.out.print("Seleccion: ");

            lectura = new Scanner(System.in);
            seleccion2 = lectura.nextInt();

            switch (seleccion2) {

                case 1: {
                    
                    System.out.print("\nIngrese un valor: ");
                    int valorAIngresar = lectura.nextInt();
                    int posicionDeIngreso=hash.pruebaLinealColision(valorAIngresar);
                    if (posicionDeIngreso!=-1) {
                        this.arrayInt.set(posicionDeIngreso, valorAIngresar);
                        System.out.println("\nOperacion completada con exito.\n");
                        System.out.println(this.arrayInt);
                        
                    }
                    else{ 
                    
                        System.out.println("\nEl valor no pudo ser agregado.\n");
                        
                    }
  

                    break;
                }

                case 2: {
                    
                    System.out.println("Impresion de la lista actual: \n");
                    System.out.println(this.arrayInt);

                    break;
                }

                case 3: {
                    
                    System.out.print("\nIngrese un valor: ");
                    int valorABuscar = lectura.nextInt();
                    int posicionDeBusqueda=hash.busquedaLineal(valorABuscar);
                    if (posicionDeBusqueda!=-1) {
                        System.out.println("\nEl elemento buscado se encuentra en la posicion: "+posicionDeBusqueda);
                        System.out.println(this.arrayInt);
                        System.out.println("\nOperacion completada con exito.\n");
                        
                    }
                    else{ 
                    
                        System.out.println("\nEl valor ingresado no se encuentra en la lista.\n");
                        System.out.println(this.arrayInt);
                        
                    }

                    break;
                }

                case 4: {

                    System.out.println("Regresando al menu principal...");
                    System.out.println("");
                    break;

                }

                default: {

                    System.out.println("\nPor favor seleccione una opcion correcta.\n");


                    break;
                }

            }
        }
    }

    public int pruebaLinealColision(int valorAIngresar) {
        
        int posicionAIngresar = FuncionHash.moduloHash(valorAIngresar);
        
        while (this.arrayInt.get(posicionAIngresar) != null) {
            
            posicionAIngresar++;
            System.out.println("Se detecto una colision. Nuevo identificador: "+posicionAIngresar);
            
            if (posicionAIngresar == this.arrayInt.size()) {
                posicionAIngresar = 0;

            }
            if (posicionAIngresar==FuncionHash.moduloHash(valorAIngresar)) {
                System.out.println("No hay mas espacio disponible en la lista.");
                return -1;
            }

        }
        return posicionAIngresar;

    }


    public int busquedaLineal(int valorABuscar) {

        int indiceABuscar = FuncionHash.moduloHash(valorABuscar);

        if (this.arrayInt.get(indiceABuscar) != null) {

            while (this.arrayInt.get(indiceABuscar) != valorABuscar) {
                indiceABuscar++;
                System.out.println("No se ha encontrado el elemento en la posicion actual. Nuevo identificador: "+indiceABuscar);
                if (indiceABuscar == this.arrayInt.size() - 1) {
                    indiceABuscar = 0;

                }

                if (indiceABuscar == FuncionHash.moduloHash(valorABuscar)) {
                    return -1;
                }

            }
            return indiceABuscar;

        } else {

            return -1;
        }

    }

}
