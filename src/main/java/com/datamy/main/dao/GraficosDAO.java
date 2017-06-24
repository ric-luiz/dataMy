/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.dao;

import com.datamy.main.connection.connectionFactory.ConexaoPGDao;
import com.datamy.main.bean.CompraRelatorio;
import com.datamy.main.bean.Estatistica;
import com.datamy.main.bean.Facebook;
import com.datamy.main.bean.Twitter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GraficosDAO extends ConexaoPGDao {
    public ArrayList<Twitter> getDadosTwitter(){
        
        CriarConexao();
        ArrayList<Twitter> dadosTwitter = new ArrayList<Twitter>();
        try {
            
            preparacao = conexao.prepareStatement("SELECT * FROM twitter");            
            resultado = preparacao.executeQuery();
            
            while(resultado.next()){
                dadosTwitter.add(new Twitter(resultado.getInt("idDadosTwitter"), 
                        resultado.getInt("curtidas"),
                        resultado.getInt("retweets"), 
                        resultado.getInt("falandoSobre"),
                        resultado.getString("replys")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GraficosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
        
        return dadosTwitter;
    }
    
    public ArrayList<Facebook> getDadosFacebook(){
        
        CriarConexao();
        ArrayList<Facebook> dadosFacebook = new ArrayList<Facebook>();
        try {
            
            preparacao = conexao.prepareStatement("SELECT * FROM facebook");            
            resultado = preparacao.executeQuery();
            
            while(resultado.next()){
                dadosFacebook.add(new Facebook(resultado.getInt("idDadosFacebook"), 
                        resultado.getInt("gostei"),
                        resultado.getInt("amei"), 
                        resultado.getInt("haha"),
                        resultado.getInt("triste"), 
                        resultado.getInt("raiva"), 
                        resultado.getInt("uou"), 
                        resultado.getString("comentarios")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GraficosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
        
        return dadosFacebook;
    }
    
}
