package MenuAlumnos;

// Se quiere guardar los datos de los alumnos con los atributos nombre, apelido y nota. 
// Se debe crear una clase que se lame alumnos y que permita dar de alta alumnos, insertar notas y filtrar quienes han suspendido y quienes han aprobado.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private List<Alumno> alumnos;
    private Scanner scanner;

    public StudentManager() {
        alumnos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\nMenú de Gestión de Alumnos:");
            System.out.println("1. Dar de alta un alumno");
            System.out.println("2. Insertar nota");
            System.out.println("3. Mostrar alumnos aprobados");
            System.out.println("4. Mostrar alumnos suspendidos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    darDeAltaAlumno();
                    break;
                case 2:
                    insertarNota();
                    break;
                case 3:
                    mostrarAlumnosAprobados();
                    break;
                case 4:
                    mostrarAlumnosSuspendidos();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    private void darDeAltaAlumno() {
        System.out.print("Ingrese el nombre del alumno: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del alumno: ");
        String apellido = scanner.nextLine();
        alumnos.add(new Alumno(nombre, apellido));
        System.out.println("Alumno dado de alta exitosamente.");
    }

    private void insertarNota() {
        System.out.print("Ingrese el nombre del alumno: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del alumno: ");
        String apellido = scanner.nextLine();

        Alumno alumno = buscarAlumno(nombre, apellido);
        if (alumno != null) {
            System.out.print("Ingrese la nota del alumno: ");
            double nota = scanner.nextDouble();
            alumno.setNota(nota);
            System.out.println("Nota insertada exitosamente.");
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    private void mostrarAlumnosAprobados() {
        System.out.println("Alumnos aprobados:");
        for (Alumno alumno : alumnos) {
            if (alumno.getNota() >= 5.0) {
                System.out.println(alumno);
            }
        }
    }

    private void mostrarAlumnosSuspendidos() {
        System.out.println("Alumnos suspendidos:");
        for (Alumno alumno : alumnos) {
            if (alumno.getNota() < 5.0) {
                System.out.println(alumno);
            }
        }
    }

    private Alumno buscarAlumno(String nombre, String apellido) {
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equalsIgnoreCase(nombre) && alumno.getApellido().equalsIgnoreCase(apellido)) {
                return alumno;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new StudentManager().run();
    }
}

class Alumno {
    private String nombre;
    private String apellido;
    private double nota;

    public Alumno(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota = -1; // Valor por defecto para indicar que no tiene nota asignada
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nota=" + (nota == -1 ? "No asignada" : nota) +
                '}';
    }
}
