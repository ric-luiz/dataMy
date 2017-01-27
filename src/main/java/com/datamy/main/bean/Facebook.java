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
public class Facebook {
    private int id;
    private int gostei;
    private int amei;
    private int haha;
    private int triste;
    private int raiva;
    private String comentarios;

    public Facebook() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGostei() {
        return gostei;
    }

    public void setGostei(int gostei) {
        this.gostei = gostei;
    }

    public int getAmei() {
        return amei;
    }

    public void setAmei(int amei) {
        this.amei = amei;
    }

    public int getHaha() {
        return haha;
    }

    public void setHaha(int haha) {
        this.haha = haha;
    }

    public int getTriste() {
        return triste;
    }

    public void setTriste(int triste) {
        this.triste = triste;
    }

    public int getRaiva() {
        return raiva;
    }

    public void setRaiva(int raiva) {
        this.raiva = raiva;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Facebook(int id, int gostei, int amei, int haha, int triste, int raiva, String comentarios) {
        this.id = id;
        this.gostei = gostei;
        this.amei = amei;
        this.haha = haha;
        this.triste = triste;
        this.raiva = raiva;
        this.comentarios = comentarios;
    }
    
    
}
