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
public class operadores 
{
    
    public static individuo seleccionTorneo(ArrayList<individuo> pob)
   {
       individuo mejor = pob.get(0);
       //recorre la poblacion
       for(individuo i : pob)
       {
           if(i.getFitness()>mejor.getFitness())
           {
               mejor = i;
           }
       }
       return new individuo(mejor.getCromosoma().clone());
   }
    
    public static individuo seleccionAleatoria(ArrayList<individuo> pob)
   {
       int aux = ThreadLocalRandom.current().nextInt(0, pob.size());
       individuo aleatorio = pob.get(aux);
       //recorre la poblacion
       
       return new individuo(aleatorio.getCromosoma().clone());
   }
    
    public static individuo cruzaMascara(int mask[], individuo madre , individuo padre)
    {
        int c1[] = new int [16]; 
        int c2[] = new int [16];
        // reccorremos la maskara
        
        for(int m = 0 ; m < mask.length ; m++)
        {
            if(mask[m]==1)
            {
                c1[m] = madre.getCromosoma()[m];
                c2[m] = madre.getCromosoma()[m];

            }
            else
            {
                c1[m] = padre.getCromosoma()[m];
                c2[m] = padre.getCromosoma()[m];
            }
        }
        individuo hijo1 = new individuo(c1);
        individuo hijo2 = new individuo(c2);
        
        if(hijo1.getFitness() > hijo2.getFitness())
        {
            return hijo1;
        }
        else
        {
            return hijo2;
        }
       
    }
    
    public static void mutaGen(individuo ind)
    {
        int ran = ThreadLocalRandom.current().nextInt(0, 16);
        
        if(ind.getCromosoma()[ran] == 0)
        {
           ind.getCromosoma()[ran] = 1; 
        }
        else
        {
            ind.getCromosoma()[ran] = 0; 
        }
        
        ind.calculaDeco();
        ind.calculaFitness();
    }
    
    public static int[] mascaraAleatoria(int n)
    {
        int aux[] = new int[n];
        
        for(int i = 0 ; i<aux.length ; i++)
        {
            aux[i] = ThreadLocalRandom.current().nextInt(0, 2);
        }
        
        return aux;
    }
    
    public static int[] mascaraenmedio(int a,int b,int n)
    {
        int aux[] = new int[n];
        
        if(a < n && b < n)
        {
             for(int i = a ; i <= b ; i++)
             {
                aux[i] = 1;
             }
        }
        
        return aux;
    }
    
    public static int[] mascaraInicio(int n)
    {
        int aux[] = new int[n];
        int mitad = (int)(n/2);
        
        for(int i = 0 ; i<mitad ; i++)
        {
            aux[i] = 1;
        }
        
        return aux;
    }
   
    public static int[] mascaraFin(int n)
    {
        int aux[] = new int[n];
        int mitad = (int)(n/2);
        
        for(int i = mitad ; i<aux.length ; i++)
        {
            aux[i] = 1;
        }
        
        return aux;
    }
}
