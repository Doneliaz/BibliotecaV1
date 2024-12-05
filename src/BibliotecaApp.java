import java.util.Scanner;

import Biblioteca.Biblioteca;
import Biblioteca.Libro;
import Biblioteca.Prestamo;
import Biblioteca.Usuario;

public class BibliotecaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("--- Biblioteca ---");
            System.out.println("1. Registrar un libro");
            System.out.println("2. Registrar un usuario");
            System.out.println("3. Registrar préstamo");
            System.out.println("4. Registrar devolución");
            System.out.println("5. Mostrar libros disponibles");
            System.out.println("6. Mostrar usuarios registrados");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    registrarLibro(scanner);
                    break;
                case 2:
                    registrarUsuario(scanner);
                    break;
                case 3:
                    registrarPrestamo(scanner);
                    break;
                case 4:
                    registrarDevolucion(scanner);
                    break;
                case 5:
                    mostrarLibrosDisponibles();
                    break;
                case 6:
                    mostrarUsuariosRegistrados();
                    break;
                case 0:
                    running = false;
                    System.out.println("¡Gracias por usar la Biblioteca!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
    }

    private static void registrarLibro(Scanner scanner) {
        System.out.print("Ingrese el nombre del libro: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro: ");
        int isbn = scanner.nextInt();
        System.out.print("Ingrese la cantidad de libros: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        Libro libro = new Libro(autor, nombre, isbn, cantidad);
        Biblioteca.listaLibros.add(libro);
        System.out.println("Libro registrado con éxito.");
    }

    private static void registrarUsuario(Scanner scanner) {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el ID del usuario: ");
        String id = scanner.nextLine();

        Usuario usuario = new Usuario(nombre, id);
        Biblioteca.listaUsuarios.add(usuario);
        System.out.println("Usuario registrado con éxito.");
    }

    private static void registrarPrestamo(Scanner scanner) {
        System.out.print("Ingrese el ID del usuario: ");
        String idUsuario = scanner.nextLine();
        Usuario usuario = Biblioteca.listaUsuarios.stream()
            .filter(u -> u.idUsuario.equals(idUsuario))
            .findFirst()
            .orElse(null);

        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.print("Ingrese el nombre del libro: ");
        String nombreLibro = scanner.nextLine();
        Libro libro = Biblioteca.listaLibros.stream()
            .filter(l -> l.nombre.equals(nombreLibro) && l.estaDisponible())
            .findFirst()
            .orElse(null);

        if (libro == null) {
            System.out.println("Libro no disponible o no encontrado.");
            return;
        }

        Prestamo prestamo = new Prestamo();
        prestamo.registrarPrestamo(libro, usuario);
    }

    private static void registrarDevolucion(Scanner scanner) {
        System.out.print("Ingrese el nombre del libro a devolver: ");
        String nombreLibro = scanner.nextLine();
        Libro libro = Biblioteca.listaLibros.stream()
            .filter(l -> l.nombre.equals(nombreLibro))
            .findFirst()
            .orElse(null);

        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        Prestamo prestamo = new Prestamo(); // Crear una instancia temporal de Prestamo
        prestamo.registrarDevolucion(libro);
    }

    private static void mostrarLibrosDisponibles() {
        System.out.println("Libros disponibles:");
        Biblioteca.listaLibros.stream()
            .filter(Libro::estaDisponible)
            .forEach(libro -> System.out.println("- " + libro.nombre));
    }

    private static void mostrarUsuariosRegistrados() {
        System.out.println("Usuarios registrados:");
        Biblioteca.listaUsuarios.forEach(usuario -> System.out.println("- " + usuario.nombre + " (ID: " + usuario.idUsuario + ")"));
    }
}
