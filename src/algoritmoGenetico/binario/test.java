/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoGenetico.binario;

/**
 *
 * @author izacc
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //individuo i = new individuo(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}); 
        GeneticoBinario b = new GeneticoBinario(100,5000,0.2);
        b.evolucionar();
        System.out.println();
    }
    
}
