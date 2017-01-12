/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova.mb;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import prova.dao.ProdutoDao;
import prova.pojo.Produto;

/**
 *
 * @author Dextter
 */
@ManagedBean
@SessionScoped
public class produtoMB {
    
    private Produto produto;
    private ProdutoDao produtoDao;
    private ArrayList<Produto> listaProdutos;
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ProdutoDao getProdutoDao() {
        return produtoDao;
    }

    public void setProdutoDao(ProdutoDao produtoDao) {
        this.produtoDao = produtoDao;
    }

    public ArrayList<Produto> getListaProdutos() {        
        return listaProdutos;
    }

    public void setListaProdutos(ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public produtoMB(Produto produto, ProdutoDao produtoDao, ArrayList<Produto> listaProdutos) {
        this.produto = produto;
        this.produtoDao = produtoDao;
        this.listaProdutos = listaProdutos;
    }

    public produtoMB() {
        this.produto = new Produto();
        listar();
    }
    
    public String cadastrar(){
        produtoDao.inserir(produto);
        return "index.xhtml";
    }
     
    public ArrayList<Produto> listar(){
        this.produtoDao = new ProdutoDao();
        this.listaProdutos = this.produtoDao.listar();
        return listaProdutos;
    }
    
    public void excluir(Produto p) throws SQLException{        
        this.produtoDao.excluir(p);            
    }
    
    public void alterar() throws SQLException{                
        this.produtoDao = new ProdutoDao();
        this.produtoDao.alterar(produto);            
    }
    
    
}
