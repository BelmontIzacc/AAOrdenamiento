/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmpateDeCadenas;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author izacc
 */
public class EmpateFuerzaBruta {
    
    public char[] secuencia;
    public char[] patron;
    public int posI, posF;
    
    public EmpateFuerzaBruta(int n , char[] patron)
    {
        this.secuencia = new char[n];
        inicializarAleatoriamente();
        this.patron = patron;
    }
    
    public int buscar()
    {
        int c = 0 ;
        int pos = -1;
        int correctos = 0;
        int n = (int)calcularHash(this.patron);
        char[] trozo = new char[this.patron.length];
        int[] val = new int[100]; 
        
        buscar : for(int x = 0 ;x<this.secuencia.length; x++ )
        {        
            if(busca(x))
            {
                 for(int i = this.posI ; i<this.posF ; i++)
                 {
                     trozo[c]=this.secuencia[i];
                     c++;
                 }
                 //break buscar;
                 correctos++; 
                 pos++;
                 val[pos] =(int)(calcularHash(trozo));
            }
            c=0;                      
        }        
            return correctos;
    }
    private void inicializarAleatoriamente() 
    {
        for(int x = 0 ; x<this.secuencia.length ; x++)
        {
            //this.secuencia[x]=(char)(ran.nextInt(255)+1);
//            this.secuencia[x] = (char)(ThreadLocalRandom.current().nextInt(97, 122)); //a - z
            this.secuencia[x] = (char)(ThreadLocalRandom.current().nextInt(104, 112)); // h- o
            System.out.println(""+x+" -> "+""+this.secuencia[x]);
        }
    }

    private boolean busca(int x) 
    {
        int cont = 0 ;
        //verificar qe no exceda 
        if(this.patron.length+x<=this.secuencia.length)
        {
            for(int y = x ; y<this.patron.length+x; y++)
            {
                if(buscaHash(x))
                {
                    if(patron[cont]==this.secuencia[y] )
                    {
                        this.posI = x;
                        cont++;
                    }

                    if(cont == this.patron.length)
                    {
                        this.posF = y;
                        return true;
                    }   
                }
            }
        }
        return false;
    }
    
   public double calcularHash(char[] cadena)
    {
        double hash = 0 ;
        for( int x = 0 ; x < cadena.length ; x++)
        {
            hash+=(cadena[x]*Math.pow(31, (cadena.length-(x+1))));
        }
        return hash;
    }
    
        private boolean buscaHash(int x) 
    {
        int cont=0;
        int valor1 = 0;
        int valor2 = (int)calcularHash(this.patron);
        char [] aux = new char[this.patron.length];
        //verificar qe no exceda 
        if(this.patron.length+x<=this.secuencia.length)
        {
            for(int y = x ; y<this.patron.length+x; y++)
            {
                aux[cont] = this.secuencia[y];   
                cont++;
            }
            
            valor1 = (int)calcularHash(aux);
        }
        else
        {
            return false;
        }
        
        if(valor1 == valor2)
        {
            return true;
        }
        
        return false;
    }
}
