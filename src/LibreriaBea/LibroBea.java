package LibreriaBea;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LibroBea implements Serializable {
    private String titulo;
    private String autor;
    private double precio;

    private List<LibroBea>librosBeas;

    // Constructor
    public LibroBea() {
        this.librosBeas = new ArrayList<>();

    }
    // Getters and setters
    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getAutor(){
        return autor;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }

    public void insertarLibros (LibroBea libroBea){
        librosBeas.add(libroBea);
    }

    public void ordenarLibrosPorPrecio(){
        Collections.sort(librosBeas, Comparator.comparingDouble(LibroBea::getPrecio);

    }

    public List<LibroBea> filtrarLibrosPorPrecio(double minimo, double maximo){
        List <LibroBea> librosFiltrados = new ArrayList<>();

        for(LibroBea libroBea:librosBeas) {
            if((libroBea.getPrecio()>=minimo) && (libroBea.getPrecio()<=maximo)){
                librosFiltrados.add(libroBea);
            }
        }
        return librosFiltrados;
    }
    
}

    

