package com.datamy.main.dao;

import com.datamy.main.connection.connectionFactory.ConexaoPGDao;
import com.datamy.main.bean.CartaoCredito;
import com.datamy.main.bean.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ric_l
 */
public class CartaoCreditoDao extends ConexaoPGDao{
    
    private UsuarioDao uDao;

    public CartaoCreditoDao() {
        this.uDao = new UsuarioDao();
    }
        
    
    /**
     * Insert de um cartao de credito no banco
     */
    public void insert(CartaoCredito cartao){
        CriarConexao();
        try {
            
            preparacao = conexao.prepareStatement("INSERT INTO `cartaocredito`(`nomeTitular`, `numero`, `usuario_id`) VALUES (?,?,?)");
            preparacao.setString(1, cartao.getNomeTitular());
            preparacao.setString(2, cartao.getNumeroCartao());
            preparacao.setInt(3, cartao.getUser().getId());
            preparacao.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
    }
    
    /**
     * Retorna uma lista de cartões associados a um usuário
     */
    public ArrayList<CartaoCredito> select(Usuario user){
        ArrayList<CartaoCredito> cartoes = new ArrayList<CartaoCredito>();
        CriarConexao();
        
        try {                        
            
            preparacao = conexao.prepareStatement("SELECT * FROM cartaocredito WHERE usuario_id = ?");
            preparacao.setInt(1, user.getId());
            resultado = preparacao.executeQuery();
            
            while(resultado.next()){
                cartoes.add(new CartaoCredito(resultado.getInt("id"), resultado.getString("nomeTitular"), resultado.getString("numeroCartao"), uDao.select(resultado.getInt("usuario_id"))));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CartaoCreditoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
        
        return cartoes;
    }
    
    /**
     * Retorna uma lista de cartões Pelo Numero do Cartao
     */
    public ArrayList<CartaoCredito> select(CartaoCredito cartao){
        ArrayList<CartaoCredito> cartoes = new ArrayList<CartaoCredito>();
        CriarConexao();
        
        try {                        
            
            preparacao = conexao.prepareStatement("SELECT * FROM cartaocredito WHERE numero = ?");
            preparacao.setInt(1, Integer.parseInt(cartao.getNumeroCartao()));
            resultado = preparacao.executeQuery();
            
            while(resultado.next()){
                cartoes.add(new CartaoCredito(resultado.getInt("id"), resultado.getString("nomeTitular"), resultado.getString("numero"), uDao.select(resultado.getInt("usuario_id"))));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CartaoCreditoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
        
        return cartoes;
    }
}
