/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caballo;

/**
 *
 * @author Belmont
 */
public class test {
    public static void main(String[] args) {
        caballo pc = new caballo(5,5);
        
        int fila = 1;
        int columna = 1;
        
        System.out.println("\n\nCordenada inicio : "+fila+","+columna+"\n");
        pc.resolverProblema(fila,columna);       
        pc.mostrarTablero();
        System.out.println("\n\nNumero de recorridos Realizados : "+pc.num);
        System.out.println();

    }
}
