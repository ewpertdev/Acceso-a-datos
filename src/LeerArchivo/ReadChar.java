package LeerArchivo;

import javax.annotation.processing.Filer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadChar {
    private final String rutaFichero = "hola.txt"; // ruta del archivo que queremos leer

    public void readCharMethod() {
        try {
            File fichero = new File(rutaFichero); // Crear un objeto File para el fichero especificado
            FileReader fr = new FileReader(fichero); // Preparar para leer el fichero
            BufferedReader br = new BufferedReader(fr); // Utilizamos BufferedReader para leer de forma eficiente

            System.out.println("LEYENDO CADA CARÁCTER..."); // Printear un mensaje para indicar que la lectura empieza
            int caracter; // Variable para almacenar el código ASCII de cada carácter

            // Seguir leyendo caracteres del archivo hasta que llegamos al final (indicado por -1)
            while ((caracter = br.read()) != -1) {
                char letra = (char) caracter; // Convertir int (código ASCII) a char con type casting
                System.out.println(letra); // Printear cada carácter sin espacio

            }
            br.close(); // Cerrar el BufferedReader para liberar recursos
            System.out.println(); // Printear una nueva línea después de leer
        } catch (IOException e) {
            // Si hay un error mientras está leyendo el archivo, printeamos el stack trace para depurar
            e.printStackTrace();
        }


    }
}
