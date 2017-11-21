/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtraquinDados;

/**
 *
 * @author Belmont
 */
public class Votante {

  private final String idVotante;
  private final float probabilidadVoto;
  private final int costo;
  private final float costoAplicado;


  public Votante(String idVotante, float probabilidadCandidato, int costo) {
    this.idVotante = idVotante;
    this.probabilidadVoto=probabilidadCandidato;
    this.costo = costo;
    this.costoAplicado = (1 - probabilidadVoto) * costo;
  }

  public String getIdCandidato() {
    return idVotante;
  }

  public float getProbabilidadVoto() {
    return probabilidadVoto;
  }

  public int getCosto() {
    return costo;
  }

  public float getCostoAplicado() {
    return this.costoAplicado;
  }

  @Override
  public String toString() {
    StringBuffer str=new StringBuffer("Votante: ").append(idVotante)
            .append(" - Probabilidad de voto: ").append(probabilidadVoto)
            .append(" - Costo de corrupcion: ").append(costo)
            .append(" - Costo en base a probabilidad: ").append(costoAplicado);
    return str.toString();
  }

}
