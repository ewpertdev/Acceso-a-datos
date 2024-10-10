package BeaMenuPersonas;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private int id;
    private String nombre;
    private double nota;

    private List<Estudiante> estudiantes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Estudiante(int id, String nombre, double nota, List<Estudiante> estudiantes) {
        this.id = id;
        this.nombre = nombre;
        this.nota = nota;
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "Estudiante [id=" + id + ", nombre=" + nombre + ", nota=" + nota + ", estudiantes=" + estudiantes + "]";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
}
