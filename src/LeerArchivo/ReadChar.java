package LeerArchivo;

import javax.annotation.processing.Filer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadChar {
    private final String rutaFichero = "hola.txt";

    public void readCharMethod() {
        try {
            File fichero = new File(rutaFichero);
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);

            System.out.println("LEYENDO CADA CARACTER...");
            int caracter;

            while((caracter = br.read())!=-1) {
                char letra = (char) caracter; // CONVERTIR INT A CHAR CON CASTING
                System.out.println(letra);

            }
            br.close();
            System.out.println(); // PRINTEAR UNA NUEVA LINEA DESPUES DE LEER
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
