/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmpateDeCadenas;

import EmpateDeCadenas.RabinKarp.*;

/**
 *
 * @author izacc
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//       char a [] = new char[]{'a','b','c'};
//       String aS = "abb";
       RabinKarp r = new RabinKarp();
//       
//       System.out.println(aS.hashCode());
//       System.out.println(r.calcularHash(a));
        char n [] = new char[]{'o','n'};
        EmpateFuerzaBruta f = new EmpateFuerzaBruta(100, n);
        int res = f.buscar();
//        System.out.println(r.calcularHash(f.secuencia));
        System.out.println(r.calcularHash(n));
        System.out.println("veces encontrado : "+res);
    
    }
    
}
