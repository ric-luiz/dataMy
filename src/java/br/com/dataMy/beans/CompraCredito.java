package br.com.dataMy.beans;

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
    private int usuarioId;

    public CompraCredito(int id, int valorComprado, Date dataCompra, int numeroParcelas, int usuarioId) {
        this.id = id;
        this.valorComprado = valorComprado;
        this.dataCompra = dataCompra;
        this.numeroParcelas = numeroParcelas;
        this.usuarioId = usuarioId;
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

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    
}
