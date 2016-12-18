package com.datamy.main.bean;

import java.util.Date;

/**
 *
 * @author ric_l
 */
public class CompraCredito {
    private int id;
    private int valorComprado;
    private Date dataCompra;
    private int numeroParcelas;
    private Usuario user;

    public CompraCredito(int id, int valorComprado, Date dataCompra, int numeroParcelas, Usuario user) {
        this.id = id;
        this.valorComprado = valorComprado;
        this.dataCompra = dataCompra;
        this.numeroParcelas = numeroParcelas;
        this.user = user;
    }

    public CompraCredito() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValorComprado() {
        return valorComprado;
    }

    public void setValorComprado(int valorComprado) {
        this.valorComprado = valorComprado;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }    

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }    
}
