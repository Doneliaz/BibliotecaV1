public class Usuario extends Biblioteca {
    private String nombre;
    private int IdUsuario;
    public Nodo librosPrestados;

    public Usuario(String nombre, int usuario){
        this.IdUsuario = usuario;
        this.nombre = nombre;
        Biblioteca.usuariosRegistrados;
        
    }

    

    public void obtenerListaLibros(){
        librosPrestados.getLibros();
    }
    
    
}
