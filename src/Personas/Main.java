package Personas;
// Crea un programa que pida datos de personas como el nombre y la edad.
//Para guardar estos datos se define una clase denominada persona y en un
//fichero binario se guardan varias instancias de la Persona. Después se debe
//crear una función que permita mostrar todas las personas que están
//almacenadas.

// Crear fichero Binario
// Guardar varias instancias de la Persona = File WRITE

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Main {
    public static void escribirBinario(String ruta) {
        File fichero = new File(ruta);
        try {
            FileOutputStream fos = new FileOutputStream(fichero);
            String datos = "Vamos a escribir una prueba de datos";
            // Convertimos de char a bytes
            fos.write(datos.getBytes());
            // Siempre hay que cerrarlo después de la operación
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String ruta = "fichero.bin";

        Scanner teclado = new Scanner(System.in);
        escribirBinario(String ruta);
    }
}
