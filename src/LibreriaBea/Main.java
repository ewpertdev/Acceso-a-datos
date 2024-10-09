package LibreriaBea;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    private static void escribirFichero(String nombreFichero, <LibreriaBea> Libreria){
        try(ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream(nombreFichero))){
            oos.writeObject(libreria);
            System.out.println("He escrito todos los libros");
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }

    

    private static LibreriaBea leerFichero(){
        LibreriaBea libroBea = new LibreriaBea();
        try {
            
        } catch (IOException e) {
            e.printStackTrace();
            
        }
        return libroBea; 

    }

    public static void main(String[] args) {

    }

}
