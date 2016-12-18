/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dataMy.model.DAO;

import br.com.dataMy.beans.CartaoCredito;
import br.com.dataMy.pojo.Usuario;
import br.com.dataMy.pojo.Chamado;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dextter
 */
public class AbrirChamadoDao extends ConexaoDao{
    ArrayList<Chamado> chamados;                
    
    public AbrirChamadoDao() {       
        super();
    }            
    
    /**
     * metodo capaz de inserir um chamado no banco de dados
     * @param chamado
     */
    public void insert(Chamado call){
        try {
            preparacao = conexao.prepareStatement("INSERT INTO `chamado`("
                    + "`tituo`,"
                    + "`dataInicio`, "
                    + "`dataFim`, "
                    + "`status`, "
                    + "`descricao`, "
                    + "`pathImagem`, "
                    + "`idUusuario`, "
                    + "`idRelatorioChamados`) "
                    + "VALUES (?,?,?,?,?,?,?,?)");
            
            preparacao.executeUpdate();            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
