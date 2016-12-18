package com.datamy.main.bean;

import java.util.Date;

/**
 *
 * @author ric_l
 */
public class CompraRelatorio {
    private int id;
    private double valorRelatorio;
    private Date dataCompraRelatorio;
    private Usuario user;

    public CompraRelatorio(int id, double valorRelatorio, Date dataCompraRelatorio, Usuario user) {
        this.id = id;
        this.valorRelatorio = valorRelatorio;
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

    public double getValorRelatorio() {
        return valorRelatorio;
    }

    public void setValorRelatorio(double valorRelatorio) {
        this.valorRelatorio = valorRelatorio;
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
        
}
