package com.datamy.main.bean;

import java.util.Date;

/**
 *
 * @author Dextter
 */
public class Estatistica {
    private int id;
    private String status;
    private Date dataUso;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataUso() {
        return dataUso;
    }

    public void setDataUso(Date dataUso) {
        this.dataUso = dataUso;
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

    public Estatistica(int id, String status, Date dataUso) {
        this.id = id;
        this.status = status;
        this.dataUso = dataUso;
    }        
        
}
