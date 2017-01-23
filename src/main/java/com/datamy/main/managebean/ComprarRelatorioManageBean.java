package com.datamy.main.managebean;

import com.datamy.main.bean.CompraRelatorio;
import com.datamy.main.bean.Usuario;
import com.datamy.main.dao.CompraRelatorioDao;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ric_l
 */
@ManagedBean(name = "comprarrelatorio", eager = true)
@RequestScoped
public class ComprarRelatorioManageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{usuario.usuario}")
    private Usuario user;
    private CompraRelatorio compraRelatorio;
    private CompraRelatorioDao cDao;

    public ComprarRelatorioManageBean() {
        this.user = new Usuario();
        this.compraRelatorio = new CompraRelatorio();
        this.cDao = new CompraRelatorioDao();
    }
    
    //Faz a compra de um relatorio
    public String comprarRelatorio() {
        compraRelatorio.setUser(user);
        cDao.insert(compraRelatorio);
        return "home.xhtml";
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public CompraRelatorio getCompraRelatorio() {
        return compraRelatorio;
    }

    public void setCompraRelatorio(CompraRelatorio compraRelatorio) {
        this.compraRelatorio = compraRelatorio;
    }

    public String comprarBronze() {
        this.compraRelatorio.setValorCompra(200);
        this.compraRelatorio.setQuantidade(5);
        return comprarRelatorio();
    }

    public String comprarSilver() {
        this.compraRelatorio.setValorCompra(400);
        this.compraRelatorio.setQuantidade(10);
        return comprarRelatorio();
    }

    public String comprarGold() {
        this.compraRelatorio.setValorCompra(800);
        this.compraRelatorio.setQuantidade(15);
        return comprarRelatorio();
    }        
}
