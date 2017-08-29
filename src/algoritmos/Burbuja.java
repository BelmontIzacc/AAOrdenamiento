/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Burbuja implements Algoritmo{
    
    private double tiempoInicio;
    private double tiempoFinal;
    private double tiempoTotal;
    private int intercambios;
    private int comparaciones;

    public Burbuja() {
        this.tiempoInicio = 0;
        this.tiempoFinal = 0;
        this.tiempoTotal = 0;
        this.comparaciones = 0;
        this.intercambios = 0;
    }
    @Override
    public void ordenar(double []arreglo){
            
        this.tiempoInicio = System.currentTimeMillis();
    
          for(int i = 1; i < arreglo.length; i++)    // 4n(5n(13n))
            { 
            for(int j = 0; j < arreglo.length - 1; j++)  //5n(13)
                 {
                   this.comparaciones++;
                                        //total  = 13
                if (arreglo[j] > arreglo[j + 1]) // 4
                { 
                    double tmp = arreglo[j]; //2
                    arreglo[j] = arreglo[j+1]; //4
                    arreglo[j+1] = tmp; // 3
                    this.intercambios++;
                }
            }
        }
          //total = 4n(5n(13n)) = 4n (65n) = 260n^2 = n^2
          this.tiempoFinal = System.currentTimeMillis();
          this.tiempoTotal=tiempoFinal-tiempoInicio;
    
    }

    @Override
    public double getTiempo_total() {
        return tiempoTotal;
    }
    
    
}
