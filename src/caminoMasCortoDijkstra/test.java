/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caminoMasCortoDijkstra;

/**
 *
 * @author Belmont
 */
public class test {
    public static void main(String args[]){
        int[][]aux = new int[][]{{-1,10,3,8,-1},{4,-1,-1,1,4},{-1,2,-1,-1,-1},{-1,-1,2,-1,-1},{5,-1,-1,5,-1}};
        caminoCorto c = new caminoCorto(5);
        c.setMatrizAdy(aux);
        c.imprimirMatriz();
        c.resolver(0);
        c.imprimirMatriz();
        System.out.println();
    }
}
