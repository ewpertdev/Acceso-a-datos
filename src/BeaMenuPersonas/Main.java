package BeaMenuPersonas;

import java.io.IO;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    public static void escribirFicheroAleatorio(RandomAccessFile raf, int id, String nombre, double nota)throws IOException {
        raf.writeInt(id);
        raf.writeUTF(nombre);
        raf.writeDouble(nota);
    }
    public static void leerEstudianteFicheroAleatorio(RandomAccessFile raf, int id, String nombre, double nota) throws IOException{
        Estudiante e = new Estudiante(raf.readInt(),raf.readUTF(), raf.readDouble());



        return e;

    }
    public static void addEstudiante(String nombre, int id, double nota){
        try (RandomAccessFile raf = new RandomAccessFile(nombreFichero, "rw"){
            raf.seek(raf.length());
            escribirFicheroAleatorio(raf, id, nombre, nota);
            
        } catch (IOException e) {
            System.out.println("Error: al abrir fichero para estudiantes");
            e.printStackTrace();
        }

    }

    public static void listarEstudiantes(String nombreFichero){
        try (RandomAccessFile raf = new RandomAccessFile(nombreFichero, "r"){
            while(raf.getFilePointer() <raf.length()){
                Estudiante estudiante = leerEstudianteFicheroAleatorio(raf);
                System.out.println(estudiante);
                

            }

    } catch(IOException e){
        System.out.println("Error ");
        e.printStackTrace();

    }
    public static void buscarEstudiantePorID(String nombre, int id, double nota){
        try (RandomAccessFile raf = new RandomAccessFile(nombreFichero, "r"){
            while(raf.getFilePointer()< raf.length()){
                Estudiante estudiante = leerEstudianteFicheroAleatorio(id);
                if(estudiante.getId()==id){
                    return estudiante;
                } catch(IOException e){
                    e.printStackTrace();
                }
            }

    }
    public static void main(String[] args){
        String nombreFichero = "Estudiantes.dat"

        addEstudiante(nombreFichero, 1,"Dionisio", 10);

        Estudiante e = buscarEstudiantePorID(nombreFichero,2);
        if(e!=null){
            System.out.println("Se ha encontrado el estudiante");
        } else 
            System.out.println("No");


    }
    
}
