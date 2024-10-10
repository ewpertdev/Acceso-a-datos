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
        LibreriaBea libroBea= null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File))){

        libroBea=(LibreriaBea)ois.readObject();
            
        } catch (ClassNotFoundException e) {
            System.out.println("No hemos podido recuperar el objecto");
            e.printStackTrace();
            
        } catch(IOException e) {
            System.out.println("Error en la lectura");
            e.printStackTrace();

        }
        return libroBea; 

    }

    public static void main(String[] args) {
        // Crear libreria
        LibreriaBea libreria = new LibreriaBea();
        libreria.insertarLibros("Harry Potter", "JK Rowling", 12)

    }

}
//  aux.listarLibros();
//  List<Libro> = p.auxfiltrarLibrosPorPrecio(17.00, 17.00);