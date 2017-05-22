/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.managebean;

import com.datamy.main.bean.Chamado;
import com.datamy.main.bean.ComentarioFB;
import com.datamy.main.dao.ChamadoDao;
import com.datamy.main.dao.ComentarioFBDao;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author pablo
 */
@ManagedBean(name = "comentario")
@RequestScoped
public class ComentarioFBManagedBean implements Serializable{
    private static final long serialVersionUID = 1L;    
    
    private ComentarioFB cometario_fb;
    private ComentarioFBDao comantario_fb_dao;

    public ComentarioFBManagedBean() {
        this.comantario_fb_dao = new ComentarioFBDao();
        this.cometario_fb = new ComentarioFB();
    }   
    
    public ArrayList<ComentarioFB> listarComentarios(){                        
        return comantario_fb_dao.select();
    }
}
