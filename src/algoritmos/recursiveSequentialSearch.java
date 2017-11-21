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
public class recursiveSequentialSearch implements Algoritmo{
    private double tiempoInicio;
    private double tiempoFinal;
    private double tiempoTotal;
    private int intercambios;
    private int comparaciones;
    private double resultadoPosicion;
    private double numero;
    
    public recursiveSequentialSearch()
    {
        this.tiempoInicio = 0;
        this.tiempoFinal = 0;
        this.tiempoTotal = 0;
        this.comparaciones = 0;
        this.intercambios = 0;
        this.resultadoPosicion=0;
        this.numero=0;
        
    }
    
  public double busquedaRecursiva(double[] vec , int tam , int dato)
  {
      this.comparaciones++;
      if(tam==0 && vec[tam]==dato)
      {
          return tam;
      }
      else if( tam==0)
      {
          return -1;
      }
      else if(vec[tam]==dato)
      {
          return tam;
      }
      else
      {
          this.intercambios++;
          return busquedaRecursiva(vec,tam-1,dato);
      }
      
  }

    @Override
    public void ordenar(double[] arreglo) {
        this.tiempoInicio = System.currentTimeMillis();
        int num = ThreadLocalRandom.current().nextInt(0, arreglo.length);
        this.numero = num;
       this.resultadoPosicion =busquedaRecursiva(arreglo,arreglo.length-1,num);
    }

    @Override
    public double getTiempo_total() {
        return tiempoTotal;
    }
    
}
