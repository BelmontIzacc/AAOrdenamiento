/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fibonacci;

/**
 *
 * @author Belmont
 */
public class fibonaccis {

    public static int l=0;
    
    public fibonaccis(){}
    
    public static long FiboRecursivo(long pos){
        l++;
        long retornado=0;
        if(pos==0 || pos==1)
        {
            retornado=pos;
        }
        else{
            retornado=FiboRecursivo(pos-1)+FiboRecursivo(pos-2);
        }
        return retornado;
    }
    
    public static long FiboIterativo(long pos){
        int ult = 1;
        int pen = 0;
        int suma = 0;
        for(int x = 1; x<pos;x++){
            suma = ult + pen;
            pen = ult;
            ult = suma;
        }
           return ult;   
    }
    
    public static long FiboIterativoDinamico(long pos){
        long fibos[] = new long[(int)pos+1];
        fibos[0] = 0;
        fibos[1] = 1;
        
        for(int x = 2; x<=pos;x++){
            fibos[x] = fibos[x-1]+fibos[x-2];
        }
           return fibos[(int)pos];  
    }
    
    public static long FiboRecursivoDinamico(long pos){
        if(pos==0 || pos==1)
        {
            return pos ;
        }
        else{
            long n[] = new long[(int) pos+1];
            n[0]=0;
            n[1]=1;
            for(int i= 2;i<=pos;i++)
            {
                n[i]=-1;
            }
            return fiboReDinamico(n,pos);
        }
    }
    
    private static long fiboReDinamico(long[] n, long pos) {
        l++;
        if(n[(int)pos]!=-1)
        { 
            return n[(int)pos];
        }
//        if( (pos==0 || pos==1) || (n[(int)pos!=0 && pos!=0]) )
//        { 
//            return n[(int)pos];
//        }
        else
        {
        n[(int)pos]=fiboReDinamico(n,pos-1)+fiboReDinamico(n,pos-2);
        return n[(int)pos];
        }
    }
}
