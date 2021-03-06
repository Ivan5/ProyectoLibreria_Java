/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lalibreria;

import java.io.PrintWriter;
import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *
 * @author Ivan JAramillo
 */
public class Libro implements Serializable{
    private String isbn;
    private String titulo;
    private String autor;
    private double precio;

    public Libro() {
    }

    public Libro(String isbn, String titulo, String autor, double precio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public void imprime(){
        DecimalFormat decimales = new DecimalFormat("00.00");
        System.out.println("ISB: "+this.isbn+" Titulo: "+this.titulo+" Autor: "+this.autor+" Precio: "+decimales.format(this.precio));
    }
    public void imprime(PrintWriter salida){
                DecimalFormat decimales = new DecimalFormat("00.00");

        salida.println("ISB: "+this.isbn+" Titulo: "+this.titulo+" Autor: "+this.autor+" Precio: "+decimales.format(this.precio));
    }
    
}
