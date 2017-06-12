/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.bean;

/**
 *
 * @author pablo
 */
public class RespostasBot {
    private int id;
    private boolean aceita;
    private String textoPulicacao;
    private String texto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAceita() {
        return aceita;
    }

    public void setAceita(boolean aceita) {
        this.aceita = aceita;
    }

    public String getTextoPulicacao() {
        return textoPulicacao;
    }

    public void setTextoPulicacao(String textoPulicacao) {
        this.textoPulicacao = textoPulicacao;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public RespostasBot() {
    }

    public RespostasBot(int id, boolean aceita, String textoPublicacao, String texto) {
        this.id = id;
        this.aceita = aceita;
        this.textoPulicacao = textoPublicacao;
        this.texto = texto;
    }
    
    
}
