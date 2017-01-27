package com.datamy.main.managebean;

import com.datamy.main.bean.Chamado;
import com.datamy.main.bean.Usuario;
import com.datamy.main.dao.ChamadoDao;
import java.io.Serializable;
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
