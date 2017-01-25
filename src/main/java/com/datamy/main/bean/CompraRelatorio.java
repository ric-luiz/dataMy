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
    private String tipo;

    public CompraRelatorio(int id, double valorCompra, int numeroParcelas, int quantidade, Date dataCompraRelatorio, Usuario user) {
        this.id = id;
        this.valorCompra = valorCompra;
        this.numeroParcelas = numeroParcelas;
        this.quantidade = quantidade;
        this.dataCompraRelatorio = dataCompraRelatorio;
        this.user = user;
        tipoCompra();
    }
            
    public CompraRelatorio() {
    }
    
    //Diz que tipo de relatorio foi comprado. Informação n pertence ao banco de dados
    private void tipoCompra(){
        if(this.valorCompra == 200.00){
            tipo = "Bronze";
        } else if(this.valorCompra == 400.00){
            tipo = "Silver";
        } else if(this.valorCompra == 800.00){
            tipo = "Gold";
        }
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
        
}
