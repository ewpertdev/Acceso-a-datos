package PracticarBinario.Personas;
// EJERCICIO 1
// Crea un programa que pida datos de personas como el nombre y la edad.
//Para guardar estos datos se define una clase denominada persona y en un
//fichero binario se guardan varias instancias de la Persona. Después se debe
//crear una función que permita mostrar todas las personas que están
//almacenadas.

/* Conceptos en este ejercicio:
 * 1. Fichero binario: Es un fichero que almacena datos en formato binario, un formato binario es un formato de datos que se almacena en bytes, 
 * el problema de los bytes es que no se puede leer directamente por el ser humano, por eso usamos un ObjectOutputStream para escribir los objetos en el fichero binario.
 * 2. Objeto: Recordemos que objeto es una instancia de una clase, por eso usamos this para referirnos a la instancia actual de la clase
 * 3. Serializable: Es una interfaz que nos permite serializar los objetos, es decir, convertir los objetos en bytes para que puedan ser guardados en un fichero binario
 * 4. ObjectOutputStream: Es una clase que permite escribir objetos en un fichero binario
 * 5. ObjectInputStream: Es una clase que permite leer objetos de un fichero binario
 * 6. EOFException: Es una excepcion que se lanza cuando se llega al final del fichero, lo dice su propio nombre (End Of File)
 * 7. IOException: Es una excepcion que se lanza cuando hay un error de entrada/salida, lo dice su propio nombre (input/output)
 * 8. ClassNotFoundException: Es una excepcion que se lanza cuando no se encuentra la clase a la que se intenta acceder, lo dice su propio nombre (Class)
 * 9. LEER en un fichero binario: Para leer en un fichero binario, usamos un ObjectInputStream para leer los objetos del fichero binario con el metodo readObject()
 * 10. LEER en un fichero de texto: Para leer en un fichero de texto, usamos un BufferedReader o un Scanner para leer el fichero de texto con el metodo readLine() o nextLine()
 * 11.ESCRIBIR en un fichero binario: Para escribir en un fichero binario, usamos un ObjectOutputStream para escribir los objetos en el fichero binario con el metodo writeObject()
 * 12.ESCRIBIR en un fichero de texto: Para escribir en un fichero de texto, usamos un BufferedWriter o un PrintWriter para escribir el fichero de texto con el metodo write() o println()
 */

/* Paso por paso:
 * 1. Crear fichero binario llamado personas.bin
 * 2. Pedir datos de la persona (nombre y edad)
 * 3. Guardar varias instancias de la Persona en el fichero binario
 * 4. Mostrar las personas almacenadas en el fichero binario
 */

 // La dificultad de este ejercicio radica en que no podemos leer directamente el fichero binario
 // para ello tenemos que deserializar los objetos, es decir, convertir los bytes en objetos
 // por lo tanto usaremos un ObjectInputStream para leer los objetos del fichero binario
 // Y para leer los objetos que el usuario vaya introduciendo, usaremos un bucle while
 // Ademas, usaremos un try catch para que el usuario pueda introducir letras en vez de numeros en la edad
 // Y para que el programa sea mas visual, usaremos un scanner para leer los datos de la persona

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creamos la carpeta Personas y luego metemos personas.bin dentro de ella
        // La ruta es relativa, es decir, es la ruta de la carpeta Personas que se encuentra en el mismo nivel que el archivo Main.java
        String ruta = "PracticarBinario/Personas/personas.bin";
        // El scanner para leer los datos de la persona
        Scanner teclado = new Scanner(System.in);
       
        // Usamos un bucle while para que el usuario pueda introducir varias personas
        while (true) {
            // Usamos un try catch debido a que el usuario puede introducir letras en vez de numeros en la edad
            try {
                // Un mensaje para que el usuario sepa que tiene que introducir el nombre y la edad
                System.out.println("Introduce el nombre de la persona (o 'salir' para terminar): ");
                
                // Aqui estamos leyendo el nombre de la persona
                // Usamos nextLine() porque el nombre puede tener espacios, por ejemplo: "Jose Luis"
                String nombre = teclado.nextLine();
                // Si el nombre es "salir", salir del bucle
                // usamos equalsIgnoreCase() para que el programa no se quede colgado si el usuario introduce "Salir" o "SALIR" o "sAlIR" en vez de "salir"
                if (nombre.equalsIgnoreCase("salir")) {
                    // El break es para que salgamos del bucle si el usuario introduce "salir"
                    break;
                } else {
                    // Si el nombre no es "salir", pedimos la edad, asumimos ya ha introducido el nombre
                    System.out.println("Introduce la edad de la persona: ");
                    // Integer.parseInt() es un metodo de la clase Integer que nos permite convertir una cadena de caracteres a un numero entero
                    // Lo hacemos porque el metodo nextInt() solo lee numeros enteros y el teclado.nextLine() lee cadenas de caracteres
                    // De esta manera podemos leer la edad de la persona
                    // La razon por la que teclado.nextLine() viene en parentesis dentro del Integer.parseInt() es porque el metodo nextInt() no existe, sino que es nextLine()
                    int edad = Integer.parseInt(teclado.nextLine());
                    // Aqui se crea un objeto de la clase Persona con el nombre y la edad que hemos leido
                    Persona persona = new Persona(nombre, edad);
                    // Y aqui se guarda en el fichero binario
                    persona.escribirPersonas(ruta);
                }
            } catch (NumberFormatException e) {
                // Si el usuario introduce letras en vez de numeros en la edad, se lanza una excepcion
                System.out.println("Error: La edad debe ser un número entero.");
            }
        }
        // Cerramos el scanner para que no se quede abierto y se quede colgado el programa
        teclado.close();
        // Y aqui se muestran las personas almacenadas en el fichero binario
        Persona.mostrarPersonas(ruta);

        // En resumen, primero hemos creado un fichero binario llamado personas.bin
        // Luego hemos creado una clase Persona con los atributos nombre y edad
        // Despues hemos creado un metodo para escribir las personas en el fichero binario
        // Luego lo almacenamos en el fichero binario con el metodo escribirPersonas
        // Y por ultimo hemos creado un metodo para mostrar las personas almacenadas en el fichero binario
        // Cada vez que ejecuto el programa me sale error y tengo que borrar personas.bin y volver a ejecutar el programa
        
         /* Would be nice if i had a way to automatically make personas1.bin, personas2.bin,etc
         Sample method to automate file creation would probably be something like:
         String ruta = "PracticarBinario/Personas/personas" + i + ".bin";
         and then increment i each time the program is run by using i++ inside a loop
         the loop we need is a while loop, and the loop will run until the user decides to stop it by typing "salir" */
    }
}
