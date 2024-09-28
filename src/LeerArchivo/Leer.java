package LeerArchivo;

import java.io.File;
import java.util.Scanner;

public class Leer {
    private final String rutaFichero = "hola.txt";

    public void leerCadaCaracter() {
        try {
            File fichero = new File(rutaFichero);
            Scanner teclado = new Scanner(fichero);

            System.out.println("Leyendo...:");
            while(teclado.hasNext()) {
                String palabra = teclado.next();
                System.out.println(palabra);
            }
            teclado.close();
        } catch (Exception e) {
            System.out.println("No existe el archivo");
            e.printStackTrace();
        }
    }
}
