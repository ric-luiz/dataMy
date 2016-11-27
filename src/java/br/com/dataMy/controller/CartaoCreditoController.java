package br.com.dataMy.controller;

import br.com.dataMy.DAO.CartaoCreditoDao;
import br.com.dataMy.beans.CartaoCredito;
import br.com.dataMy.beans.Usuario;
import java.util.ArrayList;

/**
 *
 * @author ric_l
 */
public class CartaoCreditoController {
    CartaoCreditoDao cDao;

    public CartaoCreditoController() {
        cDao = new CartaoCreditoDao();
    }
    
    public void inserirCartao(CartaoCredito cartao){
        cDao.insert(cartao);
    }
    
    public ArrayList<CartaoCredito> recuperarCartoes(Usuario user){
        return cDao.select(user);
    }
}
