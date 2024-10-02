package PracticarBinario.Personas;

import java.io.*;

// Importamos la clase Serializable para que las personas se puedan guardar en un fichero binario
// Esto se debe a que Serializable es una interfaz que permite que un objeto se pueda convertir en una secuencia de bytes
// Y asi poder guardarlo en un fichero binario
// Implementamos Serializable en la clase Persona porque es una clase que vamos a guardar en un fichero binario
// La clase es public para que las clases que no estan en el mismo paquete puedan acceder a ella
public class Persona implements Serializable {
    // Declaramos los atributos de la clase Persona
    // Es protected para que las clases que hereden de Persona puedan acceder a ellos
    protected String nombre;
    protected int edad;

    // Constructor de la clase Persona
    // El constructor es public para que las clases que hereden de Persona puedan acceder a el
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Metodo para mostrar las personas almacenadas en el fichero binario
    public static void mostrarPersonas(String ruta) {
        // El try con recursos es para que el ObjectInputStream se cierre automaticamente
        // Hay que cerrar el ObjectInputStream porque es un flujo de entrada que se tiene que cerrar
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            // Declaramos una variable de tipo Persona
            Persona persona;
            // El while se ejecuta mientras el ObjectInputStream no sea null
            // Mientras persona sea distinto de null, se ejecuta el bucle
            // El ois.readObject() es un metodo de la clase ObjectInputStream que lee un objeto del fichero binario
            // El (Persona) es para que el objeto persona se convierta en un objeto de tipo Persona
            // El != null es para que el bucle se ejecute mientras el ObjectInputStream no sea null
            while ((persona = (Persona) ois.readObject()) != null) {
                // Mostramos el nombre y la edad de la persona
                System.out.println("Nombre: " + persona.nombre + ", Edad: " + persona.edad);
            }
            // EOFException es una excepcion que se lanza cuando se llega al final del fichero
            // La diferencia del EOFException con IOException es que EOFException se lanza cuando se llega al final del fichero
            // Y IOException se lanza cuando hay un error de entrada/salida
            // Mientras que ClassNotFoundException se lanza cuando no se encuentra la clase a la que se intenta acceder
            // Estos tres catch estan en orden, primero se ejecuta el catch de EOFException, luego el de IOException y por ultimo el de ClassNotFoundException
        } catch (EOFException e) {
            // Si el ObjectInputStream es null, se lanza una excepcion EOFException
            System.out.println("Fin de fichero");
        } catch (IOException | ClassNotFoundException e) {
            // Si el ObjectInputStream no es null, se lanza una excepcion IOException o ClassNotFoundException
            System.out.println("Error al leer el fichero");
            // El e.printStackTrace() es un metodo de la clase Exception que muestra el mensaje de la excepcion
            e.printStackTrace();
        }
    }

    // Metodo para escribir las personas en el fichero binario
    public void escribirPersonas(String ruta) {
        // El try con recursos (try con recursos se refiere a que el try se encarga de cerrar los recursos, siendo los recursos los objetos que se abren en el try) 
        // es para que el ObjectOutputStream se cierre automaticamente
        // ObjectOutputStream es una clase que permite escribir objetos en un fichero binario
        // new FileOutputStream(ruta, true) es para que el fichero se añada y no se sobrescriba
        // El true es para que el fichero se añada y no se sobrescriba
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta, true))) {
            // El oos.writeObject(this) es un metodo de la clase ObjectOutputStream que escribe un objeto en el fichero binario
            // this se refiere a la instancia actual de la clase Persona
            // Para explicarlo de una manera mas sencilla, this es una referencia a la instancia actual de la clase
            // Y como this es una instancia de la clase Persona, se puede escribir en el fichero binario
            // Entonces lo que hemos hecho es escribir en el fichero binario la instancia actual de la clase Persona 
            // Gracias al metodo writeObject() de la clase ObjectOutputStream
            // Y como this es una instancia de la clase Persona, se puede escribir en el fichero binario
            oos.writeObject(this);
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero");
            // El e.printStackTrace() es un metodo de la clase Exception que muestra el mensaje de la excepcion
            e.printStackTrace();
        }
    }
}
