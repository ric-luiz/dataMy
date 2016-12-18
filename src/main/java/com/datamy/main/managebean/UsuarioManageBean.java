package com.datamy.main.managebean;

import com.datamy.main.bean.Usuario;
import com.datamy.main.dao.UsuarioDao;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ric_l
 */
@ManagedBean(name = "usuario", eager = true)
@SessionScoped
public class UsuarioManageBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Usuario usuario;
    private UsuarioDao uDao;
    
    
    public UsuarioManageBean() {
        this.usuario = new Usuario();
        this.uDao = new UsuarioDao();
    }    
        
    //Logar no sistema
    public String logar(){
        this.usuario = uDao.select(usuario); // jogar o usuario na varivel de sessão
        if(this.usuario.getUsername() != null){ //verifica se houve algum retorno da pesquisa no banco
            return "home.xhtml";
        } else {
            return null;
        }                
    }
    
    //Cadastrar um Novo usuário
    public String cadastrar(){
        uDao.insert(usuario);
        return "login.xhtml";
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
