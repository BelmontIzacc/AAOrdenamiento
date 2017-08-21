/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Belmont
 */
public class NumerosAleatorios {
    
  public NumerosAleatorios(){}
    
   public double[] datos (int max,int min){
       
       double[] arreglo=new double[max]; 
       
       for (int x=0;x<max;x++){
       //arreglo[x] = (int) (Math.random()*max)+1;
       arreglo[x] = ThreadLocalRandom.current().nextInt(min, max);
       }
       return arreglo;
       //this.datos = arreglo;
   }
    
}
