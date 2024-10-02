package Personas;

import java.io.*;
public class Persona implements Serializable {
    protected String nombre;
    protected int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void mostrarPersonas(String ruta) {
        try {
            File fichero = new File(ruta);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            Persona persona;
            while ((persona = (Persona) ois.readObject()) != null) {
                System.out.println(persona.getNombre() + " " + persona.getEdad());
            }
            ois.close();
        } catch (EOFException e) {
            // End of file reached, do nothing
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void escribirPersonas(String ruta) {
        try {
            File fichero = new File(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
            oos.writeObject(this);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
