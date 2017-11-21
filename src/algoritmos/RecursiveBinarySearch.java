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
public class RecursiveBinarySearch implements Algoritmo{
    
    private double tiempoInicio;
    private double tiempoFinal;
    private double tiempoTotal;
    private int intercambios;
    private int comparaciones;
    private double resultadoPosicion;
    private double numero;
    
    public RecursiveBinarySearch(){
        this.tiempoInicio = 0;
        this.tiempoFinal = 0;
        this.tiempoTotal = 0;
        this.comparaciones = 0;
        this.intercambios = 0;
    }
    
    	public double busca(double[] array, double num) {
            this.tiempoInicio = System.currentTimeMillis();
		return buscaBinariaRecursiva(array, 0, array.length - 1, num);
	}

        public double buscaBinariaRecursiva(double[] array, int menor, int mayor,
			double num) 
        {
		int media = (mayor + menor) / 2;
		
                double valorMedio = array[media];
                
                this.comparaciones++;
		
                if (menor > mayor)
                {
			return -1;
                }
		else if(valorMedio == num)
                { 
			return media;
                }
		else if (valorMedio < num)
                {
                        this.intercambios++;
			return buscaBinariaRecursiva(array, media+1, mayor, num);
                }
		else
                {
			return buscaBinariaRecursiva(array, menor, media-1, num);
                }      

	}

    @Override
    public void ordenar(double[] arreglo) {
        this.tiempoInicio = System.currentTimeMillis();
        double num = ThreadLocalRandom.current().nextInt(0, arreglo.length);
        this.numero = num;
        this.resultadoPosicion= busca(arreglo,num);
        
    }

    @Override
    public double getTiempo_total() {
        return tiempoTotal;
    }
}
