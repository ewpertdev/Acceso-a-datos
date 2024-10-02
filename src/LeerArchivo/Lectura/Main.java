package LeerArchivo.Lectura;

import PracticarBinario.FicherosBinarios;

public class Main {
    public static void main(String[] args) {
        // Crear instancia de las clases (que necesitemos) para acceder a sus métodos
        // ReadChar readCharFichero = new ReadChar();
        // Llamar al método para leer caracteres del fichero
        // readCharFichero.readCharMethod();

//        CountVocales countVocalesFichero = new CountVocales();
//        countVocalesFichero.contarCaracteresYVocales();
        String ruta = "fichero.bin";
        FicherosBinarios.escribirBinario(ruta);
        FicherosBinarios.leerBinario(ruta);

        // Otros métodos aquí
        // ReadEverything readEverythingFichero = new ReadEverything();
        // readEverythingFichero.leerTodo();


    }
}
