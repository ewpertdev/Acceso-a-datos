package Ficheros;
import java.io.*;

public class Principal {
    public static void cambiarPermisos(File f) {
        f.setExecutable(false);
        f.setReadable(false);
        f.setWritable(false);

    }
    public static void verPermisos(File f) {
        String permisos="";

        //Permisos de lectura
        if(f.canRead())
            permisos=permisos+"r";
        else
            permisos=permisos+"-";

        //Permisos de escritura
        if(f.canWrite())
            permisos=permisos+"w";
        else
            permisos=permisos+"-";

        //Permisos de ejecución
        if(f.canExecute())
            permisos=permisos+"x";
        else
            permisos=permisos+"-";

        System.out.println("Los permisos del archivo "+f.getName()+" son: "+permisos);

    }
    public static void crearFichero(File f) {
        try {
            if(!f.exists()) {
                //Crearemos fisicamente el fichero
                if(f.createNewFile())
                    System.out.println("Fichero creado");
                else
                    System.out.println("Fichero no ha sido creado");
            }else
                System.out.println("El fichero ya existe");

        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    public static void listarFicheros(File d) {
        File[] ficheros=d.listFiles();

        for(File f:ficheros) {
            if(f.isFile())
                System.out.println(f.getName()+" es un fichero ");
            if(f.isDirectory())
                System.out.println(f.getName()+" es un directorio ");
        }
    }
    public static void comprobarDirectorio(File f) {
        if(f.isDirectory()) {
            listarFicheros(f);
        }else {
            if(f.isFile())
                System.out.println("Es un fichero no se puede recorrer");
        }
    }
    public static void main(String[] args) {
        //Se escribe el nombre del fichero que se guarda fisicamente
        String Nombredirectorio = ".\\datos\\";
        String Nombrefichero = "ficheroNuevo.txt";
        File directorio = new File(Nombredirectorio);
        File fichero = new File(Nombredirectorio+Nombrefichero);

        if(!directorio.exists()) {
            System.out.println("El directorio no existe");
            if(directorio.mkdirs()) {
                //Llamo a la función para crear fichero
                crearFichero(fichero);
                //Llamo a la función verPermisos
				/*verPermisos(fichero);
				cambiarPermisos(fichero);
				verPermisos(fichero);

				fichero.delete();*/
            }
            else {
                System.out.println("No se ha podido crear el directorio");
            }
        }//Si el directorio no existe
        else {
            //Directorio existe
            System.out.println("El directorio existe");
            crearFichero(fichero);
        }

        comprobarDirectorio(directorio);

    }

}
