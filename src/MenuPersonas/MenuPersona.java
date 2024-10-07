package MenuPersonas;

// Crea un programa que pida datos de personas como el nombre y la edad. 
// Para guardar estos datos se define una clase denominada persona y en un fichero binario se guardan varias instancias de la Persona. 
// Después se debe crear una función que permita mostrar todas las personas que están almacenadas.
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase para gestionar el menú de personas
public class MenuPersona {
    // Nombre del fichero binario donde se guardan las personas
    // private static final String FILENAME = "personas.dat"; porque es una constante y no se puede modificar
    // static es una palabra clave en Java que se utiliza para indicar que el atributo o método pertenece a la clase en lugar de a una instancia específica de la clase
    // final es una palabra clave en Java que se utiliza para indicar que el valor de un atributo o método no puede ser modificado después de que se haya inicializado
    // Por qué es static y final? porque el nombre del fichero es una constante y es necesario que sea static para que 
    // sea compartido por todas las instancias de la clase y final para que no se pueda modificar
    // las instancias de la clase son los objetos que se crean a partir de la clase
    private static final String FILENAME = "personas.dat";
    // Scanner para leer la entrada del usuario
    private Scanner scanner;
    
    // Constructor para inicializar el scanner
    public MenuPersona() {
        scanner = new Scanner(System.in);
    }
    
    // Método para ejecutar el menú
    public void ejecutar() {
        // Variable para controlar si el usuario quiere salir del programa
        // boolean es un tipo de dato en Java que puede tener dos valores: true o false
        boolean salir = false;
        // Bucle para mostrar el menú y procesar la opción del usuario
        while (!salir) {
            System.out.println("\nMenú de Personas:");
            System.out.println("1. Agregar persona");
            System.out.println("2. Mostrar personas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            // Leer la opción del usuario
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner para que no se produzcan errores
            
            // Seleccionar la opción del menú
            switch (opcion) {
                case 1:
                    agregarPersona();
                    break;
                case 2:
                    mostrarPersonas();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }
    
    // Método para agregar una persona al fichero binario
    private void agregarPersona() {
        System.out.print("Ingrese el nombre de la persona: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la edad de la persona: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner para que no se produzcan errores
        
        // Crear una nueva persona con los datos ingresados por el usuario
        Persona persona = new Persona(nombre, edad);
        
        // Escribir la persona en el fichero binario
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME, true))) {
            oos.writeObject(persona);
            System.out.println("Persona agregada exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar la persona: ");
        }
    }
    
    // Método para mostrar todas las personas almacenadas en el fichero binario
    private void mostrarPersonas() {
        // Crear una lista para almacenar las personas
        List<Persona> personas = new ArrayList<>();
        
        // Leer las personas del fichero binario
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            // Leer las personas del fichero binario hasta que se termine el archivo
            while (true) {
                personas.add((Persona) ois.readObject());
            }
        } catch (EOFException e) {
            // EOFException es una excepción en Java que se lanza cuando se intenta leer más allá del final de un archivo
        } catch (IOException | ClassNotFoundException e) { 
            // IOException es una excepción en Java que se lanza cuando ocurre un error de entrada/salida
            // ClassNotFoundException es una excepción en Java que se lanza cuando se intenta deserializar un objeto que no existe
            System.out.println("Error al leer las personas: ");
            e.printStackTrace();
        }
        
        // Mostrar las personas almacenadas
        if (personas.isEmpty()) {
            System.out.println("No hay personas almacenadas.");
        } else {
            System.out.println("Personas almacenadas:");
            // Recorrer la lista de personas y mostrar cada una de ellas
            for (Persona p : personas) {
                // Mostrar la persona en formato de cadena
                System.out.println(p);
            }
        }
    }
    
    // Método main para ejecutar el programa
    public static void main(String[] args) {
        // Crear una instancia de MenuPersona y ejecutar el menú
        new MenuPersona().ejecutar();
    }
}

// Clase para representar una persona
// Implementa la interfaz Serializable para que la clase pueda ser serializada
// Serializable es una interfaz en Java que permite a una clase especificar que sus instancias pueden ser convertidas en una secuencia de bytes
// Esto es necesario para que la clase Persona pueda ser guardada en un fichero binario
class Persona implements Serializable {
    // Serial version UID para la serialización
    // Este UID es necesario para que la clase Persona pueda ser serializada y deserializada correctamente
    // Serialización es el proceso de convertir objetos en un formato que puede ser almacenado o transmitido
    // Deserialización es el proceso de convertir datos binarios de vuelta en objetos
    private static final long serialVersionUID = 1L;
    // Atributos para almacenar el nombre y la edad de la persona
    private String nombre;
    private int edad;
    
    // Constructor para inicializar los atributos
    // Constructor es un método especial que se utiliza para inicializar los atributos de una clase
    // En este caso, el constructor recibe el nombre y la edad de la persona y los asigna a los atributos de la clase
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    // Método para obtener una representación en cadena de la persona
    // Override es una palabra clave en Java que se utiliza para modificar el comportamiento de un método heredado de una clase padre
    // En este caso, se está modificando el método toString() de la clase Object para que devuelva una representación en cadena de la persona
    @Override
    // toString() es un método de la clase Object que devuelve una representación en cadena de la persona
    // En este caso, se está modificando para que devuelva una cadena que contiene el nombre y la edad de la persona
    public String toString() {
        // Devolver una cadena que contiene el nombre y la edad de la persona
        return "Nombre: " + nombre + ", Edad: " + edad;
    }
}
