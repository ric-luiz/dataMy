package com.datamy.main.managebean;

import com.datamy.main.bean.CompraRelatorio;
import com.datamy.main.bean.Estatistica;
import com.datamy.main.bean.Usuario;
import com.datamy.main.dao.CompraRelatorioDao;
import com.datamy.main.dao.EstatisticaDao;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ric_l
 */
@ManagedBean(name = "comprarrelatorio", eager = true)
@RequestScoped
public class ComprarRelatorioManageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{usuario.usuario}")
    private Usuario user;
    private CompraRelatorio compraRelatorio;
    //Dao's
    private CompraRelatorioDao cDao;
    private EstatisticaDao eDao;
        
    public ComprarRelatorioManageBean() {
        this.user = new Usuario();
        this.compraRelatorio = new CompraRelatorio();
        this.cDao = new CompraRelatorioDao();
        this.eDao = new EstatisticaDao();
    }
    
    //Faz a compra de um relatorio
    public String comprarRelatorio() {
        compraRelatorio.setUser(user);
        cDao.insert(compraRelatorio);
        return "home.xhtml";
    }
    
    //Recupera a lista de compras realizadas pelo usuario
    public ArrayList<CompraRelatorio> findComprasRelatorios(){
        ArrayList<CompraRelatorio> compras = cDao.getComprasRelatorios(user);
        return compras;
    }
    
    //Retorna o total de compras realizadas
    public int getQuantidadeComprasRelatorios(){
        return cDao.getComprasRelatorios(user).size();
    }
    
    //Pega a lista de relatorios associados a compra do usuario
    public ArrayList<Estatistica> findRelatoriosComprados(){
        ArrayList<CompraRelatorio> compras = cDao.getComprasRelatorios(user);
        ArrayList<Estatistica> estatisticas = new ArrayList<Estatistica>();
        
        for(CompraRelatorio compra : compras){            
            inserirArrayEstatisticas(compra, estatisticas, this.eDao.getEstatisticas(compra));            
        }
        
        return estatisticas;
    }
    
    //Vai preencher o array de relatorios associados a compra
    private void inserirArrayEstatisticas(CompraRelatorio compra, ArrayList<Estatistica> arrayEstatisticas, ArrayList<Estatistica> estatisticas){                
        preencherArray(arrayEstatisticas, estatisticas, compra.getQuantidade());    
    }
    
    //Insere no array o id do relatorio ja feito, caso não tenha sido feito insere o 0(o que diz que o relatorio ainda pode ser feito)
    private void preencherArray(ArrayList<Estatistica> arrayEstatisticas, ArrayList<Estatistica> estatisticas, int numeroRelatorios){
        for(int i = 0; i < numeroRelatorios; i++){            
            if(i < estatisticas.size()){
                arrayEstatisticas.add(estatisticas.get(i));
            } else {
                arrayEstatisticas.add(null);
            }            
        }
    }
    
    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public CompraRelatorio getCompraRelatorio() {
        return compraRelatorio;
    }

    public void setCompraRelatorio(CompraRelatorio compraRelatorio) {
        this.compraRelatorio = compraRelatorio;
    }
    
    public String comprarBronze() {
        this.compraRelatorio.setValorCompra(200);
        this.compraRelatorio.setQuantidade(5);
        return comprarRelatorio();
    }

    public String comprarSilver() {
        this.compraRelatorio.setValorCompra(400);
        this.compraRelatorio.setQuantidade(10);
        return comprarRelatorio();
    }

    public String comprarGold() {
        this.compraRelatorio.setValorCompra(800);
        this.compraRelatorio.setQuantidade(15);
        return comprarRelatorio();
    }        
}
