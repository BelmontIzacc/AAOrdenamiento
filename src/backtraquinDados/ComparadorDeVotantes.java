/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtraquinDados;

import java.util.Comparator;

/**
 *
 * @author Belmont
 */
public class ComparadorDeVotantes implements Comparator<Votante> {

  @Override
  public int compare(Votante v1, Votante v2) {
    if(v1.getProbabilidadVoto()==v2.getProbabilidadVoto()) {
        return v1.getCosto() < v2.getCosto() ? -1 : v1.getCosto() == v2.getCosto() ? 0: -1 ;
    }
    return v1.getProbabilidadVoto() > v2.getProbabilidadVoto() ? -1 : 1;
  }

}
