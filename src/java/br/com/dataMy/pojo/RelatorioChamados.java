/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dataMy.pojo;

import java.util.Date;
import javax.annotation.ManagedBean;

/**
 * Definição dos atriubtos e metodos acessadores da entidade RelatorioChamado, 
 * usado para Instancias dos casos de uso de relatorio de chamados e atender
 * chamado, cuja função é disponibilizar dados para leitura de listas de 
 * chamados e tornar possivel a manipulação dos dados lá presentes
 * @author Dextter
 */

public class RelatorioChamados {
    private int idRelatorioChamados;
    private Date dataRelatorio;
    private String pathArquivo;

    public int getIdRelatorioChamados() {
        return idRelatorioChamados;
    }

    public void setIdRelatorioChamados(int idRelatorioChamados) {
        this.idRelatorioChamados = idRelatorioChamados;
    }

    public Date getDataRelatorio() {
        return dataRelatorio;
    }

    public void setDataRelatorio(Date dataRelatorio) {
        this.dataRelatorio = dataRelatorio;
    }

    public String getPathArquivo() {
        return pathArquivo;
    }

    public void setPathArquivo(String pathArquivo) {
        this.pathArquivo = pathArquivo;
    }

    public RelatorioChamados(int idRelatorioChamados, Date dataRelatorio, String pathArquivo) {
        this.idRelatorioChamados = idRelatorioChamados;
        this.dataRelatorio = dataRelatorio;
        this.pathArquivo = pathArquivo;
    }

    public RelatorioChamados() {
    }
    
    
}
