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
public class Burbuja {
    
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
    
    public void ordenar(double []arreglo){
            
        this.tiempoInicio = System.currentTimeMillis();
    
          for(int i = 1; i < arreglo.length; i++)
            {
            for(int j = 0; j < arreglo.length - 1; j++)
                 {
                   this.comparaciones++;
                           
                if (arreglo[j] > arreglo[j + 1])
                {
                    double tmp = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = tmp;
                    this.intercambios++;
                }
            }
        }
    
          this.tiempoFinal = System.currentTimeMillis();
          this.tiempoTotal=tiempoFinal-tiempoInicio;
    
    }

    public double getTiempoTotal() {
        return tiempoTotal;
    }

    public double getTiempoInicio() {
        return tiempoInicio;
    }

    public double getTiempoFinal() {
        return tiempoFinal;
    }

    public int getIntercambios() {
        return intercambios;
    }

    public int getComparaciones() {
        return comparaciones;
    }
    
    
    
}
