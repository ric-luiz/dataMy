package com.datamy.main.managebean;

import com.datamy.main.bean.Chamado;
import com.datamy.main.bean.Usuario;
import com.datamy.main.dao.ChamadoDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Dextter
 */

@ManagedBean(name = "chamado", eager = true)
@RequestScoped
public class ChamadoManagedBean implements Serializable {
    private static final long serialVersionUID = 1L;    
    
    private Chamado chamado;
    private ChamadoDao chamadoDao;
    
    @ManagedProperty(value = "#{usuario.usuario}")
    private Usuario user;

    public ChamadoManagedBean() {
        this.chamadoDao = new ChamadoDao();
        this.chamado = new Chamado();
        this.user = new Usuario();
    }
    
    public String criarChamado(){        
        this.chamadoDao.inserirChamado(chamado, user);        
        return "home.xhtml";
    } 
    
    //Alterar Estado Do chamado Para Em andamento
    public void atenderChamado(Chamado chamado){
        chamado.setStatus("Em andamento");
        chamadoDao.updateChamado(chamado);
    }
    
    //Finalizar Chamado Atendido
    public void finalizarChamado(Chamado chamado){
        chamado.setDataFim(new Date());
        chamado.setStatus("Finalizado");
        chamadoDao.UpdateChamadoDataFim(chamado);
    }
    
    //Recupera a lista de chamados no banco
    public ArrayList<Chamado> findChamados(){                        
        return chamadoDao.select();
    }
    
    //Verifica se o chamado deve aparecer Verde Ou Vermelho
    public String verificarChamadoColor(Chamado chamado){
        if(!chamado.getStatus().equals("Em aberto")){
            return "btn btn-danger btn-sm btn-block";
        }
        return "btn btn-success btn-sm btn-block";
    }

    //Verifica se o nome do chamado de estar como atender ou finalizar
    public String verificarChamadoName(Chamado chamado){
        if(!chamado.getStatus().equals("Em aberto")){
            return "Finalizar";
        }
        return "Atender";
    }
    
    //Verifica para onde vai mandar a ação do botão do chamado
    public String verificarChamdoLink(Chamado chamado){
        if(!chamado.getStatus().equals("Em aberto")){
            finalizarChamado(chamado);
        } else {
            atenderChamado(chamado);
        }
        
        return "atenderChamado.xhtml?faces-redirect=true";
    }
    
    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
        
}
