package com.datamy.main.bean;

/**
 *
 * @author ric_l
 */
public class CartaoCredito {
    private int id;
    private String nomeTitular;
    private String numeroCartao;
    private Usuario user;
    private int codigoSeguranca;
    
    public CartaoCredito(int id, String nomeTitular, String numeroCartao, Usuario user) {
        this.id = id;
        this.nomeTitular = nomeTitular;
        this.numeroCartao = numeroCartao;
        this.user = user;
    }

    public CartaoCredito() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }    

    public int getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(int codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }
       
}
