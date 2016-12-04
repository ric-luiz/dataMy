package br.com.dataMy.DAO;

import br.com.dataMy.beans.CartaoCredito;
import br.com.dataMy.beans.Usuario;
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
            
            preparacao = conexao.prepareStatement("INSERT INTO `cartaocredito`(`nomeTitular`, `numeroCartao`, `usuario_id`) VALUES (?,?,?)");
            preparacao.setString(1, cartao.getNomeTitular());
            preparacao.setString(2, cartao.getNumeroCartao());
            preparacao.setInt(3, cartao.getUserId());
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
                cartoes.add(new CartaoCredito(resultado.getInt("id"), resultado.getString("nomeTitular"), resultado.getString("numeroCartao"), resultado.getInt("usuario_id")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CartaoCreditoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cartoes;
    }
}
