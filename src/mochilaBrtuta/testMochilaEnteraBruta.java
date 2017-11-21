/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilaBrtuta;

import java.util.ArrayList;

/**
 *
 * @author Belmont
 */
public class testMochilaEnteraBruta {
    public static void main(String[] args) {
        ArrayList<Item> articulos = new ArrayList<>();
            articulos.add(new Item(200,2));
            articulos.add(new Item(83,4));
            articulos.add(new Item(100,14));
                mochilaEnteraBruta m = new mochilaEnteraBruta(21,articulos);
                m.calcular();
                System.out.println();
    }
}
