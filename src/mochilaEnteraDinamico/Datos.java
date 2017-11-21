/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilaEnteraDinamico;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Belmont
 */
public class Datos {
     public ArrayList<Item> articulos;
     private int nitems;
     private int valorMax;
     private int pesoMax;
     
     public Datos(int n , int valor , int peso){
         this.nitems=n;
         this.valorMax=valor;
         this.pesoMax=peso;
     }
     public ArrayList<Item> calcularValores()
     {
         articulos = new ArrayList<>();
         double [] peso = new double[nitems];
         double [] valor = new double[nitems];
         //calcular pesos y valores
       for (int x=0;x<nitems;x++)
       {
        peso[x] = ThreadLocalRandom.current().nextInt(0, pesoMax);
        valor[x] = ThreadLocalRandom.current().nextInt(0, valorMax);       
       }
       //agregar los articulos a la coleccion
       for(int y = 0 ; y<nitems;y++)
       {
           articulos.add(new Item(y,valor[y],peso[y]));
       }
       return articulos;
     }
}
