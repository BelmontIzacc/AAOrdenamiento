/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voraz;

/**
 *
 * @author Belmont
 */
public class voraz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] moneda = {500, 100, 50, 10, 5, 1};
        
        //Quiero 23456 en monedas
        int saldo = 23476;
        int [] cambio = voraz.calcula(saldo, moneda);
        
        System.out.println("Vuelto: "+saldo);
        
        for(int i = 0; i < cambio.length; i++)
            System.out.println(moneda[i]+" = "+cambio[i]+" unidad(es)");
    }

    public static int[] calcula(int monto, int[] valor) {
        int[] moneda = new int[valor.length];
        for (int i = 0; i < valor.length; i++) {
            while (valor[i] <= monto) {
                moneda[i]++;
                monto = monto - valor[i];
            }
        }
        return moneda;
    }
}
