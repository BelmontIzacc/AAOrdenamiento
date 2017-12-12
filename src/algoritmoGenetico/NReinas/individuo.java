/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoGenetico.NReinas;

/**
 *
 * @author izacc
 */
public class individuo {
    
    private int cromosoma[];
    private int fitness;
    private int n;
    
    public individuo(int n)
    {
        this.cromosoma = new int[n] ;
        this.fitness = 0;
        this.n = n;
    }
    
    public individuo(individuo i)
    {
        this.cromosoma = i.getCromosoma().clone();
        this.fitness = i.getFitness();
        this.n = i.cromosoma.length;
    }
    
    public individuo(int[] cromosoma)
    {
        this.cromosoma = cromosoma; 
        this.n = cromosoma.length;
        calculaFitness();
    }

    public void calculaFitness() 
    {
        //calcular numero de ataques
        fitness = 0;
        
        for(int i=0 ; i< n ;i++)
        {
            for(int j = 0 ; j< n ; j++)
            {
                if(i!=j)
                {
                    if(cromosoma[i]==cromosoma[j])
                    {
                        fitness++;
                    }
                    else
                    {
                        if(Math.abs(cromosoma[i]-cromosoma[j])==Math.abs(i-j))
                        {
                            fitness++;
                        }
                    }
                }
            }
        }
    }

    public int[] getCromosoma() {
        return cromosoma;
    }

    public int getFitness() {
        return fitness;
    }

    @Override
    public String toString() {
        return "individuo{" + "fitness=" + fitness + '}';
    }

}
