package LeerArchivo.Lectura;

import java.io.File;
import java.util.Scanner;

public class ReadEverything {
    private final String rutaFichero = "hola.txt";

    public void leerTodo() {
        // Metemos el File y Scanner en el try para que se cierren solos porque no se cierren automáticamente
        // es importante cerrarlos porque si no se pueden producir errores, esto se debe a que el fichero está siendo usado por otro programa
        try {
            File fichero = new File(rutaFichero);
            Scanner teclado = new Scanner(fichero);

            System.out.println("Leyendo...:");
            // Método hasNext() para leer cada palabra del archivo porque no sabemos cuantas palabras tiene
            while (teclado.hasNext()) {
                String palabra = teclado.next();
                System.out.println(palabra);
            }
            // Cerramos el Scanner porque no se cierra automáticamente
            teclado.close();
        } catch (Exception e) {
            System.out.println("No existe el archivo");
            e.printStackTrace();
        }
    }
}
