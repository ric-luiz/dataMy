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
public class Chamado {
    private int id;
    private String titulo;
    private Date dataInicio;
    private Date dataFim;
    private String status;
    private String descricao;
    private String pathImagem;
    private Usuario idUsuario;
    private RelatorioChamados idRelatorioChamados;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPathImagem() {
        return pathImagem;
    }

    public void setPathImagem(String pathImagem) {
        this.pathImagem = pathImagem;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public RelatorioChamados getIdRelatorioChamados() {
        return idRelatorioChamados;
    }

    public void setIdRelatorioChamados(RelatorioChamados idRelatorioChamados) {
        this.idRelatorioChamados = idRelatorioChamados;
    }

    public Chamado(int id, String titulo, Date dataInicio, Date dataFim, String status, String descricao, String pathImagem, Usuario idUsuario, RelatorioChamados idRelatorioChamados) {
        this.id = id;
        this.titulo = titulo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
        this.descricao = descricao;
        this.pathImagem = pathImagem;
        this.idUsuario = idUsuario;
        this.idRelatorioChamados = idRelatorioChamados;
    }

    public Chamado() {
    }
        
}
