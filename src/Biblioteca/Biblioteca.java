// Biblioteca.java
package Biblioteca;

import java.util.ArrayList;

public abstract class Biblioteca {
    // Variables de la clase
    public static int librosRegistrados;
    public static int usuariosRegistrados;
    public static ArrayList<Libro> listaLibros = new ArrayList<>();
    public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public void registrarUsuario(String nombre, String idUsuario) {
        listaUsuarios.add(new Usuario(nombre, idUsuario));
        usuariosRegistrados++;
    }

    public void eliminarUsuario(String nombre) {
        listaUsuarios.removeIf(usuario -> usuario.nombre.equals(nombre));
    }

    public void registrarLibro(String autor, String nombre, int ISBN, int cantidadLibros) {
        listaLibros.add(new Libro(autor, nombre, ISBN, cantidadLibros));
        librosRegistrados++;
    }

    public void eliminarLibro(String nombre) {
        listaLibros.removeIf(libro -> libro.nombre.equals(nombre));
        librosRegistrados--;
    }

    public void mostrarLibros() {
        for (Libro libro : listaLibros) {
            libro.getLibro();
            System.out.println(libro.estaDisponible() ? "Disponible" : "No disponible");
        }
    }

    public void mostrarUsuarios() {
        for (Usuario usuario : listaUsuarios) {
            System.out.println("Usuario: " + usuario.getUsuario());
        }
    }
}

