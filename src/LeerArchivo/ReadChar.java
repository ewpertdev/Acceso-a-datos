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

            // Seguir leyendo caracteres del archivo hasta que llegamos al final (indicado por -1)
            while((caracter = br.read())!=-1) {
                char letra = (char) caracter; // Convertir int (código ASCII) a char con type casting
                System.out.println(letra); // Printear cada carácter sin espacio

            }
            br.close();
            System.out.println(); // Printear una nueva línea después de leer
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
