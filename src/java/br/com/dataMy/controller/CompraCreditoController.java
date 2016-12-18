package br.com.dataMy.controller;

import br.com.dataMy.model.DAO.CompraCreditoDao;
import br.com.dataMy.beans.CompraCredito;

/**
 *
 * @author ric_l
 */
public class CompraCreditoController {
    CompraCreditoDao cDao;

    public CompraCreditoController() {
        cDao = new CompraCreditoDao();
    }
        
    public void inserirCompra(CompraCredito compra){
        cDao.insert(compra);
    }
    
}
