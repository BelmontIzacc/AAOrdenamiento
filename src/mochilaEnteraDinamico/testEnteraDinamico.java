/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilaEnteraDinamico;

import java.util.ArrayList;

/**
 *
 * @author Belmont
 */
public class testEnteraDinamico {
    public static void main(String[] args) {
         Datos d = new Datos(10,200,50);
         ArrayList<Item> articulos = d.calcularValores();
         mochilaEnteraDinamico md = new mochilaEnteraDinamico(articulos,7);
         md.buscarSolucion();

  System.out.println();
      
     }
}
