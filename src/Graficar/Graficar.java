/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficar;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


/**
 *
 * @author Belmont
 */
public class Graficar {
    
    private JFreeChart grafica;
    private XYSeriesCollection series;
    private String ejeX, ejeY,titulo;

    public Graficar(String ejeX, String ejeY, String titulo) {
        this.grafica = null;
        this.series = new XYSeriesCollection();
        this.ejeX = ejeX;
        this.ejeY = ejeY;
        this.titulo = titulo;
    }
    public void agrearSerie(String nombre){
     XYSeries serie = new XYSeries(nombre);
     this.series.addSeries(serie);
    }
    public void agregarDatoASerie(String nombre, XYDataItem dato){
       this.series.getSeries(nombre).add(dato);
    }
    public void agregarSerie(String nombre, double[] datos){
    
        XYSeries serie = new XYSeries(nombre);
        // agregar cada uno de los datos en la serie 
        for (int x=0; x < datos.length;x++){
            serie.add(x, datos[x]);
        }
        // agregamos la serie que se generó 
        this.series.addSeries(serie);
     
    }
    
    public void crearYmostrarGrafica(){
    
        this.grafica = ChartFactory.createXYLineChart(titulo, ejeX, ejeY, series);
        ChartFrame frame = new ChartFrame("Gráfica Comparación ", grafica);
        frame.setVisible(true);
        
        
    }
    
    
            
    
    
}
