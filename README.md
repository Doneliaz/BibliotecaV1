## Crear una biblioteca la cual permita añadir libros , prestar libros , y devolver libro
-La aplicacion permite recibir un usuario y contraseña
-El sistema valida el ingreso de sesion 
-En caso de tener permisos de administracion el usuario ingresa con su contraseña y usuario predeterminado

# Ejemplo:

"Bienvenido a la biblioteca , registra tu id y contraseña: "

"Actualmente tienes agregados %librosPrestados libros"

"Para devolver el libro presiona 1), para pedir prestado un libro presiona 2)"

# Sistema de Gestión de Biblioteca
Crea clases para representar <libros, usuarios y préstamos>.
Un libro debe tener atributos como <título, autor, ISBN, y estado (disponible o prestado)>.
Un usuario debe tener atributos como <nombre, número de identificación y una lista de libros prestados>.
Implementa métodos para permitir que los usuarios tomen prestados y devuelvan libros, actualizando el estado del libro.