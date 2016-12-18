package br.com.dataMy.beans;

import java.util.Date;

/**
 *
 * @author ric_l
 */
public class CompraCredito {
    private int idCompraCredito;
    private int valorComprado;
    private Date dataCompra;
    private int usuarioId;

    public CompraCredito(int idCompraCredito, int valorComprado, Date dataCompra, int usuarioId) {
        this.idCompraCredito = idCompraCredito;
        this.valorComprado = valorComprado;
        this.dataCompra = dataCompra;        
        this.usuarioId = usuarioId;
    }

    public CompraCredito() {
    }
    
    public int getId() {
        return idCompraCredito;
    }

    public void setId(int idCompraCredito) {
        this.idCompraCredito = idCompraCredito;
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
  
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    
}
