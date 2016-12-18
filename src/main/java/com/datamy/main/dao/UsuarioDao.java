package com.datamy.main.dao;

import com.datamy.main.bean.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ric_l
 */
public class UsuarioDao extends ConexaoDao{
    ArrayList<Usuario> usuarios;                
    
    public UsuarioDao() {       
        super();
    }
    
    /**
     * Select para selecionar um usuario pelo username e password. Usado para login
     * @return Usuario
     */
    public Usuario select(Usuario user){
        Usuario usuario = null;
        CriarConexao();
        
        try {
            
            preparacao = conexao.prepareStatement("SELECT * FROM usuario WHERE username=? AND password=?");
            preparacao.setString(1,user.getUsername());
            preparacao.setString(2,user.getPassword());
            resultado = preparacao.executeQuery();
            
            while(resultado.next()){
                usuario = new Usuario(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("perfil"), 
                        resultado.getString("status"), resultado.getString("username"), resultado.getString("password"), resultado.getString("email"),resultado.getString("cpf"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
                        
        return usuario;
    }
    
    /**
     * Select para selecionar um usuario pelo Id
     * @return Usuario
     */
    public Usuario select(int id){
        Usuario usuario = null;
        CriarConexao();
        
        try {
            
            preparacao = conexao.prepareStatement("SELECT * FROM usuario WHERE id=?");
            preparacao.setInt(1,id);            
            resultado = preparacao.executeQuery();
            
            while(resultado.next()){
                usuario = new Usuario(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("perfil"), 
                        resultado.getString("status"), resultado.getString("username"), resultado.getString("password"), resultado.getString("email"),resultado.getString("cpf"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
                        
        return usuario;
    }
    
    /**
     * Select que retorna a lista de usuarios
     * @return ArrayList<Usuario> 
     */
    public ArrayList<Usuario> select(){
        usuarios = new ArrayList<Usuario>();
        CriarConexao();
        
        try {
            resultado = consulta.executeQuery("SELECT * FROM usuario");
            
            while(resultado.next()){
                usuarios.add(new Usuario(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("perfil"), 
                        resultado.getString("status"), resultado.getString("username"), resultado.getString("password"), resultado.getString("email"),resultado.getString("cpf")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
                
        return usuarios;
    }
    
    /**
     * Inserir um usuário no banco
     * @param user
     */
    public void insert(Usuario user){
        CriarConexao();
        try {
            preparacao = conexao.prepareStatement("INSERT INTO `usuario`(`nome`,`username`, `password`, `email`, `cpf`) VALUES (?,?,?,?,?)");
            preparacao.setString(1, user.getNome());
            preparacao.setString(2, user.getUsername());
            preparacao.setString(3, user.getPassword());
            preparacao.setString(4, user.getEmail());
            preparacao.setString(5, user.getCpf());
            preparacao.executeUpdate();            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            fecharConexao();
        }        
    }
}
