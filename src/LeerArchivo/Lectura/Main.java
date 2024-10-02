package LeerArchivo.Lectura;

public class Main {
    public static void main(String[] args) {
        // Crear instancia de las clases (que necesitemos) para acceder a sus métodos
        // ReadChar readCharFichero = new ReadChar();
        // Llamar al método para leer caracteres del fichero
        // readCharFichero.readCharMethod();

        CountVocales countVocalesFichero = new CountVocales();
        countVocalesFichero.contarCaracteresYVocales();

        // Otros métodos aquí
        // ReadEverything readEverythingFichero = new ReadEverything();
        // readEverythingFichero.leerTodo();


    }
}
