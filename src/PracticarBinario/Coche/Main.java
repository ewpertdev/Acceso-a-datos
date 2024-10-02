package PracticarBinario.Coche;

public class Main {
    public static void main(String[] args) {
        String ruta = "fichero.bin";
        String ruta2 = "ficheroObjectos.bin";
        
        // Escribir y leer datos binarios
        FicherosBinarios.escribirBinario(ruta);
        FicherosBinarios.leerBinario(ruta);

        // Llamamos directamente d
        Coche.escribirCoches(ruta2);
        Coche.leerCoche(ruta2);
    }
}
