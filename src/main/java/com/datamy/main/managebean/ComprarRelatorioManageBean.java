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
public class ComprarRelatorioManageBean implements Serializable{
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
        
}
