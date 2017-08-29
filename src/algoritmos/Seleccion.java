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
public class Seleccion implements Algoritmo{
    
    private double tiempoInicio;
    private double tiempoFinal;
    private double tiempoTotal;
    private int intercambios;
    private int comparaciones;
    
    public Seleccion(){
        this.tiempoInicio = 0;
        this.tiempoFinal = 0;
        this.tiempoTotal = 0;
        this.comparaciones = 0;
        this.intercambios = 0;
    }

    @Override
    public void ordenar(double[] arreglo) {
        double menor,tmp;
        int pos;
        this.tiempoInicio = System.currentTimeMillis();
                                                                                    //total = 55n * 50n = 2750n^2 //Peor de los Casos
                                                                                        //5n(11(5n(10)))
         for(int i = 0; i < arreglo.length-1; i++)  //tomamos como menor el primero      //5n(11) = 55n;
            {                                                                       //total = 11
            menor = arreglo[i]; // elementos que quedan por ordenar                     //2
            pos=i; //y guardamos posicion                                               //1   
            for(int j = i+1; j < arreglo.length; j++)  //buscamos en el resto       //5n(10) = 50n
                 {                                                                      //total = 10
                   this.comparaciones++;                    
                if (arreglo[j] < menor) //del array algun elemento                  //2
                { 
                    menor = arreglo[j]; //menor que el actual                       //2
                    pos = j;                                                        //1
                    this.intercambios++;
                } 
            }
            if(pos!= i){ // si hay alguno menor se intercambia                      // 1
                     tmp = arreglo[i];                                              //2
                     arreglo[i] = arreglo[pos];                                     //3
                     arreglo[pos] = tmp;                                            //2
                 }
        }    
          this.tiempoFinal = System.currentTimeMillis();
          this.tiempoTotal=tiempoFinal-tiempoInicio;        
    }
    //mejor de los casos total = 10n *20n = 200n^2
//5n(2)
//5n(4)
    @Override
    public double getTiempo_total() {
        return tiempoTotal;
    }
}
