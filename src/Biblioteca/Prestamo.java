// Prestamo.java
package Biblioteca;

import java.time.LocalDate;

public class Prestamo {
    public Libro libroPrestado;
    private Usuario usuarioPrestamo;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    public final int DIASPRESTAMO = 7;

    public Prestamo() {
        this.fechaPrestamo = null;
        this.fechaDevolucion = null;
        this.libroPrestado = null;
        this.usuarioPrestamo = null;
    }

    public void registrarPrestamo(Libro libroPrestamo, Usuario usuario) {
        if (libroPrestamo.estaDisponible()) {
            this.libroPrestado = libroPrestamo;
            this.usuarioPrestamo = usuario;
            this.fechaPrestamo = LocalDate.now();
            this.fechaDevolucion = fechaPrestamo.plusDays(DIASPRESTAMO);
            libroPrestamo.cantidadLibros--;
            System.out.println("Préstamo registrado: " + libroPrestamo.nombre + ". Fecha de devolución: " + fechaDevolucion);
        } else {
            System.out.println("El libro " + libroPrestamo.nombre + " no está disponible para préstamo.");
        }
    }

    public void registrarDevolucion(Usuario usuario) {
        if (this.libroPrestado != null && this.usuarioPrestamo != null) {
            if (this.usuarioPrestamo.equals(usuario)) {
                this.libroPrestado.cantidadLibros++;
                System.out.println("Devolución registrada: " + this.libroPrestado.nombre);
                this.libroPrestado = null;  // Libera el libro de este préstamo
                this.usuarioPrestamo = null; // Libera el usuario asociado
                this.fechaPrestamo = null;
                this.fechaDevolucion = null;
            } else {
                System.out.println("El usuario no coincide con el préstamo registrado.");
            }
        } else {
            System.out.println("No hay ningún libro prestado para devolver.");
        }
    }
    
    public void registrarDevolucion(Libro libroDevolver) {
        if (this.libroPrestado != null && this.libroPrestado.equals(libroDevolver)) {
            libroDevolver.cantidadLibros++;
            System.out.println("El libro " + libroDevolver.nombre + " ha sido devuelto correctamente.");
            limpiarPrestamo();
        } else {
            System.out.println("El libro proporcionado no corresponde a este préstamo o no se ha registrado ningún préstamo.");
        }
    }

    private void limpiarPrestamo() {
        this.libroPrestado = null;
        this.usuarioPrestamo = null;
        this.fechaPrestamo = null;
        this.fechaDevolucion = null;
    }
}
