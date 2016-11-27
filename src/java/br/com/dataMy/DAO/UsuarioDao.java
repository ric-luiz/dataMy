package br.com.dataMy.DAO;

import br.com.dataMy.beans.Usuario;
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
        
        try {
            
            preparacao = conexao.prepareStatement("SELECT * FROM usuario WHERE username=? AND password=?");
            preparacao.setString(1,user.getUsername());
            preparacao.setString(2,user.getPassword());
            resultado = preparacao.executeQuery();
            
            while(resultado.next()){
                usuario = new Usuario(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("perfil"), 
                        resultado.getString("status"), resultado.getString("username"), resultado.getString("password"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuario;
    }
    
    /**
     * Select que retorna a lista de usuarios
     * @return ArrayList<Usuario> 
     */
    public ArrayList<Usuario> select(){
        usuarios = new ArrayList<Usuario>();
        
        try {
            resultado = consulta.executeQuery("SELECT * FROM usuario");
            
            while(resultado.next()){
                usuarios.add(new Usuario(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("perfil"), 
                        resultado.getString("status"), resultado.getString("username"), resultado.getString("password")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuarios;
    }
}
