package Personas;
// Crea un programa que pida datos de personas como el nombre y la edad.
//Para guardar estos datos se define una clase denominada persona y en un
//fichero binario se guardan varias instancias de la Persona. Después se debe
//crear una función que permita mostrar todas las personas que están
//almacenadas.

/* Paso por paso:
 * 1. Crear fichero binario llamado personas.bin
 * 2. Pedir datos de la persona (nombre y edad)
 * 3. Guardar varias instancias de la Persona en el fichero binario
 * 4. Mostrar las personas almacenadas en el fichero binario
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear nuevo fichero binario llamado personas.bin
        String ruta = "personas.bin";
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el nombre de la persona: ");
        String nombre = teclado.nextLine();
        System.out.println("Introduce la edad de la persona: ");
        int edad = teclado.nextInt();
        teclado.close();
        // Guardar varias instancias de la Persona en el fichero binario "personas.bin"
        Persona persona = new Persona(nombre, edad);
        persona.escribirPersonas(ruta);
        persona.mostrarPersonas(ruta);
    }
}
