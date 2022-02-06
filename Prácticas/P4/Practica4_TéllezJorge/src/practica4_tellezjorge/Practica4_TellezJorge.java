
package practica4_tellezjorge;

import java.util.LinkedList;
import java.util.List;

/**
 *Practica 4: Clase principal del programa.
 *@autor: Tellez Gonzalez Jorge Luis
 *
 **/

public class Practica4_TellezJorge {

    public static void main(String[] args) {
        
        System.out.println("Practica 4: Algoritmos de busqueda");
        
        List<Integer> lista1 = new LinkedList<>();
        
        lista1.add(15);
        
        lista1.add(12);
        lista1.add(20);
        lista1.add(45);
        lista1.add(96);
        lista1.add(74);
        
        lista1.add(80);
        
        System.out.println(" Estado punto 1 ");
        imprimirLista(lista1);
        System.out.println(" *** ");
        
        lista1.add(1,300);
        lista1.add(3,500);
        lista1.add(5,700);
        
        System.out.println(" Estado punto 2 ");
        imprimirLista(lista1);
        System.out.println(" *** ");
        
        lista1.set(0, 4);
        lista1.set(2, 6);
        lista1.set(7, 8);
        
        System.out.println(" Estado punto 3 ");
        imprimirLista(lista1);
        System.out.println(" *** ");
         
        List<Integer> lista2;
        lista2 = lista1.subList(3, 6);
        imprimirLista(lista2);
        System.out.println(" *** ");
        System.out.println(lista1.equals(lista2));
        
        int posicion=lista2.indexOf(700);
        System.out.println("Posicion del 700 en la sublista: "+posicion);
        
        System.out.println("****Pruebas de algoritmos de búsqueda***");
        
        imprimirLista(lista2);
        
        System.out.println("El 600 se encuentra en la lista?: " +BusquedaLineal.busquedaCentinela(lista2, 600));
        System.out.println("El valor 700 tiene el indice: "+ BusquedaLineal.busquedaIndice(lista2, 700));
        System.out.println("¿Cuantas veces se encuentra el 20?:" +BusquedaLineal.busquedaIncidencia(lista2, 20));

        
        
        lista2.remove(posicion);
        System.out.println("Se elimino el elemento en la posicion: "+posicion);
        System.out.println("Sublista actual");
        System.out.println(" *** ");
        imprimirLista(lista2);
        
        System.out.println("La sublista está vacia?");
        boolean res=lista2.isEmpty();
        System.out.println("Resultado: " +res);
        
                lista2.set(0, 200);
                lista2.set(1, 500);
                lista2.add(500);
                lista2.add(700);
                lista2.add(900);
                imprimirLista(lista2);
        
        System.out.println("El 500 se encuentra en la lista?: "+BusquedaBinaria.busquedaValor(lista2, 500, 0, lista2.size()));
        System.out.println("¿Cuantas veces se encuentra el 500 en la lista?: " +BusquedaBinaria.busquedaIncidencia(lista2, 500, 0, lista2.size()));
        
        List<Perro> lomitos= new LinkedList();
        
        System.out.println("");
        lomitos.add(new Perro("Arnold", "Boxer", "Cafe")); //Posicion 0.
        lomitos.add(new Perro("Cookie", "Cavalier", "Cafe")); //Posicion 1.
        lomitos.add(new Perro("Iggy", "Doberman", "Negro")); //Posicion 2.
        lomitos.add(new Perro("Jake", "Pug", "Negro")); //Posicion 3.
        lomitos.add(new Perro("Kike", "Mastin", "Negro")); //Posicion 4.
        lomitos.add(new Perro("Iggy", "Doberman", "Negro"));

        System.out.println("");
        
        System.out.println("Donde se encuentra Jake?");
        System.out.println("Indice de Jake: "+ BusquedaLineal.busquedaLinealNombre(lomitos, "Jake"));
        System.out.println("Donde esta Jake? " + BusquedaBinaria.busquedaBinariaNombre(lomitos, "Jake", 0, lomitos.size()));
        System.out.println("Quieres que Jake vaya por la pelota? (Vamos, yo se que si quieres...)");
        Perro.pelota(lomitos, 3);
        System.out.println("Jake se emociono!");
        Perro.ladrar(lomitos, 3);
        System.out.println("Olvide la raza de Cookie...");
        System.out.println("En que posicion estara?: " +BusquedaBinaria.busquedaBinariaRaza(lomitos, "Cavalier", 0, lomitos.size()) );
        System.out.println("Un momento...");
        System.out.println("¿Y a donde se fue Iggy?!: "+ BusquedaBinaria.busquedaBinariaNombre(lomitos, "Iggy", 0, lomitos.size()));
    }
    
    public static void imprimirLista(List<Integer> listaPrint){
    
        for(Integer var : listaPrint){
            System.out.println(var);
        
        }
    
    }
    
    public static void imprimirListaP(List<Perro> listaPrint){
    
        for(Perro var : listaPrint){
            System.out.println(var);
        
        }
    
    }
    
}

