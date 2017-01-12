/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova.pojo;

import java.util.Date;

/**
 *
 * @author Dextter
 */
public class Produto {
    private int id;
    private String descricao;
    private Date dtValidade;
    private double preco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDtValidade() {
        return dtValidade;
    }

    public void setDtValidade(Date dtValidade) {
        this.dtValidade = dtValidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Produto(int id, String descricao, Date dtValidade, double preco) {
        this.id = id;
        this.descricao = descricao;
        this.dtValidade = dtValidade;
        this.preco = preco;
    }

    public Produto() {
    }
    
    
}
