/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dataMy.pojo;

import java.util.Date;
import javax.annotation.ManagedBean;

/**
 * Definição dos atriubtos e metodos acessadores da entidade Chamado, usada para
 * Instancias dos casos de uso de abrir chamado, relatorio de chamados e atender
 * chamado
 * @author Dextter
 */

public class Chamado {
    private int idChamado;
    private String titulo;
    private Date dataInicio;
    private Date dataFim;
    private String status;
    private String descricao;
    private String pathImagem;
    private int idUsuario;
    private int idRelatorioChamados;

    public int getIdChamado() {
        return idChamado;
    }

    public void setIdChamado(int idChamado) {
        this.idChamado = idChamado;
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdRelatorioChamados() {
        return idRelatorioChamados;
    }

    public void setIdRelatorioChamados(int idRelatorioChamados) {
        this.idRelatorioChamados = idRelatorioChamados;
    }

    public Chamado(int idChamado, String titulo, Date dataInicio, Date dataFim, String status, String descricao, String pathImagem, int idUsuario, int idRelatorioChamados) {
        this.idChamado = idChamado;
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
