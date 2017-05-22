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
public class ComentarioFB {
    String from_id;
    String from_name;
    String message;
    String created_time;
    double likes_count;
    String comments_count;
    String id;

    public ComentarioFB() {
    }
    
    public ComentarioFB(String from_id, String from_name, String message, String created_time, double likes_count, String comments_count, String id) {
        this.from_id = from_id;
        this.from_name = from_name;
        this.message = message;
        this.created_time = created_time;
        this.likes_count = likes_count;
        this.comments_count = comments_count;
        this.id = id;
    }
    
    public String getFrom_id() {
        return from_id;
    }

    public void setFrom_id(String from_id) {
        this.from_id = from_id;
    }

    public String getFrom_name() {
        return from_name;
    }

    public void setFrom_name(String from_name) {
        this.from_name = from_name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public double getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(double likes_count) {
        this.likes_count = likes_count;
    }

    public String getComments_count() {
        return comments_count;
    }

    public void setComments_count(String comments_count) {
        this.comments_count = comments_count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
