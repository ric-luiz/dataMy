package br.com.dataMy.controller;

import br.com.dataMy.DAO.UsuarioDao;
import br.com.dataMy.beans.Usuario;

/**
 *
 * @author ric_l
 */
public class UsuarioController {
    
    UsuarioDao uDao;

    public UsuarioController() {
        this.uDao = new UsuarioDao();
    }        
    
    /**
     * Recupera do banco o usuario passado pelo parametro
     * @return Usuario
     */
    public Usuario logar(Usuario user){
        return uDao.select(user);
    }
    
}
