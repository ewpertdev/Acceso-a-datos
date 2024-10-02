package PracticarBinario.Coche;

import java.io.*;

public class FicherosBinarios {
    public static void escribirBinario(String ruta) {
        // Creamos un fichero en la ruta que le pasemos
        File fichero = new File(ruta);
        // El try con recursos es para que el FileOutputStream se cierre automaticamente
        // FileOutputStream es un flujo de salida que se encarga de escribir en el fichero
        // si no cerramos el FileOutputStream, no podremos escribir en el fichero   
        try {
            FileOutputStream fos = new FileOutputStream(fichero);
            String datos = "Vamos a escribir una prueba de datos";
            // Aqui convertimos de char a bytes
            // Convertimos el String datos en un array de bytes
            // El getBytes() es un metodo de la clase String que convierte el String en un array de bytes
            // Y con el fos.write() escribimos el array de bytes en el fichero
            fos.write(datos.getBytes());
            // Siempre hay que cerrarlo después de la operación porque es un flujo de salida, debido a que estamos escribiendo en el fichero 
            fos.close();
            // el catch se encarga de que si ocurre un error, se muestre el error
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Metodo para leer el fichero binario
    public static void leerBinario(String ruta) {
        // Creamos un fichero en la ruta que le pasemos
        File fichero = new File(ruta);
        // El try con recursos es para que el FileInputStream se cierre automaticamente
        // FileInputStream es un flujo de entrada que se encarga de leer el fichero
        // si no cerramos el FileInputStream, no podremos leer el fichero
        try {
            FileInputStream fis = new FileInputStream(fichero);
            int i;
            // El while se ejecuta mientras el FileInputStream no sea -1
            // Mientras i sea distinto de -1, se ejecuta el bucle
            // El fis.read() es un metodo de la clase FileInputStream que lee un byte del fichero
            // Y con el System.out.println() mostramos el byte leido
            while((i=fis.read())!=-1){
                System.out.println((char)i);
            }
            fis.close();
            // el catch se encarga de que si ocurre un error, se muestre el error
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

