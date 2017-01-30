/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.managebean.graficos;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
 
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;
/**
 *
 * @author Dextter
 */

@ManagedBean
public class BarTwitter implements Serializable {
 
    private BarChartModel barModel;
    private HorizontalBarChartModel horizontalBarModelTwitter;
 
    @PostConstruct
    public void init() {
        createBarModels();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModelTwitter;
    }
     
     
    private void createBarModels() {        
        createHorizontalBarModelTwitter();
    }
         
     
    private void createHorizontalBarModelTwitter() {
        horizontalBarModelTwitter = new HorizontalBarChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Replys");
        
        //laço para percorrer as palavras do array, mostrando a quantidade de ocorrencias e quais foram
        
        
        boys.set("2004", 50);
        boys.set("2005", 96);
        boys.set("2006", 44);
        boys.set("2007", 55);
        boys.set("2008", 25);   
 
        horizontalBarModelTwitter.addSeries(boys);        
         
        horizontalBarModelTwitter.setTitle("Palavras citadas no Twitter");
        horizontalBarModelTwitter.setLegendPosition("e");
        horizontalBarModelTwitter.setStacked(true);
         
        Axis xAxis = horizontalBarModelTwitter.getAxis(AxisType.X);
        xAxis.setLabel("Quantidade");
        xAxis.setMin(0);
        xAxis.setMax(200);
         
        Axis yAxis = horizontalBarModelTwitter.getAxis(AxisType.Y);
        yAxis.setLabel("Palavras");        
    }
 
}
