/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

/**
 *
 * @author Belmont
 */
public class Recursividad {
   
public int i=0;
    
public double factorial(int n){
    if (n==0)
        return 1;
    else
        return n*(factorial(n-1));
}
public double Multiplicacion (int a, int b,int c){
    if(b==1){
        return a*c;   
    }
    else
    {
        System.out.println("pasos : "+(a*c + Multiplicacion(a,b-1,c))+" : "+i+"\n");
        i++;
        
        return (a*c + Multiplicacion(a,b-1,c)); 
    }
}
}
