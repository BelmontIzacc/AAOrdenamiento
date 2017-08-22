/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaordenamiento3cm1;

import Graficar.Graficar;
import algoritmos.Burbuja;
import algoritmos.BurbujaOptimizado;
import algoritmos.NumerosAleatorios;

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
        int tam = 100;
        int aum = 10;
        double [] datos1 = new double[]{6,5,3,1,8,7,2,4};
        double [] datos2 = new double[]{8,7,6,5,4,3,2,1};
        double [] y = new double[tam]; 
        double [] x = new double[tam];
        double [] auc = new double[tam];
            
        for(int z = 0 ; z<50; z++){
        NumerosAleatorios al = new NumerosAleatorios();
        double[] datos4 = al.datos(tam, 0);
        double[] datos5 = datos4.clone();
        
        x[z]=tam;
        
        System.out.println();
        Burbuja b1 = new Burbuja();
        b1.ordenar(datos4);
        y[z]=b1.getTiempoFinal();
        System.out.println();
        
        BurbujaOptimizado b2 = new BurbujaOptimizado();
        b2.ordenar(datos5);
        auc[z]=b2.getTiempoFinal();
        System.out.println();
        
        tam=tam+aum;
        }
        //System.out.println(" "+x.length+" "+y.length+" "+auc.length);
        System.out.println();
        Graficar g= new Graficar(); 
        g.setGraf(true); 
        g.agregarSerie(x,y,auc);
        g.mostrarGrafica();
        System.out.println();
    }
   
}
