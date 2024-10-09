package FicheroAccesoAleatorio;

import java.io.*;

// Fichero Acceso Aleatorio
public class Libros1 {
    public static void EscrituraFicheroAleatorio(String fichero, String cadena, RandomAccessFile raf){
        try {
            raf = new RandomAccessFile(fichero, "rw");
            long size = raf.length();
            // Me posicionon en elfichero con seek
            raf.seek(size);
            raf.writeBytes(cadena);
            System.out.println("Se ha escrito en el fichero");
            raf.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: no se ha encontrado el fichero.");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: en la lectura o escritura del fichero.");
            System.out.println(e.getMessage());
        }
    
    }
    public static void LecturaFicheroAccesoAleatorio(String nombreFichero, long posicion, int longitud){
        String resultado;
        try (RandomAccessFile raf = new RandomAccessFile(nombreFichero, "r")){
            raf.seek(posicion);
            byte[] bytes = new byte[(int)raf.length()];
            raf.readFully(bytes);
            resultado=new String(bytes).trim();
            System.out.println(resultado);
    }
         catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        String nombreFichero ="FicheroAccesoAleatorio.txt";
        String cadena = "\nHola";
        RandomAccessFile raf = null;
        EscrituraFicheroAleatorio(nombreFichero, cadena, raf);
        LecturaFicheroAccesoAleatorio(nombreFichero, 0,50);
    }
    
}
