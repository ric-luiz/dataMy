/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamy.main.bean;

import java.util.Date;

/**
 *
 * @author ricardo
 */
public class ChamadoGraficoDataCount extends Chamado{
    private int total;

    public ChamadoGraficoDataCount(int total,Date data) {
        this.total = total;
        this.dataInicio = data;
    }

    public ChamadoGraficoDataCount() {
    }
            
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
}
