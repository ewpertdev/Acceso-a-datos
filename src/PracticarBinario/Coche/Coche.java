package PracticarBinario.Coche;

import java.io.*;

// Implementamos Serializable para que la clase Coche pueda ser serializada y deserializada
// Con Serializable, los objetos de la clase Coche se pueden convertir en una secuencia de bytes y viceversa
// Esto es necesario para que los objetos puedan ser escritos en un fichero binario y leidos desde un fichero binario
public class Coche implements Serializable {
    // Atributos de la clase Coche
    // Los atributos los declaramos como private para que no se puedan modificar desde fuera de la clase
    // Usamos los getters y setters para que se puedan modificar desde dentro de la clase
    // Usamos los constructores para que se puedan crear objetos de la clase Coche
    // Usamos los toString() para que se puedan mostrar los datos del coche
    // Usamos @Override para que sepa que estamos sobreescribiendo el metodo toString() de la clase Object, que es la clase padre de todas las clases en Java
    // Con String.format() formateamos la cadena de caracteres para que se vea mas claro
    // Podemos usar Generate para generar todo el codigo de los getters, setters, constructores y toString()
    private int numPuertas;
    private String marca;
    private String modelo;
    private int numeroCaballos;
    private int cilindrada;
    private double precio;

    // Constructor por defecto de la clase Coche, lo dejamos vacio para que no de error
    // Siempre hay que poner un constructor por defecto en las clases que implementan Serializable
    // Si no lo ponemos, al leer el fichero binario nos dara un error
    public Coche(){

    }

    // Getters y Setters de la clase Coche
    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumeroCaballos() {
        return numeroCaballos;
    }

    public void setNumeroCaballos(int numeroCaballos) {
        this.numeroCaballos = numeroCaballos;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Constructor de la clase Coche
    public Coche(int numPuertas, String marca, String modelo, int numeroCaballos, int cilindrada, double precio) {
        this.numPuertas = numPuertas;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroCaballos = numeroCaballos;
        this.cilindrada = cilindrada;
        this.precio = precio;
    }

    // Metodo para escribir los coches en el fichero binario, ponemos static para que no haga falta crear un objeto de la clase Coche para usar el metodo
    public static void escribirCoches(String ruta) {
        try {
            // Creamos un fichero en la ruta que le pasemos
            File fichero = new File(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));

            Coche c1 = new Coche(5, "Opel", "Astra", 500, 200, 20000);
            Coche c2 = new Coche(2, "Citroen", "c3", 100, 1900, 10000);

            oos.writeObject(c1);
            oos.writeObject(c2);
            oos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    // Metodo para leer los coches del fichero binario, ponemos static para que no haga falta crear un objeto de la clase Coche para usar el metodo
    public static void leerCoche(String ruta) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            Coche coche;
            while ((coche = (Coche) ois.readObject()) != null) {
                System.out.println(coche);
            }
        } catch (EOFException e) {
            // End of file reached, do nothing
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Metodo para mostrar los datos del coche
    // Ponemos @Override para que sepa que estamos sobreescribiendo el metodo toString() de la clase Object, que es la clase padre de todas las clases en Java
    // Con String.format() formateamos la cadena de caracteres para que se vea mas claro
    // Podemos usar Generate para generar el toString()
    @Override
    public String toString() {
        return String.format("Coche{numPuertas=%d, marca='%s', modelo='%s', numeroCaballos=%d, cilindrada=%d, precio=%.2f}",
                numPuertas, marca, modelo, numeroCaballos, cilindrada, precio);
    }
}



