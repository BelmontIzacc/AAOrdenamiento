/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaordenamiento3cm1;

import Graficar.Graficar;
import algoritmos.Algoritmo;
import algoritmos.Burbuja;
import algoritmos.BurbujaOptimizado;
import algoritmos.InsertShort;
import algoritmos.Seleccion;
import herramientas.Comparador;
import herramientas.NumerosAleatorios;
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
        double[] datos1 = NumerosAleatorios.generarDatosOrdenadosAsendendentes(10); //mejor
        
        System.out.println();

        ArrayList<Algoritmo> algoritmos = new ArrayList<>();
        algoritmos.add(new Burbuja());
        algoritmos.add(new BurbujaOptimizado());
        algoritmos.add(new InsertShort());
        algoritmos.add(new Seleccion());
        
        Comparador comparador = new Comparador(algoritmos, 300, 10);
        comparador.compararAlgoritmos();
        System.out.println();
    }
   
}
