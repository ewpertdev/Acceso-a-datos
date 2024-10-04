package PracticarBinario.Libreria;

import java.util.*;

public class Libros implements Collection<Libros> {
    protected String titulo;

    public Libros(String titulo, String autor, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }

    protected String autor;
    protected double precio;
    Scanner sc = new Scanner(System.in);

    public Libros() {
        super();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }


    @Override
    public String toString() {
        return "Libros{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Libros> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Libros libros) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Libros> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
    public static void main(String[] args) {
        List<Libros> libros = new ArrayList<>();
        // Insertar libros
        libros.add(new Libros("El señor de los anillos", "J.R.R. Tolkien", 100.0));
        libros.add(new Libros("Harry Potter y la piedra filosofal", "J.K. Rowling", 150.0));
        libros.add(new Libros("1984", "George Orwell", 200.0));
        // Listar libros
        for (Libros libro : libros) {
            System.out.println(libro);
        }
        // Ordenar libros (filtrado por precio, incr, decr)
        // Filtro rango de precios




    }
}
