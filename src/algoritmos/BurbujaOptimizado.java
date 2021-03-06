/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

/**
 *
 * @author Belmont
 */
public class BurbujaOptimizado implements Algoritmo{
    
    private double tiempoInicio;
    private double tiempoFinal;
    private double tiempoTotal;
    private int intercambios;
    private int comparaciones;

    public BurbujaOptimizado() {
        this.tiempoInicio = 0;
        this.tiempoFinal = 0;
        this.tiempoTotal = 0;
        this.comparaciones = 0;
        this.intercambios = 0;
    }
    @Override
    public void ordenar(double []arreglo){
        
        this.tiempoInicio = System.currentTimeMillis();
        
          for(int i = arreglo.length- 1; i > 0; i--) // 5n(4n(13n))
            {
            for(int j = 0; j < i; j++) //4n(13)
                 {
                   this.comparaciones++;
                                    //total = 13
                if (arreglo[j] > arreglo[j + 1]) // 4
                {
                    double tmp = arreglo[j]; //2
                    arreglo[j] = arreglo[j+1]; //4
                    arreglo[j+1] = tmp; //3
                    this.intercambios++;
                }
            }
        }
    
          this.tiempoFinal = System.currentTimeMillis();
          this.tiempoTotal = this.tiempoFinal - this.tiempoInicio;
          //total 5n(4n(13n)) = 5n(52n)= 260n^2 = n^2 
    }

     @Override
    public double getTiempo_total() {
        return tiempoTotal;
    }
    
}
