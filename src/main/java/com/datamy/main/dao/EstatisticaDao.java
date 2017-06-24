package com.datamy.main.dao;

import com.datamy.main.connection.connectionFactory.ConexaoPGDao;
import com.datamy.main.bean.CompraRelatorio;
import com.datamy.main.bean.Estatistica;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ric_l
 */
public class EstatisticaDao extends ConexaoPGDao{
    
    public ArrayList<Estatistica> getEstatisticas(CompraRelatorio compras){
        
        CriarConexao();
        ArrayList<Estatistica> estatisticas = new ArrayList<Estatistica>();
        try {
            
            preparacao = conexao.prepareStatement("SELECT id,status,datauso FROM estatistica WHERE compraRelatorio_id = ?");
            preparacao.setInt(1, compras.getId());
            resultado = preparacao.executeQuery();
            
            while(resultado.next()){
                estatisticas.add(new Estatistica(resultado.getInt("id"),resultado.getString("status"),resultado.getDate("datauso")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EstatisticaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
        
        return estatisticas;
    }
    
}
