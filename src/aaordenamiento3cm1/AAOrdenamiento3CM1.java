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

//        double[] datos = NumerosAleatorios.generarDatosOrdenadosDesendentemente(100); //peor
        double[] datos1 = NumerosAleatorios.generarDatosOrdenadosAsendendentes(100); //mejor
//        double [] datos2 = NumerosAleatorios.datos(10);
//          double [] test = {6,5,3,1,8,7,2,4};
        mergesort mg = new mergesort();
        mg.mergesort(datos1, 0, 99);
        System.out.println();
        
//        BusquedaSecuencial bs = new BusquedaSecuencial();
//        bs.busquedaSecuencial2(datos2, 2);
//        bs.busquedaSecuencial(datos2, 2);
        
        System.out.println();

//        ArrayList<Algoritmo> algoritmos = new ArrayList<>();
//        algoritmos.add(new Burbuja());
//        algoritmos.add(new BurbujaOptimizado());
//        algoritmos.add(new InsertShort());
//        algoritmos.add(new Seleccion());
//        
//        Comparador comparador = new Comparador(algoritmos, 1, 1);
//        comparador.compararAlgoritmos();
        System.out.println();
    }
   
}
