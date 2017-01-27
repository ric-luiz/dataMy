/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.dao;

import com.datamy.main.bean.Chamado;
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
public class ChamadoDao extends ConexaoDao{
    private UsuarioDao uDao;
    ArrayList<Chamado> chamados;                
    
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
            resultado = consulta.executeQuery("SELECT * FROM chamado");
            
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
     * Inserir um chamado no banco
     * @param call
     * @param usr
     * @param rc
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
}
