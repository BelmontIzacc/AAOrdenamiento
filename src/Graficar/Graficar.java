/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficar;

import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.nfunk.jep.JEP;

/**
 *
 * @author Belmont
 */
public class Graficar {
    
    private boolean graf;
    private JFreeChart grafica;
    private XYSeriesCollection coleccion;
    private String tituloGrafica, axisXlabel, axisYlabel;
    
     public Graficar() {
        this.tituloGrafica = "Algoritmos Burbuja";
        this.axisXlabel = "Numero de Valores";
        this.axisYlabel = "Timepo Total";
        this.coleccion = new XYSeriesCollection();
        this.grafica = null;
    }

    public boolean isGraf() {
        return graf;
    }

    public void setGraf(boolean graf) {
        this.graf = graf;
    }
        
    @SuppressWarnings("empty-statement")
    public void agregarSerie(double[] XX,double[] YY, double[] auc){
       
//       System.out.println("Valores para la funcion: ");
//        System.out.println("X->"+XX);
//        System.out.println("Y->"+YY);
        
        
        XYSeries serie = new XYSeries("Burbuja");
        XYSeries func = new XYSeries("Burbuja Optimizado");

        for(int i=0;i<XX.length;i++){
        serie.add(XX[i],YY[i]);
        func.add(XX[i],auc[i]);
    }
          
    
        this.coleccion.addSeries(serie);
        this.coleccion.addSeries(func);
       
    }
    
     public void mostrarGrafica() {
        // Crear la serie con los datos
        grafica = ChartFactory.createXYLineChart(this.tituloGrafica,
                this.axisXlabel, 
                this.axisYlabel, coleccion, PlotOrientation.VERTICAL, true, true, true);
              
        ChartFrame panel = new ChartFrame(null, grafica);
        panel.pack();
        panel.setVisible(true);
        
    }
    
    
    public void removeSeries(){
        this.coleccion.removeAllSeries();
    }
}
