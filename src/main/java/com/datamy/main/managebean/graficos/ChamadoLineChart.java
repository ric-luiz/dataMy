package com.datamy.main.managebean.graficos;

import com.datamy.main.bean.Chamado;
import com.datamy.main.bean.ChamadoGraficoDataCount;
import com.datamy.main.bean.Usuario;
import com.datamy.main.dao.ChamadoDao;
import java.util.ArrayList;
import java.util.Date;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author ricardo
 */
public class ChamadoLineChart {
    
    private LineChartModel chamadoPorDiaAberto;
    private LineChartModel chamadosPorDiaFechado;
    private PieChartModel chamadoPorTipo;
    private PieChartModel chamadoPorstatus;
    
    private ChamadoDao cDao;

    public ChamadoLineChart() {
        this.cDao = new ChamadoDao();  
//        popularChamados();
    }
    
    public void criarGraficoLinePorDiaAbereto(){
        this.chamadoPorDiaAberto = initChamadoPorDiaAberto();
        this.chamadoPorDiaAberto.setTitle("Chamados Abertos Por Dia");
        this.chamadoPorDiaAberto.setLegendPosition("e");              
    }
    
    public void criarGraficoLinePorDiaFechado(){
        this.chamadosPorDiaFechado = initChamadoPorDiaFechado();
        this.chamadosPorDiaFechado.setTitle("Chamados Fechados Por Dia");
        this.chamadosPorDiaFechado.setLegendPosition("e");     
    }
    
    public void criarGraficoPieTipo(){
        ArrayList<ChamadoGraficoDataCount> chamados = cDao.selectChamadoRangeDataByTipo();
        
        this.chamadoPorTipo = new PieChartModel();
        
        //preenche com as informações do banco
        for(ChamadoGraficoDataCount c : chamados){
            chamadoPorTipo.set(c.getTipo(), c.getTotal());
        }      
        
        chamadoPorTipo.setTitle("Chamados Por Tipo");
        chamadoPorTipo.setLegendPosition("w");
    }
    
    public void criarGraficoPieStatus(){
        ArrayList<ChamadoGraficoDataCount> chamados = cDao.selectChamadoRangeDataByStatus();
        
        this.chamadoPorstatus = new PieChartModel();
        
        //preenche com as informações do banco
        for(ChamadoGraficoDataCount c : chamados){
            chamadoPorstatus.set(c.getStatus(), c.getTotal());
        }         
        
        chamadoPorstatus.setTitle("Chamados Por Status");
        chamadoPorstatus.setLegendPosition("w");
    }
    
    private LineChartModel initChamadoPorDiaAberto(){
        ArrayList<ChamadoGraficoDataCount> chamados = cDao.selectChamadoRangeDataByDataInicio();
        
        LineChartModel modelo = new LineChartModel();
        
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Numero Chamados");
        
        //preenche com as informações do banco
        for(ChamadoGraficoDataCount c : chamados){
            series1.set(c.getDataInicio(), c.getTotal());
        }
        
        modelo.addSeries(series1);

        return modelo;
    }
    
    private LineChartModel initChamadoPorDiaFechado(){
        ArrayList<ChamadoGraficoDataCount> chamados = cDao.selectChamadoRangeDataByDataFim();
        
        LineChartModel modelo = new LineChartModel();
        
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Numero Chamados");
        //preenche com as informações do banco
        for(ChamadoGraficoDataCount c : chamados){
            series1.set(c.getDataFim(), c.getTotal());
        }
        
        modelo.addSeries(series1);

        return modelo;
    }        

    /*######################### GET & SET ########################################*/
    public LineChartModel getChamadoPorDiaAberto() {
        return chamadoPorDiaAberto;
    }
    
    public void setChamadoPorDiaAberto(LineChartModel chamadoPorDia) {
        this.chamadoPorDiaAberto = chamadoPorDia;
    }

    public LineChartModel getChamadosPorDiaFechado() {
        return chamadosPorDiaFechado;
    }

    public void setChamadosPorDiaFechado(LineChartModel chamadosPorDiaFechado) {
        this.chamadosPorDiaFechado = chamadosPorDiaFechado;
    }

    public PieChartModel getChamadoPorTipo() {
        return chamadoPorTipo;
    }

    public void setChamadoPorTipo(PieChartModel chamadoPorTipo) {
        this.chamadoPorTipo = chamadoPorTipo;
    }

    public PieChartModel getChamadoPorstatus() {
        return chamadoPorstatus;
    }

    public void setChamadoPorstatus(PieChartModel chamadoPorstatus) {
        this.chamadoPorstatus = chamadoPorstatus;
    }
     
    //Server Somente para teste
    private void popularChamados(){
        Date atual = new Date();
        
        for (int i=10;i<16;i++){
            Chamado c = new Chamado();
            c.setTitulo("Suporte "+i);
            c.setDescricao("Suporte "+i);
            c.setTipo("Pagamento");            
            c.setDataInicio(new Date(atual.getTime()+86400000*i));
            c.setDataFim(new Date(atual.getTime()+432000000*i));
            
            Usuario u = new Usuario();
            u.setId(1);
            
            cDao.inserirChamadoTest(c, u);
        }        
    }
    
}
