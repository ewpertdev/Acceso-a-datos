package PracticarBinario.Coche;

public class Main {
    public static void main(String[] args) {
        String ruta = "fichero.bin";
        String ruta2 = "ficheroObjectos.bin";
        
        // Escribir y leer datos binarios
        FicherosBinarios.escribirBinario(ruta);
        FicherosBinarios.leerBinario(ruta);

        // Escribir y leer objetos coche
        Coche coche = new Coche();
        coche.escribirCoches(ruta2);
        Coche.leerObjeto(ruta2);
    }
}
