/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtraquinDados;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Belmont
 */
public class AlgoritmoCostoCorrupcionTest {

  public void testProcesa() {
    List<Votante> listaDeVotantes=new ArrayList<Votante>();
    listaDeVotantes.add(new Votante("Votante1",0.2f,4));
    listaDeVotantes.add(new Votante("Votante2",0.1f,3));
    listaDeVotantes.add(new Votante("Votante3",0.8f,2));
    listaDeVotantes.add(new Votante("Votante4",0.5f,5));
    listaDeVotantes.add(new Votante("Votante5",0.6f,3));
    listaDeVotantes.add(new Votante("Votante6",0.2f,3));
    listaDeVotantes.add(new Votante("Votante7",0f,5));

    AlgoritmoCostoCorrupcion ccc=new AlgoritmoCostoCorrupcion("Candidato A");
    List<Votante>solucion=ccc.procesa(listaDeVotantes);
    ccc.print(solucion);

    //assertThat(solucion.size(),is(equalTo(5)));
  }

}
