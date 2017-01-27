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
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.PieChartModel;
/**
 *
 * @author Yuri
 */
@ManagedBean
public class Pizza {
    private PieChartModel pieModel1;
    private PieChartModel pieModel2;
    private GraficosDAO charts;
    private Facebook fb;
    private Twitter tt;
 
    @PostConstruct
    public void init() {
        createPieModels();
    }
 
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
     
    public PieChartModel getPieModel2() {
        return pieModel2;
    }
     
    private void createPieModels() {
        createPieModel1();
        createPieModel2();
    }
 
    private void createPieModel1() {
        pieModel1 = new PieChartModel();                 
        
        pieModel1.set("Gostei", 540);
        pieModel1.set("Retweets", 325);
        pieModel1.set("Favorito", 702);
        pieModel1.set("Respostas", 421);
         
        pieModel1.setTitle("Reações no Twitter");
        pieModel1.setLegendPosition("w");
    }
     
    private void createPieModel2() {
        pieModel2 = new PieChartModel();
         
        pieModel2.set("Gostei", 540);
        pieModel2.set("Amei", 325);
        pieModel2.set("Haha", 702);
        pieModel2.set("Triste", 421);
        pieModel2.set("Uou", 461);
        pieModel2.set("Grr", 21);
         
        pieModel2.setTitle("Reações no Facebook");
        pieModel2.setLegendPosition("e");
        pieModel2.setFill(false);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(150);
    }
}
