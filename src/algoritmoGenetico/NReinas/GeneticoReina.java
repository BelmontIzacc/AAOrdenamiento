/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoGenetico.NReinas;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import algoritmoGenetico.NReinas.individuo;

/**
 *
 * @author izacc
 */
public class GeneticoReina 
{
    //cuantas generaciones
    // num de individuos
    //prob de muta
    private int numId;
    private int numGeneraciones;
    private double pMuta;
    private int n;
    private ArrayList<individuo> poblacionActual;

    public GeneticoReina(int numId, int numGeneraciones, double pMuta, int n) 
    {
        this.numId = numId;
        this.numGeneraciones = numGeneraciones;
        this.pMuta = pMuta;
        this.n = n;
        this.poblacionActual = null;
        generarPoblacionInicial();
    }

    private void generarPoblacionInicial() 
    {
        //se crea la poblacion inicial de forma aleatoria
        this.poblacionActual = new ArrayList<>();
      for(int x = 1 ; x <= numId ; x++)
      {
          int aux[] = new int[n];
          //generar la parte aleatoria
          for(int i = 0 ; i<n ; i++)
          {
              aux[i] = ThreadLocalRandom.current().nextInt(0, n+1); // nota
          }
          this.poblacionActual.add(new individuo(aux.clone()));
      }
        
    }
    
    public void evolucionar()
    {
        //generar diferentes generaciones
        for(int g = 0 ; g < this.numGeneraciones; g++)
        {
            //generar la nueva poblacion
                ArrayList<individuo> nvaPoblacion = new ArrayList<>();
                int maskara [] = operadores.mascaraAleatoria(n);
                //int maskara [] = operadores.mascaraenmedio(2,8,16);
                //int maskara [] = operadores.mascaraInicio(16);
                //int maskara [] = operadores.mascaraFin(16);
                
            //generamos un proceso iteratico para crear la nueva poblacion
                    for(int i  = 0 ; i < this.numId; i++)
                    {
                        //seleccion
                            individuo madre = operadores.seleccionTorneo(this.poblacionActual);
                            individuo padre = operadores.seleccionTorneo(this.poblacionActual);
                        //cruza
                            individuo hijo = operadores.cruzaMascara(maskara, madre, padre,n);
                            
                            if(Math.random() <= this.pMuta) //ThreadLocalRandom.current().nextInt(0, 2)
                            {
                                //muta
                                operadores.mutaGen(hijo,n);
                            }
                            
                        nvaPoblacion.add(hijo);
                    }
                     //actualizar la poblacion actual 
                     actualizarPoblacion(nvaPoblacion);
                     // if(this.poblacionActual.get(0).getFitness()==0)
                    individuo mejor = obtenerElMejor();
//                  if(mejor.getFitness()==0)
//                      System.out.println();
                    //System.out.println("epoca : "+g+" "+this.poblacionActual.get(0).toString());
                    System.out.println("epoca : "+g+" "+mejor.toString());
        }
    }

    private void actualizarPoblacion(ArrayList<individuo> nvaPoblacion) 
    {
        //recorremos los elementos de la poblacion
        this.poblacionActual = new ArrayList<>();
        for(individuo ind : nvaPoblacion)
        {
            this.poblacionActual.add(new individuo(ind.getCromosoma()));
        }
    }

    private individuo obtenerElMejor() {
        individuo mejor = this.poblacionActual.get(0);
        for(individuo aux : this.poblacionActual)
        {
            if(aux.getFitness() < mejor.getFitness())
            {
                mejor = aux;
            }
        }
        return mejor;
    }
    
    
}
