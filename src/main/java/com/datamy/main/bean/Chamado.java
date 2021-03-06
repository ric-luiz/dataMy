package com.datamy.main.bean;

import java.util.Date;

/**
 *
 * @author Dextter
 */
public class Chamado {
    protected int id;
    protected String titulo;
    protected String tipo;
    protected Date dataInicio;
    protected Date dataFim;
    protected String status;
    protected String descricao;
    protected String pathImagem;
    protected Usuario user;    
    
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

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Chamado(int id, String titulo, String tipo,Date dataInicio,Date dataFim, String status, String descricao, String pathImagem, Usuario user) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
        this.descricao = descricao;
        this.pathImagem = pathImagem;
        this.user = user;
    }

    public Chamado() {
    }
        
}
