/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.dao;

import com.datamy.main.bean.RelatorioChamados;
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
public class RelatorioChamadosDao extends ConexaoDao{
     ArrayList<RelatorioChamados> relatorios;                
    
    public RelatorioChamadosDao() {       
        super();
    }       
    
    /**
     * Select para selecionar um relatorio de chamado pelo Id
     * @return RelatorioChamados
     */
    public RelatorioChamados select(int id){
        RelatorioChamados relatorio = null;
        CriarConexao();
        
        try {
            
            preparacao = conexao.prepareStatement("SELECT * FROM relatoriochamados WHERE id=?");
            preparacao.setInt(1,id);            
            resultado = preparacao.executeQuery();
            
            while(resultado.next()){
                relatorio = new RelatorioChamados(resultado.getInt("id"), resultado.getString("tipo"), resultado.getDate("dataRelatorio"), resultado.getString("caminhoArquivo"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioChamadosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
                        
        return relatorio;
    }
    
    /**
     * Select que retorna a lista de relatorio de chamados
     * @return ArrayList<RelatorioChamados> 
     */
    public ArrayList<RelatorioChamados> select(){
        relatorios = new ArrayList<RelatorioChamados>();
        CriarConexao();
        
        try {
            resultado = consulta.executeQuery("SELECT * FROM relatoriochamados");
            
            while(resultado.next()){
                relatorios.add(new RelatorioChamados(resultado.getInt("id"), resultado.getString("tipo"), resultado.getDate("dataRelatorio"), resultado.getString("caminhoArquivo")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioChamadosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
                
        return relatorios;
    }
    
    /**
     * Inserir um relatorio no banco
     * @param rel
     */
    public void insert(RelatorioChamados rel){
        CriarConexao();
        try {
            preparacao = conexao.prepareStatement("INSERT INTO `relatoriochamados`(`id`,`tipo`, `dataRelatorioChamado`, `caminhoArquivo`) VALUES (?,?,?,?)");
            preparacao.setInt(1, rel.getId());
            preparacao.setString(2, rel.getTipo());
            preparacao.setDate(3, (Date) rel.getDataRelatorio());
            preparacao.setString(4, rel.getPathArquivo());
            preparacao.executeUpdate();            
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioChamadosDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            fecharConexao();
        }        
    }
}
