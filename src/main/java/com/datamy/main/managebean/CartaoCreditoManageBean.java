package com.datamy.main.managebean;

import com.datamy.main.bean.CartaoCredito;
import com.datamy.main.bean.Usuario;
import com.datamy.main.dao.CartaoCreditoDao;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ric_l
 */
@ManagedBean(name = "cartaocredito", eager = true)
@RequestScoped
public class CartaoCreditoManageBean implements Serializable{
    private static final long serialVersionUID = 1L;

    private CartaoCredito cartaoCredito;
    private CartaoCreditoDao cDao;
    @ManagedProperty(value = "#{usuario.usuario}")
    private Usuario user;   //Vai receber o usuario pela sessão. ele vem atraves do form
    
    public CartaoCreditoManageBean() {
        this.cartaoCredito = new CartaoCredito();
        this.cDao = new CartaoCreditoDao();
    }
    
    //Inserir um cartão caso ele ja n exista no banco
    public void inserirCartao(){
        if(cDao.select(cartaoCredito).size() == 0){
            System.out.println(user.getNome());
            cartaoCredito.setUser(user); // CUIDADO PARA QUE O USER N VENHA NULO DO FORM
            cDao.insert(cartaoCredito);
        }
    }
    
    public CartaoCredito getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(CartaoCredito cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
}
