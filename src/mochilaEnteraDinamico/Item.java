/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilaEnteraDinamico;

/**
 *
 * @author Belmont
 */
class Item {
    
    public double valor;
    public double peso;
    public int indice;
    
    Item(int i,double v, double p) {
        valor =v;
        peso  =p;
        indice = i;
    }

    public double getValor() {
        return valor;
    }

    public double getPeso() {
        return peso;
    }
    
   @Override
    public String toString() {
        return String.format("12.2%f,12.2%f", valor, peso);
    }
}
