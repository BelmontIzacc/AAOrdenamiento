/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;


/**
 *
 * @author Belmont
 */
public class BusquedaSecuencial implements Algoritmo{
    
    public String posicion = "";
    public int UnicaPos;
    public int tam = 0;
    public int[] posiciones = new int[tam];
    
    
    @Override
    public void ordenar(double[] arreglo) {
          }

    @Override
    public double getTiempo_total() {
        return 0; }
    
 public  void busquedaSecuencial(double []arreglo,int dato){
 int pos = -1;                                                                          //total 4n(3) = 12n = n
  for(int i = 0; i < arreglo.length; i++){//recorremos todo el arreglo                  //4n
                                                                                    //total 3
      if(arreglo[i] == dato){//comparamos el elemento en el arreglo con el buscado      //2
    pos = i;//Si es verdadero guardamos la posicion                                     // 1
    break;//Para el ciclo
   }
 }
 this.UnicaPos = pos;
}
 
 public void busquedaSecuencial2(double []arreglo,int valor){
    String pos = ""; 
                                        // total 4n(6) = 24n = n 
  for(int i = 0; i < arreglo.length; i++){ //4n
                                    //total 6
      if(arreglo[i] == valor){  //2
    pos += i+",";       // 3
   }
  }

 this.posicion = pos;
 ConvertirArray();
}
   
 public void ConvertirArray(){
    String cadena = this.posicion;
    String cadenaArray[] = cadena.split(",");
    int max = cadenaArray.length;
    int[] aux = new int[max];
   
    for(int x = 0; x< max; x++){
        String valor = cadenaArray[x];
        aux[x] = Integer.parseInt(valor);
    }
    this.tam=max;
    this.posiciones=aux;
 }
 
}
