// Usuario.java
package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    // Variables de la instancia
    public String nombre;
    public String idUsuario;

    // Variables de la clase
    public ArrayList<Libro> librosPrestados = new ArrayList<>();

    public Usuario(String nombre, String idUsuario) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
    }

    public Usuario() {
        this.nombre = null;
        this.idUsuario = null;
    }

    public void solicitarLibro() {
        Prestamo prestamo = new Prestamo();
        Biblioteca biblioteca = new Biblioteca() {}; // Instancia anónima para acceder a métodos
        biblioteca.mostrarLibros();
        
        Scanner input = new Scanner(System.in);
        System.out.println("Seleccione el ISBN del libro que desea solicitar:");
        int ISBN = input.nextInt();

        for (Libro libro : Biblioteca.listaLibros) {
            if (libro.ISBN == ISBN && libro.estaDisponible()) {
                librosPrestados.add(libro);
                libro.cantidadLibros--;
                prestamo.registrarPrestamo(libro, this);
                return;
            }
        }
        System.out.println("No se encontró el libro o no está disponible.");
    }

    public String getUsuario() {
        return nombre;
    }
}

