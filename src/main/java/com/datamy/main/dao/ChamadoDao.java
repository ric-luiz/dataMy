/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.dao;

import com.datamy.main.connection.connectionFactory.ConexaoMSQLDao;
import com.datamy.main.bean.Chamado;
import com.datamy.main.bean.ChamadoGraficoDataCount;
import com.datamy.main.bean.Usuario;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dextter
 */
public class ChamadoDao extends ConexaoMSQLDao{
    private UsuarioDao uDao;
    ArrayList<Chamado> chamados;                
    ArrayList<ChamadoGraficoDataCount> chamadosGrafico;                
    
    public ChamadoDao() {       
        super();
        this.uDao = new UsuarioDao();
    }            
    
    /**
     * Select para selecionar um chamado pelo Id
     * @param id
     * @return Chamado
     */
    public Chamado select(int id){
        Chamado chamado = null;        
                
        CriarConexao();
        
        try {
            
            preparacao = conexao.prepareStatement("SELECT * FROM chamado WHERE id=?");
            preparacao.setInt(1, id);            
            resultado = preparacao.executeQuery();                        
            
            while(resultado.next()){                
                chamados.add(new Chamado(resultado.getInt("id"), resultado.getString("titulo"),resultado.getString("tipo") ,resultado.getDate("dataInicio"), 
                        resultado.getDate("dataFim"), resultado.getString("status"), resultado.getString("descricao"), resultado.getString("pathImagem"), uDao.select(resultado.getInt("usuario_id"))));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
                        
        return chamado;
    }
    
    /**
     * Select que retorna a lista de chamados
     * @return ArrayList<Chamado> 
     */
    public ArrayList<Chamado> select(){
        chamados = new ArrayList<Chamado>();
        CriarConexao();
        
        try {
            resultado = consulta.executeQuery("SELECT * FROM chamado WHERE status NOT LIKE 'Finalizado'");
            
            while(resultado.next()){                                
                chamados.add(new Chamado(resultado.getInt("id"), resultado.getString("titulo"),resultado.getString("tipo"), resultado.getDate("dataInicio"), 
                        resultado.getDate("dataFim"), resultado.getString("status"), resultado.getString("descricao"), resultado.getString("pathImagem"), uDao.select(resultado.getInt("usuario_id"))));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
                
        return chamados;
    }
    
    /**
     * Lista os chamados agrupados por dia De Abertura
     */
    public ArrayList<ChamadoGraficoDataCount> selectChamadoRangeDataByDataInicio(){
        chamadosGrafico = new ArrayList<ChamadoGraficoDataCount>();
        CriarConexao();
        
        try {
            
            String sql = "SELECT `dataInicio`,COUNT(*) as Total FROM `chamado` GROUP BY TRUNCATE(`dataInicio`,'DD') ";                                
            
            resultado = consulta.executeQuery(sql);
            
            while(resultado.next()){
                chamadosGrafico.add(new ChamadoGraficoDataCount(resultado.getInt("total"), resultado.getDate("dataInicio")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
                
        return chamadosGrafico;
    }
    
    /**
     * Lista os chamados agrupados por dia Fechado
     */
    public ArrayList<ChamadoGraficoDataCount> selectChamadoRangeDataByDataFim(){
        chamadosGrafico = new ArrayList<ChamadoGraficoDataCount>();
        CriarConexao();
        
        try {
            resultado = consulta.executeQuery("SELECT `dataFim`,COUNT(*) as Total FROM `chamado` GROUP BY TRUNCATE(`dataFim`,'DD')");
            
            while(resultado.next()){                
                ChamadoGraficoDataCount c = new ChamadoGraficoDataCount();
                c.setTotal(resultado.getInt("total"));
                c.setDataFim(resultado.getDate("dataFim"));                
                chamadosGrafico.add(c);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
                
        return chamadosGrafico;
    }
    
    /**
     * Lista Os chamados Agrupados por Tipo
     */
    public ArrayList<ChamadoGraficoDataCount> selectChamadoRangeDataByTipo(){        
        chamadosGrafico = new ArrayList<ChamadoGraficoDataCount>();
        CriarConexao();
        
        try {
            resultado = consulta.executeQuery("SELECT `tipo`,COUNT(*) as total FROM `chamado` GROUP BY `tipo`");
            
            while(resultado.next()){                
                ChamadoGraficoDataCount c = new ChamadoGraficoDataCount();
                c.setTotal(resultado.getInt("total"));
                c.setTipo(resultado.getString("tipo"));
                chamadosGrafico.add(c);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
                
        return chamadosGrafico;
    
    }
    
    /**
     * Lista Os chamados Agrupados por Status
     */
    public ArrayList<ChamadoGraficoDataCount> selectChamadoRangeDataByStatus(){        
        chamadosGrafico = new ArrayList<ChamadoGraficoDataCount>();
        CriarConexao();
        
        try {
            resultado = consulta.executeQuery("SELECT `status`,COUNT(*) as total FROM `chamado` GROUP BY `status`");
            
            while(resultado.next()){                
                ChamadoGraficoDataCount c = new ChamadoGraficoDataCount();
                c.setTotal(resultado.getInt("total"));
                c.setStatus(resultado.getString("status"));
                chamadosGrafico.add(c);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
                
        return chamadosGrafico;
    
    }
    
    /**
     * Atualiza um chamado no banco Sem data Final
     * @param chamado
     */
    public void updateChamado(Chamado chamado){
        CriarConexao();
        try {
            String sql = "UPDATE `chamado` SET `titulo`=?,`dataInicio`=?,`tipo`=?,`status`=?,`descricao`=? WHERE `id`=?";
        
            preparacao = conexao.prepareStatement(sql);
            preparacao.setString(1, chamado.getTitulo());
            preparacao.setDate(2, new Date(chamado.getDataInicio().getTime()));
            preparacao.setString(3, chamado.getTipo());
            preparacao.setString(4, chamado.getStatus());
            preparacao.setString(5, chamado.getDescricao());
            preparacao.setInt(6, chamado.getId());
            
            preparacao.executeUpdate();            
        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            fecharConexao();
        }
    }
    
    /**
     * Atualiza um chamado no banco com a data Final
     * @param chamado
     */
    public void UpdateChamadoDataFim(Chamado chamado){
        CriarConexao();
        try {
            String sql = "UPDATE `chamado` SET `titulo`=?,`dataInicio`=?,`tipo`=?,`dataFim`=?,`status`=?,`descricao`=? WHERE `id`=?";
        
            preparacao = conexao.prepareStatement(sql);
            preparacao.setString(1, chamado.getTitulo());
            preparacao.setDate(2, new Date(chamado.getDataInicio().getTime()));
            preparacao.setString(3, chamado.getTipo());
            preparacao.setDate(4, new Date(chamado.getDataFim().getTime()));
            preparacao.setString(5, chamado.getStatus());
            preparacao.setString(6, chamado.getDescricao());
            preparacao.setInt(7, chamado.getId());
            
            preparacao.executeUpdate();            
        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            fecharConexao();
        }
    }
    
    /**
     * Inserir um chamado no banco
     * @param call
     * @param usr
     */
    public void inserirChamado(Chamado call, Usuario usr){
        CriarConexao();
        try {
            
            preparacao = conexao.prepareStatement("INSERT INTO `chamado`(`titulo`, `tipo`, `descricao`, `usuario_id`) VALUES (?,?,?,?)");         
            preparacao.setString(1, call.getTitulo());
            preparacao.setString(2, call.getTipo());
            preparacao.setString(3, call.getDescricao());
            preparacao.setInt(4, usr.getId());          
            
            preparacao.executeUpdate();            
        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            fecharConexao();
        }        
    }
    
    //Serve somente para teste
    public void inserirChamadoTest(Chamado call, Usuario usr){
        CriarConexao();
        try {
            
            preparacao = conexao.prepareStatement("INSERT INTO `chamado`(`titulo`, `tipo`, `descricao`, `usuario_id`, `dataInicio`, `dataFim`) VALUES (?,?,?,?,?,?)");         
            preparacao.setString(1, call.getTitulo());
            preparacao.setString(2, call.getTipo());
            preparacao.setString(3, call.getDescricao());
            preparacao.setInt(4, usr.getId());          
            preparacao.setDate(5, new Date(call.getDataInicio().getTime()));          
            preparacao.setDate(6, new Date(call.getDataFim().getTime()));          
            
            preparacao.executeUpdate();            
        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            fecharConexao();
        }       
    }
}
