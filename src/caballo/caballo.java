/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caballo;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Belmont
 */
public class caballo {
    
    public int numFilas;
    public int numColumnas;
    public int num;
    int[][] tablero;
    int[][] tableroC;
    
    public caballo(int filas, int columnas) {
        this.numFilas = filas;
        this.numColumnas = columnas;
        this.num=1;
        this.tablero  = new int[filas][columnas];
        tipoMatrizCostes(columnas);
    }
    
    public void resolverProblema(int f, int c) 
    {       
        int fila = f;
        int columna = c;
            for(int x=0 ; x<numFilas*numColumnas;x++)
            {
                tablero[fila][columna] = num;                
                int[][] posibles = buscarPosibles(fila, columna);
                if(posibles.length>0)
                {
                    //int intent = ThreadLocalRandom.current().nextInt(0, posibles.length-1);
                    int menor = tableroC[posibles[0][0]][posibles[0][1]];
                    forBusqueda :for(int i=0; i<posibles.length;i++)
                    //forBusqueda :for(int i=posibles.length-1; i>=0;i--)
                    {
                        if(menor <= tableroC[posibles[i][0]][posibles[i][1]])
                        {
                            menor = tableroC[posibles[i][0]][posibles[i][1]];
                            num++;
                            fila=posibles[i][0];
                            columna=posibles[i][1];                       
                            break forBusqueda;
                        }
                    }
                }
                //tablero[f][c]=0;
            }
            
            if(num==numFilas*numColumnas)
            {
                System.out.println("---------Tiene solucion------------");
            }
            else
            {
                System.out.println("------No Tiene Solucion------------");
            }

    }
    
    int[][] buscarPosibles(int f, int c) {
        
        int[][] resp = new int[8][2];
        int pos  = 0;
        if(esValido(f-2,c-1))
        { 
            resp[pos][0]=f-2; 
            resp[pos++][1]=c-1; 
        }
        if(esValido(f-2,c+1))
        { 
            resp[pos][0]=f-2; 
            resp[pos++][1]=c+1; 
        }
        if(esValido(f-1,c-2))
        { 
            resp[pos][0]=f-1; 
            resp[pos++][1]=c-2; 
        }
        if(esValido(f-1,c+2))
        { 
            resp[pos][0]=f-1; 
            resp[pos++][1]=c+2; 
        }
        if(esValido(f+1,c-2))
        { 
            resp[pos][0]=f+1; 
            resp[pos++][1]=c-2; 
        }
        if(esValido(f+1,c+2))
        { 
            resp[pos][0]=f+1; 
            resp[pos++][1]=c+2; 
        }
        if(esValido(f+2,c-1))
        { 
            resp[pos][0]=f+2; 
            resp[pos++][1]=c-1; 
        }
        if(esValido(f+2,c+1))
        { 
            resp[pos][0]=f+2; 
            resp[pos++][1]=c+1; 
        }
        
        int[][] tmp = new int[pos][2];
        
        for(int i=0; i<pos; i++) 
        { 
            tmp[i][0] = resp[i][0]; 
            tmp[i][1]=resp[i][1]; 
        }
        
        return tmp;
    }
 
    boolean esValido(int f, int c) {
        if(f<0 || f>numFilas-1 || c<0 || c>numColumnas-1)
        {
            return false;
        }
        
        if(tablero[f][c]!=0)
        {
            return false;
        }
        
        return true;
    }
    
    public void tipoMatrizCostes(int opc)
    {
        switch(opc)
        {
            case 4:
                tableroC= new int[][]{{2,3,3,2},{3,4,4,3},{3,4,4,3},{2,3,3,2}};
                break;
            case 5:
                tableroC= new int[][]{{2,3,4,3,2},{3,4,6,4,3},{4,6,8,6,4},{3,4,6,4,3},{2,3,4,3,2}};
                break;
            case 6:
                tableroC= new int[][]{{2,3,4,4,3,2},{3,4,6,6,4,3},{4,6,8,8,6,4},{4,6,8,8,6,4},{3,4,6,6,4,3},{2,3,4,4,3,2}};
                break;
            case 7:
                tableroC= new int[][]{{2,3,4,4,4,3,2},{3,4,6,6,6,4,3},{4,6,8,8,8,6,4},{4,6,8,8,8,6,4},{4,6,8,8,8,6,4},{3,4,6,6,6,4,3},{2,3,4,4,4,3,2}};
                break;
            case 8:
                tableroC= new int[][]{{2,3,4,4,4,4,3,2},{3,4,6,6,6,6,4,3},{4,6,8,8,8,8,6,4},{4,6,8,8,8,8,6,4},{4,6,8,8,8,8,6,4},{4,6,8,8,8,8,6,4},{3,4,6,6,6,6,4,3},{2,3,4,4,4,4,3,2}};
                break;
        }
    }
    
        public void mostrarTablero() {
        for(int i=0; i<tablero.length; i++) 
        {
            for(int j=0; j<tablero[i].length; j++) 
            {
                System.out.printf("  %2d  |", tablero[i][j]);
            }
            System.out.println();
            for(int j=0; j<tablero[i].length; j++)
            {
                System.out.print("------+");
            }
            System.out.println();
        }
    }
}
