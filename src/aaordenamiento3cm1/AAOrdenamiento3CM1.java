/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaordenamiento3cm1;

import Graficar.Graficar;
import algoritmos.*;
import herramientas.Comparador;
import herramientas.NumerosAleatorios;
import herramientas.Recursividad;
import java.util.ArrayList;

/**
 *
 * @author Roberto Cruz Leija
 */
public class AAOrdenamiento3CM1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

      double[] datos = NumerosAleatorios.generarDatosOrdenadosDesendentemente(10); //peor
      //double[] datos1 = NumerosAleatorios.generarDatosOrdenadosAsendendentes(10); //mejor
      //double [] datos2 = NumerosAleatorios.datos(10);

        System.out.println();

        ArrayList<Algoritmo> algoritmos = new ArrayList<>();
//        algoritmos.add(new Burbuja());
//        algoritmos.add(new BurbujaOptimizado());
        algoritmos.add(new InsertShort());
        algoritmos.add(new Seleccion());
        algoritmos.add(new RecursiveBinarySearch());
        algoritmos.add(new mergershort()); //mejor advanzado 
        //algoritmos.add(new QuickSort()); //mejor facil modificacion
        
        Comparador comparador = new Comparador(algoritmos, 10, 1000);
        comparador.compararAlgoritmos();
        System.out.println();
    }
   
}
