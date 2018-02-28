/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lalibreria;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author conve
 */
public class Sesion {
    private ArrayList<Libro> catalogo;

    public Sesion() {
    }

    public Sesion(ArrayList<Libro> catalogo) {
        this.catalogo = catalogo;
    }

    public ArrayList<Libro> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(ArrayList<Libro> catalogo) {
        this.catalogo = catalogo;
    }
    
    public void guardarCatalogo() throws FileNotFoundException, IOException{ //Metodo para guardar un catalogo de libros
        System.out.println("Escribe un nombre del archivo destino"); // Se pregunta le nombre del archivo al usuario
        Scanner scanner = new Scanner(System.in); // Se crea un objeto de la clase scannner
        String nombreArchivo = scanner.nextLine(); // Se lee el nombre del archivo
        FileOutputStream escritor = new FileOutputStream(nombreArchivo);//Crear un flujo de salida
        ObjectOutputStream salida = new ObjectOutputStream(escritor); //Flkujo para poder escribir el objeto
        salida.writeObject(catalogo); // Se escribe el objeto catalogo
        salida.close(); // Se cierra el flujo
    }
    
    public ArrayList<Libro> cargarCatalogo() throws FileNotFoundException, IOException, ClassNotFoundException{ //Metodo para guardar un catalogo de libros
        System.out.println("Escribe un nombre del archivo de origen"); // Se pregunta le nombre del archivo a leer
        Scanner scanner = new Scanner(System.in); // Se crea un objeto de la clase scannner
        String nombreArchivo = scanner.nextLine(); // Se lee el nombre del archivo
        FileInputStream lector = new FileInputStream(nombreArchivo);//Crear un flujo de salida
        ObjectInputStream entrada = new ObjectInputStream(lector); //Flkujo para poder escribir el objeto
        ArrayList<Libro> lista = (ArrayList<Libro>)entrada.readObject(); //Se crea un lista para poder meter el objeto de libros
        return lista;
    }
}
