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
    private Twitter idDadosTwitter;
    private Facebook idDadosFacebook;

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

    public Twitter getIdDadosTwitter() {
        return idDadosTwitter;
    }

    public void setIdDadosTwitter(Twitter idDadosTwitter) {
        this.idDadosTwitter = idDadosTwitter;
    }

    public Facebook getIdDadosFacebook() {
        return idDadosFacebook;
    }

    public void setIdDadosFacebook(Facebook idDadosFacebook) {
        this.idDadosFacebook = idDadosFacebook;
    }
        

    public Estatistica(int id, String caminhoArquivo, CompraRelatorio idCompraRelatorio, Twitter idDadosTwitter, Facebook idDadosFacebook) {
        this.id = id;
        this.caminhoArquivo = caminhoArquivo;
        this.idCompraRelatorio = idCompraRelatorio;
        this.idDadosTwitter = idDadosTwitter;
        this.idDadosFacebook = idDadosFacebook;
    }
    

    public Estatistica() {
    }

    public Estatistica(int id) {
        this.id = id;
    }
        
}
