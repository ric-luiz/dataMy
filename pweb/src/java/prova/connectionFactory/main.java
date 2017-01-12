package prova.connectionFactory;


import prova.connectionFactory.ConexaoDao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dextter
 */
public class main {
    public static void main(String[] args){
        ConexaoDao c = new ConexaoDao();
        c.CriarConexao();
    }
}
