package PracticarBinario;

import java.io.*;

public class Coche implements Serializable {
    private int numPuertas;
    private String marca;
    private String modelo;
    private int numeroCaballos;
    private int cilindrada;
    private double precio;

    public Coche(){

    }

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

    public Coche(int numPuertas, String marca, String modelo, int numeroCaballos, int cilindrada, double precio) {
        this.numPuertas = numPuertas;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroCaballos = numeroCaballos;
        this.cilindrada = cilindrada;
        this.precio = precio;
    }

    public void escribirCoches(String ruta) {
        try {
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
    public static void leerObjeto(String ruta) {
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

    @Override
    public String toString() {
        return String.format("Coche{numPuertas=%d, marca='%s', modelo='%s', numeroCaballos=%d, cilindrada=%d, precio=%.2f}",
                numPuertas, marca, modelo, numeroCaballos, cilindrada, precio);
    }
}



