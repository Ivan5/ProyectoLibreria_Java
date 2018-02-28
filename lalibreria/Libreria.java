/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lalibreria;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Ivan Jaramillo
 */
public class Libreria {
    private ArrayList<Libro> libros;//Arraylist de libros
    private String nombre;

    public Libreria() {
    }

    public Libreria(ArrayList<Libro> libros, String nombre) {
        this.libros = libros;
        this.nombre = nombre;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void addLibro(String isbn, String titulo,String autor,double precio){
        Libro libro1 = new Libro(isbn,titulo,autor,precio);//Instaciar un nuevo libro
        libros.add(libro1); //Añadir al arraylist el libro nuevo
    }
    
    public void imprimirCatalogoLibros() throws IOException{
        System.out.println("Deseas guardar el catalogo en un archivo de texto? S/N");//Preguntar si se quire guardar en un archivo
        Scanner input = new Scanner(System.in); //Instaciamos un objeto de la clase scannner para poder recibir por consola
        String respuesta = input.nextLine();///Leer la respuesta del usuario y almacenarlo en la variable respuesta
        if(respuesta.compareToIgnoreCase("s") == 0){//Si la respuesta es si
            System.out.println("Escribe el nombre del archivo");//pedir el nombre del archivo a guardar
            String nombreArchivo = input.nextLine(); //SE lee el nombre del archivo
            FileWriter escribir = new FileWriter(nombreArchivo);// Instanciar un objeto de la clase FileWriter y pasar el nombre del archivo
            PrintWriter pw = new PrintWriter(escribir); // Se prepara el archivo para poder escribir es el conducto
            
            Iterator<Libro> iterador = libros.iterator(); // Crear un iterador para los libros 
            while(iterador.hasNext()){ // Se comprueba que haya objectos Libro en el array
                Libro libro = iterador.next(); // Se crea un objeto de la clase libro y se asigna la informacion recuperada
                libro.imprime(pw); // Se llama el metodo para imprmir en el archivo 
            }
            pw.close(); //Cerrar el conducto 
        }
        /*Visualizar la informacion por pantalla*/
        Iterator<Libro> iterador = libros.iterator(); // Crear un iterador para los libros 
            while(iterador.hasNext()){ // Se comprueba que haya objectos Libro en el array
                Libro libro = iterador.next(); // Se crea un objeto de la clase libro y se asigna la informacion recuperada
                libro.imprime(); // Se llama el metodo para imprmir een pantalla
            }
    }
    
    public Libro borrarLibro(String isbn){ //Metodo para borrar un libro del almacen, se necesita el isbn que es el identificador
        boolean encontrado = false;/// Variable para ver si a sido encontrado o no
        Iterator<Libro> iterador = libros.iterator(); // Crear un iterador para los libros 
            while((iterador.hasNext()) &&(encontrado == false) ){ // Se comprueba que haya objectos Libro en el array o que no haya sido encontrado aun el libro
                Libro libro = iterador.next(); // Se crea un objeto de la clase libro y se asigna la informacion recuperada
                if(libro.getIsbn().compareToIgnoreCase(isbn) == 0){ // Se comprar el isb del libro con el que se quiere eliminar
                    encontrado = true;// Se actualiza la variable encontrado para que salga del ciclo
                    return libro; // se regresa el libro que sera eliminado
                }
            }
            return null;
    }
    
    public ArrayList<Libro> filtrarPorAutor(String autor) throws IOException{ //Metodo para filtrar los libros por autor
        ArrayList<Libro> subLista = new ArrayList<Libro>(); //Se crea un sublista para guardar los libros filtrados
        Iterator<Libro> iterador = libros.iterator(); // Crear un iterador para los libros 
            while(iterador.hasNext()){ // Se comprueba que haya objectos Libro en el array
                Libro libro = iterador.next(); // Se crea un objeto de la clase libro y se asigna la informacion recuperada
                if(libro.getAutor().compareToIgnoreCase(autor) == 0){ // Ver si el libro es del autor que estamos buscando
                    subLista.add(libro); //Si corresponde lo añadimos a la sublista
                }
            }
            System.out.println("Deseas guardar el catalogo de los libros encontrados en un archivo de texto? S/N");//Preguntar si se quire guardar en un archivo
            Scanner input = new Scanner(System.in); //Instaciamos un objeto de la clase scannner para poder recibir por consola
            String respuesta = input.nextLine();///Leer la respuesta del usuario y almacenarlo en la variable respuesta
            if(respuesta.compareToIgnoreCase("s") == 0){//Si la respuesta es si
                System.out.println("Escribe el nombre del archivo");//pedir el nombre del archivo a guardar
                String nombreArchivo = input.nextLine(); //SE lee el nombre del archivo
                FileWriter escribir = new FileWriter(nombreArchivo);// Instanciar un objeto de la clase FileWriter y pasar el nombre del archivo
                PrintWriter pw = new PrintWriter(escribir); // Se prepara el archivo para poder escribir es el conducto

                Iterator<Libro> iterador1 = subLista.iterator(); // Crear un iterador para la sublista de libros 
                while(iterador1.hasNext()){ // Se comprueba que haya objectos Libro en el array
                    Libro libro = iterador1.next(); // Se crea un objeto de la clase libro y se asigna la informacion recuperada
                    libro.imprime(pw); // Se llama el metodo para imprmir en el archivo 
                }
                pw.close(); //Cerrar el conducto 
            }
            Iterator<Libro> iterador2 = subLista.iterator(); // Crear un iterador para la sublkista de libros 
            while(iterador2.hasNext()){ // Se comprueba que haya objectos Libro en el array
                Libro libro = iterador2.next(); // Se crea un objeto de la clase libro y se asigna la informacion recuperada
                libro.imprime(); // Se llama el metodo para imprmir een pantalla
            }
            return subLista; // Regresar la sublista con los libros encontrados del autor
    }
    
    public ArrayList<Libro> filtrarPorPrecio(double precioMaximo) throws IOException{ //Metodo para filtrar los libros por un rango precio deseado
        ArrayList<Libro> subLista = new ArrayList<Libro>(); //Se crea un sublista para guardar los libros filtrados
        Iterator<Libro> iterador = libros.iterator(); // Crear un iterador para los libros 
            while(iterador.hasNext()){ // Se comprueba que haya objectos Libro en el array
                Libro libro = iterador.next(); // Se crea un objeto de la clase libro y se asigna la informacion recuperada
                if(libro.getPrecio() <= precioMaximo){ // Ver si el libro es del precio o menor del precio especificado
                    subLista.add(libro); //Si corresponde lo añadimos a la sublista
                }
            }
            System.out.println("Deseas guardar el catalogo de los libros encontrados en un archivo de texto? S/N");//Preguntar si se quire guardar en un archivo
            Scanner input = new Scanner(System.in); //Instaciamos un objeto de la clase scannner para poder recibir por consola
            String respuesta = input.nextLine();///Leer la respuesta del usuario y almacenarlo en la variable respuesta
            if(respuesta.compareToIgnoreCase("s") == 0){//Si la respuesta es si
                System.out.println("Escribe el nombre del archivo");//pedir el nombre del archivo a guardar
                String nombreArchivo = input.nextLine(); //SE lee el nombre del archivo
                FileWriter escribir = new FileWriter(nombreArchivo);// Instanciar un objeto de la clase FileWriter y pasar el nombre del archivo
                PrintWriter pw = new PrintWriter(escribir); // Se prepara el archivo para poder escribir es el conducto

                Iterator<Libro> iterador1 = subLista.iterator(); // Crear un iterador para la sublista de libros 
                while(iterador1.hasNext()){ // Se comprueba que haya objectos Libro en el array
                    Libro libro = iterador1.next(); // Se crea un objeto de la clase libro y se asigna la informacion recuperada
                    libro.imprime(pw); // Se llama el metodo para imprmir en el archivo 
                }
                pw.close(); //Cerrar el conducto 
            }
            Iterator<Libro> iterador2 = subLista.iterator(); // Crear un iterador para la sublkista de libros 
            while(iterador2.hasNext()){ // Se comprueba que haya objectos Libro en el array
                Libro libro = iterador2.next(); // Se crea un objeto de la clase libro y se asigna la informacion recuperada
                libro.imprime(); // Se llama el metodo para imprmir een pantalla
            }
            return subLista; // Regresar la sublista con los libros encontrados del autor
    }
}
