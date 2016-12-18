/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dataMy.model.DAO;

import static br.com.dataMy.model.DAO.ConexaoDao.consulta;
import br.com.dataMy.pojo.Chamado;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dextter
 */
public class RelatorioChamadosDao extends ConexaoDao{
    
    public RelatorioChamadosDao(){
        super();
    }
        /**
     * Metodo para acessar o banco de dados e retornar a lista de chamados que 
     * foram feitos
     * @return ArrayList<Usuario> 
     */
    public ArrayList<Chamado> select(){
        ArrayList<Chamado> chamados = new ArrayList<Chamado>();
        
        try {
            resultado = consulta.executeQuery("SELECT * FROM chamado");
            
            while(resultado.next()){
                chamados.add(new Chamado(resultado.getInt("idChamado"),
                                      resultado.getString("titulo"),                                      
                                      resultado.getDate("dataInicio"),
                                      resultado.getDate("dataFim"),
                                      resultado.getString("status"),
                                      resultado.getString("descricao"),
                                      resultado.getString("pathImagem"),
                                      resultado.getInt("idUsuario"),
                                      resultado.getInt("idRelatorioChamados")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return chamados;
    }
    
    /**
     * Metodo para acessar a tabela relatoriochamados do banco de dados que é capaz
     * de retornar as informações de um chamado usando o seu idChamado 
     * @return Chamado
     */
    
    public Chamado select(Chamado call){
        Chamado chamado = null;
        
        try {
            
            preparacao = conexao.prepareStatement("SELECT * FROM relatoriochamados WHERE idChamado = ?");
            preparacao.setInt(1, call.getIdChamado());
            resultado = preparacao.executeQuery();
            
            while(resultado.next()){
                chamado = new Chamado(resultado.getInt("idChamado"),
                                      resultado.getString("titulo"),                                      
                                      resultado.getDate("dataInicio"),
                                      resultado.getDate("dataFim"),
                                      resultado.getString("status"),
                                      resultado.getString("descricao"),
                                      resultado.getString("pathImagem"),
                                      resultado.getInt("idUsuario"),
                                      resultado.getInt("idRelatorioChamados"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return chamado;
    }
}
