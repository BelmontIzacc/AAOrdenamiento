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
public class mergershort implements Algoritmo{
    
    private double tiempoInicio;
    private double tiempoFinal;
    private double tiempoTotal;
    private int intercambios;
    private int comparaciones;
    
    public mergershort()
    {
        this.tiempoInicio = 0;
        this.tiempoFinal = 0;
        this.tiempoTotal = 0;
        this.comparaciones = 0;
        this.intercambios = 0;
    };
    
    public void mergesort(double A[],int izq, int der){
         
    if (izq<der){
            int m=(izq+der)/2;
            mergesort(A,izq, m);
            mergesort(A,m+1, der);
            merge(A,izq, m, der);
    }
}

    public void merge(double A[],int izq, int m, int der){
    int i, j, k;
    double [] B = new double[A.length]; //array auxiliar
    for (i=izq; i<=der; i++)
    { //copia ambas mitades en el array auxiliar
              B[i]=A[i];
    }
              i=izq; 
              j=m+1; 
              k=izq;
              while (i<=m && j<=der)
              { //copia el siguiente elemento más grande
                   this.comparaciones++;
              if (B[i]<=B[j])
                  {
                      A[k++]=B[i++];
                      this.intercambios++;
                  }
              else{
                      A[k++]=B[j++];
                     this.intercambios++;
                  }
              }
              while (i<=m){ //copia los elementos que quedan de la
                            A[k++]=B[i++]; //primera mitad (si los hay)
              }
          
  }

    @Override
    public void ordenar(double[] arreglo) {
        this.tiempoInicio = System.currentTimeMillis();
        mergesort(arreglo,0,arreglo.length-1);
        this.tiempoFinal = System.currentTimeMillis();
        this.tiempoTotal=tiempoFinal-tiempoInicio;
    }

    @Override
    public double getTiempo_total() {
        return tiempoTotal;
    }
 }
