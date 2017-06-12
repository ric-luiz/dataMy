/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.dao;

import com.datamy.main.bean.ComentarioFB;
import com.datamy.main.bean.RespostasBot;
import com.datamy.main.connection.connectionFactory.ConexaoPGDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class ComentarioFBDao extends ConexaoPGDao {
    
    ArrayList<ComentarioFB> comentarios_fb;
    
    public ComentarioFBDao() {
        super();
    }    
    
    public ComentarioFB select(int id) {
        ComentarioFB comentario_fb = null;        
        
        CriarConexao();
        
        try {
            
            preparacao = conexao.prepareStatement("SELECT * FROM teste_json2");            
            resultado = preparacao.executeQuery();            
            
            while (resultado.next()) {                
                comentarios_fb.add(new ComentarioFB(resultado.getString("from_id"), resultado.getString("from_name"), resultado.getString("message"), resultado.getString("created_time"),
                        resultado.getDouble("likes_count"), resultado.getString("comments_count"), resultado.getString("id")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioFBDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
        
        return comentario_fb;
    }
    
    public ArrayList<ComentarioFB> select() {
        ArrayList<ComentarioFB> comentarios_fb = new ArrayList<ComentarioFB>();
        CriarConexao();
        
        try {
            resultado = consulta.executeQuery("SELECT * FROM teste_json2");
            
            while (resultado.next()) {                
                comentarios_fb.add(new ComentarioFB(resultado.getString("from_id"), resultado.getString("from_name"), resultado.getString("message"), resultado.getString("created_time"),
                        resultado.getDouble("likes_count"), resultado.getString("comments_count"), resultado.getString("id")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioFBDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
        
        return comentarios_fb;
    }
    
    public ArrayList<RespostasBot> aceitarResposta() {
        ArrayList<RespostasBot> comments = new ArrayList<RespostasBot>();
        CriarConexao();
        try {
            
            resultado = consulta.executeQuery("SELECT bot_resposta_text FROM bot_respostas WHERE aceita = FALSE");
            while (resultado.next()) {
                comments.add(new RespostasBot(resultado.getInt("id"), resultado.getBoolean("aceita"), resultado.getString("textoPublicacao"), resultado.getString("texto")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioFBDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();            
        }        
        return comments;
    }
    
    public ArrayList<RespostasBot> respostasAceitas() {
        ArrayList<RespostasBot> comments = new ArrayList<RespostasBot>();
        CriarConexao();
        try {
            
            resultado = consulta.executeQuery("SELECT bot_resposta_text FROM bot_respostas WHERE aceita = TRUE");
            while (resultado.next()) {
                comments.add(new RespostasBot(resultado.getInt("id"), resultado.getBoolean("aceita"), resultado.getString("textoPublicacao"), resultado.getString("texto")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioFBDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();            
        }        
        return comments;
    }
    
    public String formular(String comentario, int id) throws SQLException {        
        comentario = "UPDATE bot_resposta SET bot_resposta_text='fora temer' WHERE id = ?";
        preparacao.setInt(1, id);
        try {            
            consulta.executeUpdate(comentario);
            return comentario;
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioFBDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();            
        }  
        return null;
    }
}
