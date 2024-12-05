import java.util.ArrayList;

public class Libro {
    //Variables de Instancia
    private String autor;
    private String nombre;
    private int ISBN;
    private boolean estado;
    //Variables de la clase
    public  static ArrayList libros = new ArrayList<Libro>();

    public Libro(String autor, String nombre, int ISBN){
        this.ISBN = ISBN;
        this.autor = autor;
        this.nombre = nombre;    
    }  
    


}
