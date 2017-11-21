/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtraquinDados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Belmont
 */
public class AlgoritmoCostoCorrupcion implements AlgoritmoVoraz<Votante> {

  private String candidatoElectoral;

  public AlgoritmoCostoCorrupcion(String candidatoElectoral) {
    this.candidatoElectoral=candidatoElectoral;
  }

  @Override
  public List<Votante> procesa(List<Votante> listaDeVotantes) {
    //ordenamos el conjunto candidatos
    Collections.sort(listaDeVotantes, new ComparadorDeVotantes());
    //creamos el conjunto solucion, inicialmente vacio
    List<Votante> solucion = new ArrayList<Votante>();
    //guardamos el numero de elementos del conjunto candidato para poder 
    //calcular porcentaje de procesamiento posteriormente
    int elementosTotales = listaDeVotantes.size();
    //sumatorio para calcular el costo de corrupcion de los votantes
    float costoCorrupcion = 0; 

    //iteramos mientras no tengamos una solucion valida
    while (!esSolucion(solucion.size(), elementosTotales, 70)) {
        //como el conjunto candidato esta ordenado la seleccion es
        //tan simple como obtener siempre el primero
        Votante candidato = seleccionarCandidato(listaDeVotantes);
        //sumamos
        costoCorrupcion = costoCorrupcion + candidato.getCostoAplicado();
        //añadimos al conjunto solucion
        solucion.add(candidato);
        //eliminamos del conjunto candidato
        listaDeVotantes.remove(candidato);
    }
    //conjunto solucion
    return solucion;
  }

  //obtiene el primer elemento del conjunto candidato
  private Votante seleccionarCandidato(List<Votante> listaDeVotantes) {
    return listaDeVotantes.get(0);
  }

  //es solucion cuando se han procesado el 70% o mas de los elementos
  //del conjunto candidato, no es necesario mas al estar ordenados
  private boolean esSolucion(int elementosProcesados, int elementosMaximos, int porcentajeMinimo) {
    return (elementosProcesados * 100) / elementosMaximos > porcentajeMinimo;
  }

//muestra resultado
public void print(List<Votante> solucion) {
    float costoCorrupcion=0;
    System.out.println("Datos del conjunto solucion:");
    for (Votante elementoDeSolucion : solucion) {
        System.out.println("\t"+elementoDeSolucion.toString());
        costoCorrupcion = costoCorrupcion + elementoDeSolucion.getCostoAplicado();
    }
    System.out.println("El coste de corrupcion minimo es de : " + costoCorrupcion + " para el candidato: " 
            + candidatoElectoral + "con al menos el 70% de los votantes");

  }

}