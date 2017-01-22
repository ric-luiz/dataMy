package com.datamy.main.bean;

import java.util.Date;

/**
 *
 * @author ric_l
 */
public class CompraRelatorio {
    private int id;
    private double valorCompra;
    private int numeroParcelas;
    private int quantidade;
    private Date dataCompraRelatorio;    
    private Usuario user;

    public CompraRelatorio(int id, double valorRelatorio, Date dataCompraRelatorio, Usuario user) {
        this.id = id;
        this.valorCompra = valorRelatorio;
        this.dataCompraRelatorio = dataCompraRelatorio;
        this.user = user;
    }

    public CompraRelatorio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }
    
    public Date getDataCompraRelatorio() {
        return dataCompraRelatorio;
    }

    public void setDataCompraRelatorio(Date dataCompraRelatorio) {
        this.dataCompraRelatorio = dataCompraRelatorio;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
        
}
