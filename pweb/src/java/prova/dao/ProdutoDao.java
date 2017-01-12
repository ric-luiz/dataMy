/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import prova.connectionFactory.ConexaoDao;
import prova.pojo.Produto;

/**
 *
 * @author Dextter
 */
public class ProdutoDao extends ConexaoDao {
    ArrayList<Produto> produtos;  
    
    public ArrayList<Produto> listar(){
        produtos = new ArrayList<Produto>();
        CriarConexao();
        
        try {
            resultado = consulta.executeQuery("SELECT * FROM produto");
            
            while(resultado.next()){
                produtos.add(new Produto(resultado.getInt("id"), 
                        resultado.getString("descricao"), 
                        resultado.getDate("dtValidade"), 
                        resultado.getDouble("preco")));                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
                
        return produtos;
    }
    
    public void inserir(Produto produto){
        CriarConexao();
        try {
            preparacao = conexao.prepareStatement("INSERT INTO `produto`(`descricao`,`dtValidade`, `preco`) VALUES (?,?,?)");
            preparacao.setString(1, produto.getDescricao());
            Date d = new Date (produto.getDtValidade().getTime()+86400000);
            preparacao.setDate(2, d);
            preparacao.setDouble(3, produto.getPreco());            
            preparacao.executeUpdate();            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            fecharConexao();
        }        
    }
    
    public void alterar(Produto produto) throws SQLException{
        preparacao = conexao.prepareStatement("UPDATE `produto` SET `id`=?,`descricao`=?,`dtValidade`=?,`preco`=? WHERE id = ?");
        preparacao.setInt(1, produto.getId());
        preparacao.setString(2, produto.getDescricao());
        
        Date d = new Date (produto.getDtValidade().getTime()+86400000);
        
        preparacao.setDate(3, d);
        preparacao.setDouble(4, produto.getPreco());
        preparacao.setInt(5, produto.getId()); 
        preparacao.executeUpdate();
    }
    
    public void excluir(Produto produto) throws SQLException{
        preparacao = conexao.prepareStatement("DELETE FROM `produto` WHERE `id`=?");
        preparacao.setInt(1, produto.getId()); 
    }
}
