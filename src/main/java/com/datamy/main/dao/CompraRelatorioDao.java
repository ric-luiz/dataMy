package com.datamy.main.dao;

import com.datamy.main.connection.connectionFactory.ConexaoMSQLDao;
import com.datamy.main.bean.CompraRelatorio;
import com.datamy.main.bean.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ric_l
 */
public class CompraRelatorioDao extends ConexaoMSQLDao{
    
    private UsuarioDao uDao;
    
    /**
     * Insere uma compra no bancod
     */
    public void insert(CompraRelatorio compra){
        CriarConexao();
        
        try {
            
            preparacao = conexao.prepareStatement("INSERT INTO comprarelatorio (usuario_id,valorCompra,parcelas,quantidade) VALUES (?,?,?,?)");            
            preparacao.setDouble(1, compra.getUser().getId());
            preparacao.setDouble(2, compra.getValorCompra());            
            preparacao.setDouble(3, compra.getNumeroParcelas());            
            preparacao.setDouble(4, compra.getQuantidade());            
            preparacao.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
    }
    
    /**
     * Retorna uma lista de compras de um usuario
     */
    public ArrayList<CompraRelatorio> getComprasRelatorios(Usuario user){
        CriarConexao();
        ArrayList<CompraRelatorio> compras = new ArrayList<CompraRelatorio>();
        uDao = new UsuarioDao();
        
        try {
            resultado = consulta.executeQuery("SELECT * FROM comprarelatorio WHERE usuario_id = "+user.getId());
            
            while(resultado.next()){
                compras.add(new CompraRelatorio(
                        resultado.getInt("id"), 
                        resultado.getDouble("valorCompra"), 
                        resultado.getInt("parcelas"), 
                        resultado.getInt("quantidade"), 
                        resultado.getDate("dataCompraRelatorio"), 
                        uDao.select(user.getId()))
                );
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
        
        return compras;
    }
}
