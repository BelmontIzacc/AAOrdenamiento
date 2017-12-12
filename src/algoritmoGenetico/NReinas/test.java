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
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneticoReina  g = new GeneticoReina(100,100,0.2,20);
        g.evolucionar();
        System.out.println();
    }
    
}
