/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.managebean;

import com.datamy.main.bean.Chamado;
import com.datamy.main.bean.RelatorioChamados;
import com.datamy.main.dao.ChamadoDao;
import com.datamy.main.dao.RelatorioChamadosDao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Dextter
 */

@ManagedBean(name = "chamado", eager = true)
@RequestScoped
public class ChamadoManagedBean {
    private Chamado chamado;
    private ChamadoDao chamadoDao;
    private RelatorioChamados relatorioChamados;
    private RelatorioChamadosDao relatoriochamadosDao;
    
}
