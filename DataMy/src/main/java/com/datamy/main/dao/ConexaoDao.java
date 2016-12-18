package com.datamy.main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ric_l
 */
public class ConexaoDao{
    
    protected static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    protected static final String BANCO = "jdbc:mysql://localhost:3306/dataMy";
    
    protected static final String USER = "root";
    protected static final String PASS = "";
    
    protected Statement consulta;
    protected ResultSet resultado;
    protected PreparedStatement preparacao;
    protected Connection conexao;

    protected void CriarConexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = DriverManager.getConnection(BANCO, USER, PASS);
            consulta = conexao.createStatement();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void fecharConexao(){
        try {            
            conexao.close();            
            fecharPreparedStatement();
            fecharResultSet();
            fecharStatement();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fecharStatement(){
        if(consulta != null){
            try {
                consulta.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void fecharPreparedStatement(){
        if(preparacao != null){
            try {
                preparacao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void fecharResultSet(){
        if(resultado != null){
            try {
                resultado.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
