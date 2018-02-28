/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lalibreria;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author conve
 */
public class GeneradorLibros {
    
    public ArrayList<Libro> generarLibros(int numeroLibros){
        ArrayList<Libro> resultado = new ArrayList<>();
        for(int i =0;i<numeroLibros;i++){
            Libro libro = new Libro(this.generarISBN(),this.generarTitulo(),this.generarAutor(),this.generarPrecio());
            resultado.add(libro);
        }
        return resultado;
    }
    public String generarISBN(){
        Random r = new Random();
        String resultado = "";
        for(int i =0;i<10;i++){
            if(i%3 == 0){
                resultado+="-";
            }
            resultado+=Integer.toString(r.nextInt(10));
        }
        
        return resultado;
    }
    
    public String generarAutor(){
        String resultado = "";
        Random r = new Random();
        String[] p1 ={"Antonio","Gloria","Joaquin","Mauricio"};
        String[] p2 = {"Fuentes","Fernandez","Garza","Perez","Gutierez"};
        
        resultado = p1[r.nextInt(p1.length)]+p2[r.nextInt(p2.length)];
        
        return resultado;
    }
    
     public String generarTitulo(){
        String resultado = "";
        Random r = new Random();
        String[] p1 ={"Sol","Amor","Luna","Francia"};
        String[] p2 = {"de","las","los","tus"};
        String[] p3 = {"Fuentes","Luces","Feliz","Turbia","Terreno"};
        
        resultado = p1[r.nextInt(p1.length)]+p2[r.nextInt(p2.length)]+p3[r.nextInt(p3.length)];
        
        return resultado;
    }
     
    public double generarPrecio(){
       Random r = new Random();
       return r.nextDouble()*100;

    }
}
