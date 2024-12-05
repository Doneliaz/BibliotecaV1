// Libro.java
package Biblioteca;

public class Libro {
    // Variables de Instancia
    private String autor;
    public String nombre;
    protected int ISBN;
    private boolean estado;
    protected int cantidadLibros;

    public Libro(String autor, String nombre, int ISBN, int cantidadLibros) {
        this.autor = autor;
        this.nombre = nombre;
        this.ISBN = ISBN;
        this.cantidadLibros = cantidadLibros;
        this.estado = cantidadLibros > 0;
    }

    public Libro() {
        this.autor = null;
        this.nombre = null;
        this.ISBN = 0;
        this.cantidadLibros = 0;
        this.estado = false;
    }

    public boolean estaDisponible() {
        return cantidadLibros > 0;
    }

    public void getLibro() {
        System.out.println("Libro: " + nombre + " | Autor: " + autor + " | ISBN: " + ISBN);
    }
}
