/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.managebean.graficos;
import com.datamy.main.bean.Twitter;
import com.datamy.main.dao.GraficosDAO;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.PieChartModel;
/**
 *
 * @author Yuri
 */
@ManagedBean 
public class ChartTwitter implements Serializable {
    private PieChartModel pieModel1;    
    private GraficosDAO charts;  
 
    @PostConstruct
    public void init() {        
        createPieModels();
    }

    public ChartTwitter() {
        this.charts = new GraficosDAO();
    }
   
    public PieChartModel getPieModel1() {
        return pieModel1;
    }       
     
    private void createPieModels() {  
         listarTwitter();
    }
    
    public void listarTwitter() {        
        List<Twitter> lista;

        try {
            charts = new GraficosDAO();
            lista = charts.getDadosTwitter();
            gerarGraficosTwitter(lista);
        } catch (Exception e) {
            
        } finally {
            
        }
    }  

    private void gerarGraficosTwitter(List<Twitter> lista) {

        pieModel1 = new PieChartModel();

        for (Twitter t : lista) {
            pieModel1.set("Gostei", t.getCurtidas());            
            pieModel1.set("Retweets", t.getRetweets());
            pieModel1.set("Falando sobre", t.getFalandoSobre());            
        }
        pieModel1.setTitle("Dados Twitter");
        pieModel1.setLegendPosition("w");
        pieModel1.setFill(false);
        pieModel1.setShowDataLabels(true);
        pieModel1.setDiameter(150);
    }
    
    
}

