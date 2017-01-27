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
public class Twitter {
    private int id;
    private int curtidas;
    private int retweets;
    private int falandoSobre;
    private String replys;

    public Twitter() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(int curtidas) {
        this.curtidas = curtidas;
    }

    public int getRetweets() {
        return retweets;
    }

    public void setRetweets(int retweets) {
        this.retweets = retweets;
    }

    public int getFalandoSobre() {
        return falandoSobre;
    }

    public void setFalandoSobre(int falandoSobre) {
        this.falandoSobre = falandoSobre;
    }

    public String getReplys() {
        return replys;
    }

    public void setReplys(String replys) {
        this.replys = replys;
    }

    public Twitter(int id, int curtidas, int retweets, int falandoSobre, String replys) {
        this.id = id;
        this.curtidas = curtidas;
        this.retweets = retweets;
        this.falandoSobre = falandoSobre;
        this.replys = replys;
    }
    
    
}
