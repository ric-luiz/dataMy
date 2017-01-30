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
public class BarFacebook implements Serializable {
    private GraficosDAO charts;
    private BarChartModel barModel;
    private HorizontalBarChartModel horizontalBarModelTwitter;
 
    @PostConstruct
    public void init() {
        createBarModels();
    }
    
    public BarFacebook(){
        this.charts = new GraficosDAO();
    }
    
    public BarChartModel getBarModel() {
        return barModel;
    }
     
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModelTwitter;
    }
     
     
    private void createBarModels() {        
        listarFacebook();
    }
         
    public void listarFacebook() {        
        List<Facebook> lista;

        try {
            charts = new GraficosDAO();
            lista = charts.getDadosFacebook();
            createHorizontalBarModelFacebook(lista);
        } catch (Exception e) {
            
        } finally {
            
        }
    }
    
    private void createHorizontalBarModelFacebook(List<Facebook> lista) {
        horizontalBarModelTwitter = new HorizontalBarChartModel();        
        String palavras [];
        ChartSeries boys = new ChartSeries(); 
        boys.setLabel("Comentários");
        
        //laço para percorrer as palavras do array, mostrando a quantidade de ocorrencias e quais foram
        for(Facebook fb:lista){
            
        }
        
        
        
        boys.set("2004", 50);
        boys.set("2005", 96);
        boys.set("2006", 44);
        boys.set("2007", 55);
        boys.set("2008", 25);
         
 
        horizontalBarModelTwitter.addSeries(boys);        
         
        horizontalBarModelTwitter.setTitle("Palavras citadas no Facebook");
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
