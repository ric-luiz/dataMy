/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.managebean.graficos;

import com.datamy.main.bean.Facebook;
import com.datamy.main.bean.Twitter;
import com.datamy.main.dao.GraficosDAO;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;
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
    private GraficosDAO charts;
    private BarChartModel barModel;
    private HorizontalBarChartModel horizontalBarModelTwitter;
 
    @PostConstruct
    public void init() {
        createBarModels();
    }
    
    public BarTwitter(){
        this.charts = new GraficosDAO();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModelTwitter;
    }
     
     
    private void createBarModels() {        
        listarTwitter();
    }
    
    public void listarTwitter() {        
        List<Twitter> lista;

        try {
            charts = new GraficosDAO();
            lista = charts.getDadosTwitter();
            createHorizontalBarModelTwitter(lista);
        } catch (Exception e) {
            
        } finally {
            
        }
    }
     
    private void createHorizontalBarModelTwitter(List<Twitter> lista) {
        horizontalBarModelTwitter = new HorizontalBarChartModel();
        int maior = 0;
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Replys");
        
        //laço para percorrer as palavras do array, mostrando a quantidade de ocorrencias e quais foram
        for(Twitter fb:lista){            
            String comentarios = fb.getReplys();            
            String[] parts = comentarios.split(" ");
            for (String part : parts) {
                int ocorrencias = 0;
                for(String part2 : parts){
                    if (part == null ? part2 == null : part.equals(part2)){
                        ocorrencias++;
                        if (ocorrencias > maior)
                            maior = ocorrencias;
                    }
                }
                boys.set(part, ocorrencias);                
            }                        
        }                    
        horizontalBarModelTwitter.addSeries(boys);                 
        horizontalBarModelTwitter.setTitle("Palavras citadas no Twitter");
        horizontalBarModelTwitter.setLegendPosition("e");
        horizontalBarModelTwitter.setStacked(true);
         
        Axis xAxis = horizontalBarModelTwitter.getAxis(AxisType.X);
        xAxis.setLabel("Quantidade de ocorrências");
        xAxis.setMin(0);
        xAxis.setMax(maior+10);
         
        Axis yAxis = horizontalBarModelTwitter.getAxis(AxisType.Y);
        yAxis.setLabel("Palavras");        
    }
 
}
