/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import algoritmos.Algoritmo;
import java.util.ArrayList;
import org.jfree.data.xy.XYDataItem;
import Graficar.Graficar;
import java.awt.Dimension;

/**
 *
 * @author Belmont
 */
public class Comparador {
    
    // coleccion que tendrá almacenados a todos los algoritmos de
    // ordenamiento 
    private ArrayList<Algoritmo> algoritmos;
    private int iteraciones;
    private int factorCrecimiento;

    public Comparador(ArrayList<Algoritmo> algoritmos, int iteraciones, int factorCrecimiento) {
        this.algoritmos = algoritmos;
        this.iteraciones = iteraciones;
        this.factorCrecimiento = factorCrecimiento;
    }
    
    public void compararAlgoritmos(){
    
        // creamos la grafica 
        Graficar grafica = new Graficar("iteracion","tiempo","Comparacion");
        for (int x=0; x<this.algoritmos.size();x++)
            grafica.agrearSerie("serie"+x);
      
       // se ejecutan todas las iteraciones 
        
        for (int i=0; i < this.iteraciones;i++ ){
            
            // ejecutar todos los algoritmos
            
            //double datos[] = herramientas.NumerosAleatorios.datos(this.factorCrecimiento*(i+1), 100); // intermedios
            double datos[] = NumerosAleatorios.generarDatosOrdenadosDesendentemente(this.factorCrecimiento*(i+1)); //Peor de los Casos
            //double datos[] = NumerosAleatorios.generarDatosOrdenadosAsendendentes(this.factorCrecimiento*(i+1)); // Mejor de los Casos
            
            // recorremos la coleccion de los algoritmos
            int a = 0;
            for (int alg=0; alg < this.algoritmos.size();alg++){
                this.algoritmos.get(alg).ordenar(datos.clone());
                double tiempo =  this.algoritmos.get(alg).getTiempo_total();
                grafica.agregarDatoASerie("serie"+alg,new XYDataItem(i, tiempo));
                a++;
            }
        
        }
        grafica.crearYmostrarGrafica();
        
    
    }
}
