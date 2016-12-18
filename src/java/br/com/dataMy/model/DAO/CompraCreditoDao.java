package br.com.dataMy.model.DAO;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.dataMy.beans.CompraCredito;
import java.sql.Date;

/**
 *
 * @author ric_l
 */
public class CompraCreditoDao extends ConexaoDao{
    
    /**
     * Insere uma compra no bancod
     */
    public void insert(CompraCredito compra){
        try {
            
            preparacao = conexao.prepareStatement("INSERT INTO `compracredito`(`valorComprado`, `dataCompra`, `usuario_id`) VALUES (?,?,?)");
            preparacao.setInt(1, compra.getValorComprado());
            preparacao.setDate(2, (Date) compra.getDataCompra());
            preparacao.setInt(3,compra.getUsuarioId());
            preparacao.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
