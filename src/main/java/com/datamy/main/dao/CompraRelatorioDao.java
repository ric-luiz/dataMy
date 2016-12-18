package com.datamy.main.dao;

import com.datamy.main.bean.CompraRelatorio;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ric_l
 */
public class CompraRelatorioDao extends ConexaoDao{
    
    /**
     * Insere uma compra no bancod
     */
    public void insert(CompraRelatorio compra){
        CriarConexao();
        
        try {
            
            preparacao = conexao.prepareStatement("INSERT INTO `comprarelatorio`(`valorRelatorio`,`usuario_id`) VALUES (?,?)");
            preparacao.setDouble(1, compra.getValorRelatorio());            
            preparacao.setDouble(2, compra.getUser().getId());
            preparacao.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
    }
        
}
