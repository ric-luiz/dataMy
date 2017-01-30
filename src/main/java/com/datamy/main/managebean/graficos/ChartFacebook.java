/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.managebean.graficos;
import com.datamy.main.bean.Facebook;
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
public class ChartFacebook implements Serializable {    
    private PieChartModel pieModel2;
    private GraficosDAO charts;  
 
    @PostConstruct
    public void init() {        
        createPieModels();
    }

    public ChartFacebook() {
        this.charts = new GraficosDAO();
    }      
     
    public PieChartModel getPieModel2() {
        return pieModel2;
    }
     
    private void createPieModels() {           
         listarFacebook();
    }        
    
    public void listarFacebook() {        
        List<Facebook> listaFB;

        try {
            charts = new GraficosDAO();
            listaFB = charts.getDadosFacebook();
            gerarGraficosFacebook(listaFB);
        } catch (Exception e) {
            
        } finally {
            
        }
    }   
    
    private void gerarGraficosFacebook(List<Facebook> lista) {

        pieModel2 = new PieChartModel();

        for (Facebook f : lista) {
            pieModel2.set("Gostei", f.getGostei());            
            pieModel2.set("Amei", f.getAmei());
            pieModel2.set("Haha", f.getHaha());            
            pieModel2.set("Uou", f.getUou());            
            pieModel2.set("Triste", f.getTriste());            
            pieModel2.set("Grr", f.getRaiva());            
        }
        pieModel2.setTitle("Dados Facebook");
        pieModel2.setLegendPosition("e");        
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(150);
    }
    
}

