package br.com.dataMy.model.DAO;

import br.com.dataMy.beans.CartaoCredito;
import br.com.dataMy.pojo.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ric_l
 */
public class CartaoCreditoDao extends ConexaoDao{
    
    /**
     * Insert de um cartao de credito no banco
     */
    public void insert(CartaoCredito cartao){
        try {
            
            preparacao = conexao.prepareStatement("INSERT INTO `cartaocredito`(`numero`, `usuario_id`) VALUES (?,?)");            
            preparacao.setString(1, cartao.getNumeroCartao());
            preparacao.setInt(2, cartao.getUserId());
            preparacao.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Retorna uma lista de cartões associados a um usuário
     */
    public ArrayList<CartaoCredito> select(Usuario user){
        ArrayList<CartaoCredito> cartoes = new ArrayList<CartaoCredito>();
        
        try {                        
            
            preparacao = conexao.prepareStatement("SELECT * FROM cartaocredito WHERE usuario_id = ?");
            preparacao.setInt(1, user.getId());
            resultado = preparacao.executeQuery();
            
            while(resultado.next()){
                cartoes.add(new CartaoCredito(resultado.getInt("idCartaoCredito"), 
                        resultado.getString("numero"), 
                        resultado.getInt("usuario_id")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CartaoCreditoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cartoes;
    }
}
