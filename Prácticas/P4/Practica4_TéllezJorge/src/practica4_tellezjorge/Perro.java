package practica4_tellezjorge;

import java.util.List;

/**
 *Practica 4: Clase modeladora del tipo de dato Perro.
 *@autor: Tellez Gonzalez Jorge Luis
 *
 **/
public class Perro {
    
    private String nombreDelPerro;
    private String razaDelPerro;
    private String colorDePelaje;
    
    public Perro(String nombreDelPerro, String razaDelPerro, String colorDePelaje){
        this.nombreDelPerro=nombreDelPerro;
        this.razaDelPerro=razaDelPerro;
        this.colorDePelaje=colorDePelaje;
    }
    /**
     * @return el nombreDelPerro.
     */
    public String getNombre(){
    
        return nombreDelPerro;
    }
    
    /**
     * @return el colorDePelaje.
     */
    public String getColor(){
    
        return colorDePelaje;
    }

    public static void ladrar(List<Perro> lista, int clave){
        String nombrePerro=lista.get(clave).getNombre();
        System.out.println("El perro " +nombrePerro+ " tiene unas palabras para tí: ");
        System.out.println("¡Guau!");
    }
    
    public static void pelota(List<Perro> lista, int clave){
        String nombrePerro=lista.get(clave).getNombre();
        System.out.println("¡El perro " +nombrePerro+ " se ha ido corriendo por la pelota!");
        System.out.println("¡Wow! *Se ve muy emocionado*");
    }

    /**
     * @return la razaDelPerro.
     */
    public String getRaza() {
        return razaDelPerro;
    }
    
}
