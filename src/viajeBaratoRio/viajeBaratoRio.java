/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viajeBaratoRio;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Belmont
 */
public class viajeBaratoRio {
    
    public int origen;
    public int destino;
    public int embarcaderos;
    public double[][] tarifas;
    double[][] c;
    
    public viajeBaratoRio(int origen,int destino,int embarcaderos)
    {
        this.origen=origen;
        this.destino=destino;
        this.embarcaderos=embarcaderos;
    }
    public viajeBaratoRio(int origen,int destino,int embarcaderos,double[][]tarifas)
    {
        this.origen=origen;
        this.destino=destino;
        this.embarcaderos=embarcaderos;
        this.tarifas=tarifas;
    }
    
    public void embarcaderos()
    {
      c = new double[embarcaderos][embarcaderos];
      
      for(int i=0;i<embarcaderos;i++){
          for(int j=0;j<embarcaderos;j++){
              if(i>=j)
              {
              c[i][j]=0;
              }
              else{
                  c[i][j]=minimo(i,j,c);
              }
          }
      }

    }

    public double minimo(int origen, int destino, double[][] c) 
    {
       double tem=999999;
       double aux=0;
       if(origen>=destino)
       {
           return 0;
       }
       else if(origen==destino-1){
           return tarifas[origen][destino];
       }
       else
       {
           
       for(int i = origen+1;i<=embarcaderos-1;i++)
       {
           aux=tarifas[origen][i]+tarifas[i][destino];
           if(aux<tem)
           {
               tem=aux;
           }
       }
       return tem;
       }
    }
    
    public void imprimirMatriz()
    {
        System.out.println("--------Matriz costos--------");
     for(int i=0;i<embarcaderos;i++){
          for(int j=0;j<embarcaderos;j++)
          {
          System.out.print(" "+c[i][j]);
          }
          System.out.println();
     }
    }
    
    public void generarTarifas()
    {
        System.out.println("--------Matriz de Tarifas--------");
        tarifas=new double[embarcaderos][embarcaderos];
     for(int i=0;i<embarcaderos;i++){
          for(int j=0;j<embarcaderos;j++)
          {
          tarifas[i][j]=ThreadLocalRandom.current().nextInt(0, 50);
          System.out.print(" "+tarifas[i][j]);         
          }
          System.out.println();
     }
    }
    
    public double menorRecorrido(int origen,int destino)
    {   
    double result,min=999;
    if(origen>=destino)
    {
       return 0;
    }
    if(destino-1==origen)
    {
       return tarifas[origen][destino];
    }
    else
    {
        for(int k=origen+1;k<=destino-1;k++){
            result=menorRecorrido(origen,k)+menorRecorrido(k,destino);
            if(result<min)
            {
                min=result;
            }
        }
        return min;
    }
    }
    
}
