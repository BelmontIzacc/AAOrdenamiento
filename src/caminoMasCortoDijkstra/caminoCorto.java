/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caminoMasCortoDijkstra;

import java.util.ArrayList;

/**
 *
 * @author Belmont
 */
public class caminoCorto {
    
  public int[][] matrizAdy;
  public int nNodos;
  public ArrayList caminoS = new ArrayList();
  public ArrayList caminoR = new ArrayList();
  public ArrayList caminos = new ArrayList();
    
    public caminoCorto(int numNodos){
    this.nNodos=numNodos;
    this.matrizAdy = new int[numNodos][numNodos];
    }
    
    public void resolver(int origen){
    matrizAdy[origen][origen]=0;  //marca como 0 el valor del nodo origen por ser distancia 0 indica el inicio
    int nod;
    int minimo;
    int aux;
    int nodCambio=0;
    int intento;
    String tmp;
        
    for(int i=0;i<nNodos;i++){
      if(i!=origen)
      {
        caminoR.add(""+i); //camino a recorrer
      }
      else
      {
        caminoS.add(""+i); //de donde partimos
      }
      caminos.add("");
    }
    
    for(int i=0;i<nNodos;i++){ //for que aplica por el numero de nodos total
      minimo=-1;
      for(int j=0;j<caminoR.size();j++) //for que recorre por el tañano resultante de los caminos sin el origen
      { 
        nod=Integer.valueOf((String)caminoR.get(j)).intValue(); //tener el valor para moverse
        aux=min(nod); //evaluar el nodo que se acaba de sacar
        if(minimo==-1 || (aux<minimo && aux!=-1)){
          minimo=aux; // la variable minimo se actualiza por el valor que se acaba de actualizar
          nodCambio=j; // el nodo acaba de cambiar por el valor qe se acaba de recorrer
        }
      }
      if(minimo!=-1){
        caminoS.add(""+(String)(caminoR.get(nodCambio)));
        caminoR.remove(nodCambio);
      }
    }
    //Imprimiendo resultados
    System.out.print("\n -> Resultados <-");
    for(int k=0;k<caminos.size();k++)
      if(k!=origen){
        tmp=(String)(caminos.get(k))+(char)(k+65); //toma el valor en la posicion y lo pasa a una letra y lo guarda en temp
        caminos.set(k,tmp);
      }
    for(int j=0;j<caminos.size();j++)
      if(j!=origen){
        intento=0;
        tmp=(String)(caminos.get(j));
          while(tmp.charAt(0)!=(char)(origen+65) && intento<10){
            aux=tmp.charAt(0)-65; //regresa el valor de la letra a un numero 
            tmp=((String)(caminos.get(aux)))+tmp.substring(1,tmp.length()); // se agrega el progen a el conjunto
            if(++intento==10)
              tmp="*"+tmp;
          };
        imprimeCamino(tmp,j,origen);
      }
    System.out.println("\n");
    }

    private int min(int destino) 
    {
    int min=-1;
    int nod=0;
    int nodOrig=-1;
    int aux;
    for(int i=0;i<caminoS.size();i++)
    { // for que recorre el tamñao de datos del origen 
      nod=Integer.valueOf((String)(caminoS.get(i))).intValue(); // toma el valor de donde se encuentra el nodo origen
      if(matrizAdy[nod][nod]!=-1 && matrizAdy[nod][destino]!=-1) //toma el valor de el origen y del destino nuevo
      { 
        aux=matrizAdy[nod][nod]+matrizAdy[nod][destino]; //suma los valores de origen y destino nuevo
      }
      else
      {
        aux=-1;
      }
      if((aux<min && aux!=-1)||min==-1){
        min=aux; // se actualiza el valor min que se calculo
        nodOrig=nod; //el nodo origen se respalda
      }
    }
    if(min!=-1)
    {
      matrizAdy[destino][destino]=min; // se actualiza el valor en la matriz en la posicion del destino nuevo
      caminos.set(destino,""+(char)(nodOrig+65)); // se pone el camino que se inicia o de donde partio
    }
        return min;
    }
    
    public void imprimeCamino(String cam, int nod, int o)
    {
    System.out.print("\nCamino: ");
    if(cam.charAt(0)=='*')
    {
      System.out.print("No hay camino de: "+(char)(o+65)+" a: "+cam.charAt(cam.length()-1)+"!!");
    }
    else{
      for(int i=0;i<cam.length();i++)
        System.out.print(""+cam.charAt(i)+(i==cam.length()-1?"":"->"));
      System.out.print(" costo: "+matrizAdy[nod][nod]);
    }
  }
    
    public void imprimirMatriz()
    {
        System.out.println("--------------Imprimiendo Matriz--------------");
        for(int x = 0 ; x<this.nNodos;x++)
        {
            for(int y = 0 ; y<this.nNodos;y++)
            {
                System.out.print(" "+this.matrizAdy[x][y]);
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------");
    }

    public void setMatrizAdy(int[][] matrizAdy) {
        this.matrizAdy = matrizAdy;
    }

    public int[][] getMatrizAdy() {
        return matrizAdy;
    }
    
    
}
