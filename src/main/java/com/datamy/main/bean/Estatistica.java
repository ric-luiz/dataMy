/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.bean;

/**
 *
 * @author Dextter
 */
public class Estatistica {
    private int id;
    private String caminhoArquivo;
    private CompraRelatorio idCompraRelatorio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public CompraRelatorio getIdCompraRelatorio() {
        return idCompraRelatorio;
    }

    public void setIdCompraRelatorio(CompraRelatorio idCompraRelatorio) {
        this.idCompraRelatorio = idCompraRelatorio;
    }

    public Estatistica(int id, String caminhoArquivo, CompraRelatorio idCompraRelatorio) {
        this.id = id;
        this.caminhoArquivo = caminhoArquivo;
        this.idCompraRelatorio = idCompraRelatorio;
    }

    public Estatistica() {
    }
        
}
