/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilaBrtuta;

/**
 *
 * @author Belmont
 */
class Item {
    
    public double valor;
    public double peso;
    
    Item(double v, double p) {
        valor =v;
        peso  =p;
    }

    public double getValor() {
        return valor;
    }

    public double getPeso() {
        return peso;
    }
    
   @Override
    public String toString() {
        return String.format("12.2f %,12.2f", valor, peso);
    } 
}
