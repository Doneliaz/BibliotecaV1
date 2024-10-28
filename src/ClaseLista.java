class Nodo{
    private String nombreLibro;
    private String nombreAutor;
    private int ISBN;
    private String nombreUsuario;
    private int IdUsuario;
    private int listaLibros;

    private Nodo siguiente;

public Nodo (int ISBN, String autor, String titulo,  Nodo sig){
    this.nombreLibro = titulo;
    this.nombreAutor = autor;
    this.ISBN = ISBN;

    siguiente = sig;
}

public Nodo (int IdUsuario, String nomUsuario, int librosPrestados, Nodo sig){
    this.IdUsuario = IdUsuario;
    this.nombreUsuario = nomUsuario;
    this.listaLibros = librosPrestados;
    
    siguiente = sig;
}

public int getLibros(){
        System.out.println("El titulo del libro es: " + nombreLibro);
        System.out.println("El autor es: " + nombreAutor);
        System.out.println("El ISBN es: " + ISBN);
    return 0 ;
}
public Nodo getSig(){
    return siguiente;
}
public void setElemento(int elem){
    }
public void setSig(Nodo sig){
    siguiente = sig;
}
    
}

class listaSimple{
    private Nodo primero;
    private int numElem; 
public listaSimple(){ 
    primero = null;
    numElem = 0;
}

public void insertarPrimero (int elemento){
    //Nodo nuevo = new Nodo (elemento, primero);
    primero = nuevo;
    numElem++;
}

public void insertarFinal (int elemento){ 
    //Nodo nuevo = new Nodo(elemento, null);
    if (primero == null){
    primero = nuevo;
    }
    else {
        Nodo actual = primero;
        while (actual.getSig()!= null){
            actual = actual.getSig();
            
        }
        actual.setSig(nuevo);
        numElem++;
    }
System.out.println("Final");
}
public void borrar (int elem){
    if (primero == null) 
        System.out.println("lista vacía");
    else
        if (primero.getElemento()== elem){
        primero = primero.getSig();
        numElem--;
        }
        else {
            Nodo actual = primero;
            while (actual.getSig()!=null && actual.getSig().getElemento() != elem)
                actual = actual.getSig();
                if (actual.getSig()== null )
                    System.out.println ("elemento "+elem+" no esta en la lista");
                else{
                    actual.setSig(actual.getSig().getSig());
                    numElem--;
                }
        }
} 
public void listar(){
    
    Nodo actual = primero;
    while (actual.getSig()!= null){
        System.out.println(actual.getElemento());
        actual = actual.getSig();
    
    }
    System.out.println(actual.getElemento());
}
}
