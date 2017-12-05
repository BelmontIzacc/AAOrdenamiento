/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoGenetico;

/**
 *
 * @author izacc
 */
public class individuo {
    
    private int cromosoma[];
    private int fitness;
    private int decodificacion;
    
    public individuo()
    {
        this.cromosoma = new int[16] ;
        this.decodificacion = 0;
        this.fitness = 0;
    }
    
    public individuo(int[] cromosoma)
    {
        this.cromosoma = cromosoma;
        
        calculaDeco();
        calculaFitness();
    }

    private void calculaDeco() 
    {
        for(int x = 0 ; x<=15 ; x++ )
        {
            if(this.cromosoma[x]==1)
            {
            this.decodificacion+=(Math.pow(2, 15-x));
            }
        }
    }

    private void calculaFitness() 
    {
        //valor maximo 262138
        this.fitness = (4 * this.decodificacion) - 2; // 4x - 2
    }

    public int[] getCromosoma() {
        return cromosoma;
    }

    public int getFitness() {
        return fitness;
    }

    public int getDecodificacion() {
        return decodificacion;
    }
    
    
}
