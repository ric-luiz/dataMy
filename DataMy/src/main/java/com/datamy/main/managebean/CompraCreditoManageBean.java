package com.datamy.main.managebean;

import com.datamy.main.bean.CompraCredito;
import com.datamy.main.bean.Usuario;
import com.datamy.main.dao.CompraCreditoDao;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ric_l
 */
@ManagedBean(name = "compracredito", eager = true)
@RequestScoped
public class CompraCreditoManageBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private CompraCredito compraCredito;
    private CompraCreditoDao cDao;
    @ManagedProperty(value = "#{usuario.usuario}")
    private Usuario user;   //Vai receber o usuario pela sessão. ele vem atraves do form
    
    public CompraCreditoManageBean() {
        this.compraCredito = new CompraCredito();
        this.cDao = new CompraCreditoDao();
    }
    
    //Faz a compra de Credito
    public String comprar(){        
        compraCredito.setUser(user);
        cDao.insert(compraCredito);
        return null;
    }
    
    public CompraCredito getCompraCredito() {
        return compraCredito;
    }

    public void setCompraCredito(CompraCredito compraCredito) {
        this.compraCredito = compraCredito;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }    
}
