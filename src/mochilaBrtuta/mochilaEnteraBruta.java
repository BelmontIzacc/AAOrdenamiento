/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilaBrtuta;

import java.util.ArrayList;

/**
 *
 * @author Belmont
 */
public class mochilaEnteraBruta {
    
    int combinaciones[];
    int capacidad;
    ArrayList<Item> articulos;
    
    public mochilaEnteraBruta(int capacidad,ArrayList<Item> articulos){
        this.combinaciones = new int[3];
        this.capacidad=capacidad;
        this.articulos = articulos;
    }
    public void calcular(){
        int comMejor[]=this.combinaciones.clone();
        for(int a = 0 ; a<=1;a++){
            this.combinaciones[0]=a;
            for(int b=0;b<=1;b++){
                this.combinaciones[1]=b;
                for(int c=0;c<=1;c++){
                    this.combinaciones[2]=c;
//                    imprimeArticulos();
                      if(validadCombinaciones()){
                          //si es valida calculamos el beneficio
                          double ben1 = calculaBeneficio(comMejor);
                          double ben2 = calculaBeneficio(this.combinaciones);
                          //si es valida comparamos con la mejor
                          if(ben2>ben1){
                              comMejor = this.combinaciones.clone();
                          }
                      }
                }
            }
        }
    }

    private void imprimeArticulos() {
        String aux="";
        for(int x=0;x<this.combinaciones.length;x++){
            aux+=""+this.combinaciones[x];
        }
        System.out.println(aux);
    }

    private boolean validadCombinaciones() {
        boolean valida = true;
        int acumulado = 0;
        for(int x = 0; x<combinaciones.length;x++){
           if(this.combinaciones[x]==1){
               acumulado+=this.articulos.get(x).getPeso();
               if (acumulado>this.capacidad)
                {
                    return false; 
                }
           }
        }
        return valida;
    }

    private double calculaBeneficio(int[] combinaciones) {
        double ben=0;
        for(int x = 0; x<combinaciones.length;x++){
            if(combinaciones[x]==1)
            {
            ben+= this.articulos.get(x).getValor();
            }
        }
        return ben;
    }

 
}
