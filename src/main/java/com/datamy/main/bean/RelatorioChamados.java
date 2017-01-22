/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.bean;

import java.util.Date;

/**
 *
 * @author Dextter
 */
public class RelatorioChamados {
    private int id;
    private String tipo;
    private String pathArquivo;
    private Date dataRelatorio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPathArquivo() {
        return pathArquivo;
    }

    public void setPathArquivo(String pathArquivo) {
        this.pathArquivo = pathArquivo;
    }

    public Date getDataRelatorio() {
        return dataRelatorio;
    }

    public void setDataRelatorio(Date dataRelatorio) {
        this.dataRelatorio = dataRelatorio;
    }

    public RelatorioChamados(int id, String tipo, Date dataRelatorio, String pathArquivo){
        this.id = id;
        this.tipo = tipo;
        this.dataRelatorio = dataRelatorio;
        this.pathArquivo = pathArquivo;
        
    }

    public RelatorioChamados() {
    }
           
}
