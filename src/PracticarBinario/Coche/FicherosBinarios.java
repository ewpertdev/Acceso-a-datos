package PracticarBinario.Coche;

import java.io.*;

public class FicherosBinarios {
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
    public static void leerBinario(String ruta) {
        File fichero = new File(ruta);
        try {
            FileInputStream fis = new FileInputStream(fichero);
            int i;
            while((i=fis.read())!=-1){
                System.out.println((char)i);
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

