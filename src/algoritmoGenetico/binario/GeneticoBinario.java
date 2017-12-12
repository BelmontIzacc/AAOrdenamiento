/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoGenetico.binario;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author izacc
 */
public class GeneticoBinario 
{
    //cuantas generaciones
    // num de individuos
    //prob de muta
    private int numId;
    private int numGeneraciones;
    private double pMuta;
    private ArrayList<individuo> poblacionActual;

    public GeneticoBinario(int numId, int numGeneraciones, double pMuta) 
    {
        this.numId = numId;
        this.numGeneraciones = numGeneraciones;
        this.pMuta = pMuta;
        this.poblacionActual = null;
        generarPoblacionInicial();
    }

    private void generarPoblacionInicial() 
    {
        //se crea la poblacion inicial de forma aleatoria
        this.poblacionActual = new ArrayList<>();
      for(int x = 1 ; x <= numId ; x++)
      {
          int aux[] = new int[16];
          //generar la parte aleatoria
          for(int i = 0 ; i<16 ; i++)
          {
              aux[i] = ThreadLocalRandom.current().nextInt(0, 2);
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
                //int maskara [] = operadores.mascaraAleatoria(16);
                //int maskara [] = operadores.mascaraenmedio(2,8,16);
                //int maskara [] = operadores.mascaraInicio(16);
                int maskara [] = operadores.mascaraFin(16);
                
            //generamos un proceso iteratico para crear la nueva poblacion
                    for(int i  = 0 ; i < this.numId; i++)
                    {
                        //seleccion
                            individuo madre = operadores.seleccionTorneo(this.poblacionActual);
                            individuo padre = operadores.seleccionAleatoria(this.poblacionActual);
                        //cruza
                            individuo hijo = operadores.cruzaMascara(maskara, madre, padre);
                            
                            if(ThreadLocalRandom.current().nextInt(0, 2) <= this.pMuta)
                            {
                                //muta
                                operadores.mutaGen(hijo);
                            }
                            
                        nvaPoblacion.add(hijo);
                    }
                //actualizar la poblacion actual 
                actualizarPoblacion(nvaPoblacion);
                System.out.println(this.poblacionActual.get(0).toString());
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
    
    
}
