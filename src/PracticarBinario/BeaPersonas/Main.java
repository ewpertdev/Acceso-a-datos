package PracticarBinario.BeaPersonas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void escribirPersonas(List<Persona> p, String ruta){

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(ruta)));
            oos.writeObject(p);
            System.out.println("Las personas han sido guardadas");
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static List <Persona> leerPersonas(String ruta){
        List <Persona> personas = new ArrayList<>();

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(ruta)));
            personas = (List <Persona>)ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return personas;


    }
    public static void main(String[] args){
        String nombre ="";
        String ruta ="ficheroPersonas.bin";
        int edad;
        List<Persona> personas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce los datos de las personas");

        int opcion=1;
        while(opcion!=0) {
            // Pedir todos los datos
            System.out.println("Introduce el nombre");
            nombre=sc.nextLine();
            System.out.println("Introduce la edad");
            edad=sc.nextInt();
//            Persona personax= new Persona(nombre, edad);
//            personas.add(personax);
            personas.add(new Persona(nombre,edad));

            System.out.println("Continue? (0 para salir, cualquier otro número para seguir");
            opcion=sc.nextInt();

        }
        sc.close();
        // Haremos la llamada a escribir el array en el fichero
        escribirPersonas(personas, ruta);
        List <Persona> personasLeidas = leerPersonas(ruta);
        for(Persona p:personasLeidas) {

        }
    }
}
