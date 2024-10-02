package PracticarBinario;

public class Main {
    public static void main(String[] args) {
        String ruta = "fichero.bin";
        String ruta 2 = "ficheroObjectos.bin";
        // Crear instancia de las clases (que necesitemos) para acceder a sus métodos
        FicherosBinarios fb = new FicherosBinarios();
        // Llamar al método para leer caracteres del fichero
        fb.escribirBinario(ruta);


        FicherosBinarios ffb = new FicherosBinarios();
        ffb.leerBinario(ruta);
        FicherosBinarios lo = new FicherosBinarios();

    }
}
