package br.com.dataMy.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ric_l
 */
public class ConexaoDao{
    
    protected static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    protected static final String BANCO = "jdbc:mysql://localhost:3306/dataMy";
    
    protected static final String USER = "root";
    protected static final String PASS = "";
    
    protected static Statement consulta;
    protected ResultSet resultado;
    protected PreparedStatement preparacao;
    protected static Connection conexao;

    //Construtor padrao com criação da conexão
    public ConexaoDao() {        
        if(conexao == null){ //Cria a conexão caso ela seja nula
            try {
            Class.forName("com.mysql.jdbc.Driver");
            
            conexao = DriverManager.getConnection(BANCO,USER,PASS);
            consulta = conexao.createStatement();                
            
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexaoDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }        
}
