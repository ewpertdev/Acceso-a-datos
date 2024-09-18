package Operaciones_ficheros;

import java.io.*;

public class Ficheros {

    // Metodo para quitar permisos
    public static void cambiarPermisos(File f) {
        f.setReadable(false);
        f.setWritable(false);
        f.setExecutable(false);
    }

    public static void listarFicheros(File f) {
        File[] ficheros = d.listFiles();

        for(File f:ficheros) {
            if(f.isFile())
                System.out.println(f.getName() + " es un fichero ");
            if(f.isDirectory())
                System.out.println(f.getName() + " es un directorio ");




        }
    public static void comprobarDirectorio(File f) {
        if(f.isDirectory()) {
            listarFicheros(f);
        }else{
                if(f.isFile())
                    System.out.println("");
            }
        }
    }
    public static void crearFichero(File f) {

    }
    public static void verPermisos(File f) {
        String permisos = "";

        //Permisos de lectura
        if (f.canRead())
            permisos = permisos + "r";
        else
            permisos = permisos + " - ";
        //Permisos de escritura
        if (f.canWrite())
            permisos = permisos + "w";
        else
            permisos = permisos + " - ";

        //Permiso de ejecucion
        if (f.canExecute())
            permisos = permisos + "x";
        else
            permisos = permisos + " - ";

        // Can also use f.getAbsolutePath() instead of f.getName()
        System.out.println("Los permisos del archivo " + f.getAbsolutePath() + " son " + permisos);

    }

    public static void main(String[] args) {

        // Making directory
        String nombreDirectorio = ".\\datos\\";
        // Se escribe el nombre del fichero que se guarda fisicamente
        String nombreFichero = "ficheroNuevo.txt";
        File directorio = new File(nombreDirectorio);
        File fichero = new File(nombreDirectorio + nombreFichero);

        if (!directorio.exists()) {
            // Crear directorio
            if (directorio.mkdirs()) {
                // Llamó a la función para crear fichero
                crearFichero(fichero);


                try {
                    if (!fichero.exists()) {

                        //Crearemos fisicamente el fichero
                        if (fichero.createNewFile())
                            System.out.println("Fichero creado");
                        else
                            System.out.println("Fichero no creado");
                    } else
                        System.out.println("Ya existe");

                    // Llamo
                    //Llamo a la funcion verPermisos
                    verPermisos(fichero);
                    cambiarPermisos(fichero);

                    fichero.delete();


                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                // Si el directorio no existe
                System.out.println("El directorio no existe");
            }

        }
    }
}