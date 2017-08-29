/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Belmont
 */
public class NumerosAleatorios {
    
   public static double[] datos (int n,int limite){
       
       double[] arreglo=new double[n]; 
       
       for (int x=0;x<n;x++){
       //arreglo[x] = (int) (Math.random()*max)+1;
       arreglo[x] = ThreadLocalRandom.current().nextInt(0, limite);
       }
       return arreglo;
       //this.datos = arreglo;
   }
   
   public static double[] generarDatosOrdenadosDesendentemente(int n)
   {
       double [] datos = new double[n];
       for(int x = n-1 ; x > -1; x--){
           datos[x] = n - x;
       }
       return datos;
   }
   
   public static double[] generarDatosOrdenadosAsendendentes(int n)
   {
       double [] datos = new double[n];
       for(int x = 1 ; x < n; x++){
           datos[x] = x;
       }
       return datos;
   }
    
}
