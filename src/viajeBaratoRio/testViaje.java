/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viajeBaratoRio;

/**
 *
 * @author Belmont
 */
public class testViaje {
    public static void main(String[] args) {
            
        //double[][]tarifas = new double[][]{{0,9,6,11},{0,0,5,9},{0,0,0,5},{0,0,0,0}};
        viajeBaratoRio v = new viajeBaratoRio(1,2,4);
        v.generarTarifas();
        v.embarcaderos();
        v.imprimirMatriz();
        System.out.println("----------------------------");
        System.out.println("El costo es = "+v.menorRecorrido(1,3));

    System.out.println();
      
     }
}
