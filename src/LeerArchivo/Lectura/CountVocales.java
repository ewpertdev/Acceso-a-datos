package LeerArchivo.Lectura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* 2. Crea un programa que según lo que hemos visto hoy lea un fichero y
saque por pantalla el número de caracteres que tiene el fichero y el
número de vocales. */

public class CountVocales {
    // Ruta del archivo que queremos leer
    // hola.txt se ubicara en la carpeta LeerArchivo/Lectura que esta al mismo nivel que este archivo CountVocales.java
    // el final en private es para que no se pueda modificar desde fuera de la clase
    private final String rutaFichero = "hola.txt";

    public void contarCaracteresYVocales() {
        // Contadores para caracteres y vocales
        int totalCaracteres = 0;
        int totalVocales = 0;
        // Intentamos leer el archivo
        // Creamos el objeto BufferedReader para leer el archivo
        // Se mete new FileReader(rutaFichero) dentro de new BufferedReader para que se pueda leer el archivo, porque FileReader es la clase que se encarga de leer el archivo
        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {
            int caracter;
            // Leemos el archivo carácter por carácter
            // br.read() es un metodo de la clase BufferedReader que lee un caracter del archivo
            // != -1 es para que se ejecute el bucle mientras no se llegue al final del archivo
            while ((caracter = br.read()) != -1) {
                // Usamos el contador de caracteres para contar cada caracter
                totalCaracteres++;
                // Usamos Character.toLowerCase para convertir el carácter a minúscula porqué queremos que sea igual para todas las vocales
                char letra = Character.toLowerCase((char) caracter);
                // Verificamos si el carácter es una vocal
                if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                    // Si es una vocal, incrementamos el contador de vocales
                    totalVocales++;
                }
            }
            
            // Mostramos los resultados
            System.out.println("Número total de caracteres: " + totalCaracteres);
            System.out.println("Número total de vocales: " + totalVocales);
        } catch (IOException e) {
            System.out.println("No se puede leer el archivo ");
            e.printStackTrace();
        }
    }
}



