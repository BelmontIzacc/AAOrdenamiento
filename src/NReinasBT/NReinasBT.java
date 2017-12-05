/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NReinasBT;

/**
 *
 * @author Belmont
 */
public class NReinasBT {
    
    private int n;
    private int solucion[];
    
    public NReinasBT()
    {
        this.n=0;
        this.solucion = null;
    }
    
    public boolean ejecutar(int n)
    {
        this.n  = n ;
        this.solucion = new int [n];
        for(int x =0 ; x<n;x++)
        {
            this.solucion[x] = 0;
        }
        return buscar(solucion,0);
    }
    
    private boolean buscar(int[] solucion, int etapa)
    {
        if(etapa>this.n) return false;
        
        boolean exito = false;
        solucion[etapa]=0;
        
        do
        {
            solucion[etapa]= solucion[etapa]+1; //selecciona una nueva opcion
            if(valido(solucion,etapa))
            {
               if(etapa!= n)
               {
                   exito = buscar(solucion,etapa+1);
               }
               else
               {
                   exito=true;
               }
            }
        }while(solucion[etapa]==n && exito);
        
        return exito;
    }

    private boolean valido(int[] solucion, int etapa) 
    {
        for(int i=0 ; i< etapa ;i++)
        {
            if((solucion[i]==solucion[etapa]) || (valAbs(solucion[i],solucion[etapa])==valAbs(i,etapa)))
            {
                return false;
            }
        }
        return true;
    }
    
    public int valAbs(int solucion, int etapa)
    {
        return Math.abs(solucion-etapa);
    }
}
