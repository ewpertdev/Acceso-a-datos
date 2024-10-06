/* Se quiere guardar todos los datos de los libros de una librería los atributos que
se almacenan son los siguientes título, autor y precio.Se debe crear una clase
que se llame libros y que contenga los atributos mencionados. El programa
debe permitir insertar libros, listar libros, ordenar los libros según su precio y
filtrar por rango de precio. */

// Paso por paso:

// 1. Crear la clase Libros con los atributos título, autor y precio.
// 2. Crear un método para insertar libros.
// 3. Crear un método para listar libros.
// 4. Crear un método para ordenar los libros según su precio.
// 5. Crear un método para filtrar por rango de precio.

// Paso 1: Crear la clase Libros con los atributos título, autor y precio.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Libro {
    // Atributos de la clase Libro
    // private es para que no se pueda acceder a los atributos desde fuera de la clase, esto es para encapsular, es importante para la seguridad del codigo
    private String titulo;
    private String autor;
    private double precio;
    // La clase Libro tambien tiene una lista de libros, esto es para que el usuario pueda insertar varios libros
    // El sintaxis tipico de List<Libro> libros; es para crear una lista de objetos Libro, su sintaxis es List<TipoDeDato> nombreDeLaLista; 
    // El TipoDeDato en este caso es la clase Libro porque la lista de libros es una lista de objetos Libro
    private List<Libro> libros;

    // Constructor de la clase Libro, se crea para inicializar los atributos de la clase porque
    // el constructor es el primero en ejecutarse cuando se crea un objeto de la clase
    // el constructor se encarga de crear el objeto y asignarle los valores iniciales a los atributos
    // el constructor no tiene tipo de dato de retorno porque no retorna nada, es decir, no devuelve nada
    // el constructor se llama igual que la clase
    public Libro() {
        // this significa que estamos llamando a los atributos de la clase
        //.libros es una lista de objetos Libro
        // new ArrayList<>() crea una nueva lista de objetos Libro
        // basicamente lo que estamos haciendo es crear una lista de objetos Libro
        // tambien podemos no poner this.libros = new ArrayList<>(); y directamente poner libros = new ArrayList<>();
        // esto es porque libros es una lista de objetos Libro y estamos llamando a la lista de la clase
        // libros es simplemente el nombre que damos a la lista de objetos Libro, es como si fuera un "alias"
        this.libros = new ArrayList<>();
    }

    // Getters y Setters para los atributos
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

    // Paso 2: Crear un método para insertar libros.
    // El parametro siempre tiene que tener este formato: (TipoDeDato nombreDelParametro)
    // En este caso, el parametro es un objeto de la clase Libro
    // Su TipoDeDato es Libro que es la clase que estamos definiendo
    // Su nombreDelParametro es libro que es el objeto que vamos a insertar en la lista
    // No podemos dejar vacio el parametro porque no sabemos que es lo que va a insertar el usuario
    public void insertarLibro(Libro libro) {
        // libro viene de la clase main
        // libros es el objeto que hemos creado en el constructor de la clase
        libros.add(libro);
    }
    // Paso 3: Crear un método para listar libros.
    // El parentesis () significa que no tiene parametros porque no recibe nada
    // La razon por la que no recibe parametros es porque ya tenemos la lista de libros en la clase
    public void listarLibros() {
        // el bucle for each es para recorrer la lista de libros
        // for (TipoDeDato nombreDelParametro : nombreDeLaLista) {
        //     // codigo a ejecutar
        // }
        // Se lee asi: para cada libro en la lista de libros, ejecuta el codigo
        for (Libro libro : libros) {
            // Cogemos el titulo, autor y precio de cada libro y lo mostramos
            System.out.println(
                    "Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor() + ", Precio: " + libro.getPrecio());
            System.out.println("----------------------------------------");
            
        }
    }

    // Paso 4: Crear un método para ordenar los libros según su precio.
    public void ordenarPorPrecio() {
        // Vamos a hacer un método sencillo usando codigo sencillo sin sort
        // Lo que hacemos es recorrer la lista de libros y ordenarlos por precio
        // No usaremos collections.sort porque no es lo que nos pide el ejercicio
        // Usaremos un bucle for para ordenar los libros por precio
        // Usamos dos bucles for para que el precio mas barato quede al principio y el mas caro al final, esto es para que quede ordenado
        // El primer for es para recorrer la lista de libros
        // El segundo for es para comparar el precio de cada libro con el siguiente
        // Si el precio del libro i es mayor que el precio del libro j, intercambiamos los libros
        // Usamos un objeto temporal para que el precio del libro i sea el precio del libro j y viceversa, 
        // esto es para que no se pierde el precio del libro i porque si no, se pierde
        // El primer for (int i = 0; i < libros.size(); i++) se lee asi: para i desde 0 hasta el tamaño de la lista de libros, ejecuta el codigo
        // ponemos i = 0 porque queremos empezar desde el primer libro
        // libros.size() es el tamaño de la lista de libros, .size es un metodo de la clase List
        // ponemos i++ porque queremos que vaya pasando al siguiente libro
        for (int i = 0; i < libros.size(); i++) {
            // El segundo for (int j = i + 1; j < libros.size(); j++) se lee asi: 
            // para j desde i + 1 hasta el tamaño de la lista de libros, ejecuta el codigo, pongo i + 1 porque el +1 lo que hace es que el segundo for 
            // empiece desde el siguiente libro despues de i, es decir, si i es 0, j sera 1, si i es 1, j sera 2, y asi sucesivamente
            // El segundo for se mete dentro del primer for para que compare el precio de cada libro con el siguiente, lo hacemos por que queremos ordenar los libros por precio
            // El segundo for se ejecuta siempre y cuando j sea menor que el tamaño de la lista de libros, esto es para que no se salga de la lista de libros
            for (int j = i + 1; j < libros.size(); j++) {
                // Si el precio del libro i es mayor que el precio del libro j, intercambiamos los libros
                if (libros.get(i).getPrecio() > libros.get(j).getPrecio()) {
                    // Usamos un objeto temporal para que el precio del libro i sea el precio del libro j y viceversa, 
                    // esto es para que no se pierde el precio del libro i porque si no, se pierde, es decir, 
                    // si no ponemos esto, cuando intercambiamos los libros, el precio del libro i se pierde, 
                    // esto se debe a que la lista se sobreescribe cada vez que se intercambia
                    // Libro temp = libros.get(i); se lee asi: creamos un objeto temporal de la clase Libro y le asignamos el valor de la lista de libros en la posicion i
                    Libro temp = libros.get(i);
                    // Usamos el metodo set para que el precio del libro i sea el precio del libro j
                    libros.set(i, libros.get(j));
                    // Uso el metodo set para que el precio del libro j sea el precio del libro i, el temp es el precio del libro i ya que lo hemos guardado en el objeto temp
                    libros.set(j, temp);

                    // Otra forma sencilla de hacer el metodo de ordenar por precio es usando el metodo sort de la clase Collections
                    // Collections.sort(libros, new Comparator<Libro>() {
                    //     public int compare(Libro l1, Libro l2) {
                    //         return Double.compare(l1.getPrecio(), l2.getPrecio());
                    //     }
                    // });
                }
            }
        }
    }

    // Paso 5: Crear un método para filtrar por rango de precio.
    // El parametro siempre tiene que tener este formato: (TipoDeDato nombreDelParametro)
    // En este caso, el parametro es un double
    // Su TipoDeDato es double
    // Su nombreDelParametro es precioMin y precioMax
    // No podemos dejar vacio el parametro porque no sabemos que es lo que va a filtrar el usuario
    // Por qué podemos poner dos parametros si solo queremos un rango de precio?
    // Porque el usuario puede querer filtrar por un rango de precio y otro rango de precio distinto
    // Entonces ponemos dos parametros para que el usuario pueda filtrar por dos rangos de precio
    public void filtrarPorRangoPrecio(double precioMin, double precioMax) {
        // Vamos a crear el metodo de filtrar por rango de precio pero de forma mas sencilla sin stream
        // Lo que hacemos es recorrer la lista de libros y mostrar los que cumplen con la condicion
        System.out.println("Libros filtrados por rango de precio: " + precioMin + " - " + precioMax);
        for (Libro libro : libros) { // Para cada libro en la lista de libros
            // Si el precio del libro es mayor o igual que el precio minimo y menor o igual que el precio maximo
            if (libro.getPrecio() >= precioMin && libro.getPrecio() <= precioMax) {
                // Mostramos el titulo, autor y precio del libro
                System.out.println("Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor() + ", Precio: " + libro.getPrecio());
                System.out.println("----------------------------------------");
            }
        }
    }
    // Ahora probamos el programa con la entrada del usuario
    // el usuario introduce el nombre del libro, el autor, el precio
    // pueden seguir insertando varios libros asi hasta que decida terminar
    // cuando termina de insertar libros, el programa pregunta si quiere ordenar los libros por precio y filtrar por rango de precio
    // el usuario tambien puede decidir no hacerlo y terminar el programa
    // lo vamos a hacer de forma muy simple, haciendo llamadas a los metodos ya creados
    public static void main(String[] args) {
        // Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        // Crear un objeto Libro para almacenar los libros
        Libro libreria = new Libro();
        // Bucle para que el usuario pueda insertar libros y tambien terminar el programa
        while (true) {
            // Menu para insertar libros
            // Preguntamos al usuario si quiere insertar un libro o terminar el programa, esto ocurre cada vez que
            // lo hacemos asi para que no se repita el bucle infinitamente
            System.out.println("Introduce el título del libro o 'salir' para terminar: ");
            String titulo = scanner.nextLine();
            if (titulo.equalsIgnoreCase("salir")) {
                break;
            }
            // Pedimos al usuario el autor del libro
            System.out.println("Introduce el autor del libro: ");
            String autor = scanner.nextLine();
            // Pedimos al usuario el precio del libro
            System.out.println("Introduce el precio del libro: ");
            double precio = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer del scanner
            // Creamos un objeto Libro con los datos introducidos por el usuario y lo agregamos a la libreria
            Libro libro = new Libro();
            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setPrecio(precio);
            libreria.insertarLibro(libro);

            // Preguntamos al usuario si quiere continuar insertando libros o terminar el programa
            System.out.println("¿Quieres continuar insertando libros? (s/n)");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("n")) {
                break;
            }
        }
        // Mostramos los libros ingresados
        libreria.listarLibros();
        // Preguntamos al usuario si quiere ordenar los libros por precio, llama al metodo ordenarPorPrecio
        System.out.println("¿Quieres ordenar los libros por precio? (s/n)");
        String respuesta2 = scanner.nextLine();
        if (respuesta2.equalsIgnoreCase("s")) {
            libreria.ordenarPorPrecio();
            System.out.println("Libros ordenados por precio");
            libreria.listarLibros();
        }
        // Preguntamos al usuario si quiere filtrar por rango de precio, llama al metodo filtrarPorRangoPrecio
        System.out.println("¿Quieres filtrar por rango de precio? (s/n)");
        String respuesta3 = scanner.nextLine();
        if (respuesta3.equalsIgnoreCase("s")) {
            System.out.println("Introduce el precio mínimo: ");
            double precioMin = scanner.nextDouble();
            System.out.println("Introduce el precio máximo: ");
            double precioMax = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer del scanner
            libreria.filtrarPorRangoPrecio(precioMin, precioMax);
        }
        // Terminamos el programa
        System.out.println("Programa terminado");
        scanner.close();
    }
}

// En general, la parte más dificil de este ejercicio ha sido crear el metodo de ordenar precio y filtrar por precio
