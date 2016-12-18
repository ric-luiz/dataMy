package com.datamy.main.managebean;

import com.datamy.main.bean.CompraRelatorio;
import com.datamy.main.bean.Usuario;
import com.datamy.main.dao.CompraCreditoDao;
import com.datamy.main.dao.CompraRelatorioDao;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ric_l
 */
@ManagedBean(name = "comprarrelatorio", eager = true)
@RequestScoped
public class ComprarRelatorioManageBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @ManagedProperty(value = "#{usuario.usuario}")
    private Usuario user;
    private CompraRelatorio compraRelatorio;
    private CompraRelatorioDao cDao;
    private CompraCreditoDao creDao;
    private int qtdRelatorios;
    
    public ComprarRelatorioManageBean() {
        this.user = new Usuario();
        this.compraRelatorio = new CompraRelatorio();
        this.cDao = new CompraRelatorioDao();
        this.creDao = new CompraCreditoDao();
    }
    
    //Faz a compra de um relatorio caso exista credito (ainda por implementar por o limite por credito)
    public String comprarRelatorio(){        
        compraRelatorio.setUser(user);
        if(creDao.verificarCreditoSuficiente(compraRelatorio)){ //caso o usuario possua credito correspondente ao relatorio que ele quer comprar é efetuado a compra            
            //Compra o total de relatorios de acordo com a opção escolhida pelo usuário
            for(int i=0;i<this.qtdRelatorios;i++){
                cDao.insert(compraRelatorio);
            }
            return "home.xhtml";
        } else { // caso contria a compra n é efetuada e o usuário é redirecionado
            return null;
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

    public String comprarStandart(){
        this.compraRelatorio.setValorRelatorio(200);
        this.qtdRelatorios = 5;
        return comprarRelatorio();
    }
    
    public String comprarBronze(){
        this.compraRelatorio.setValorRelatorio(400);
        this.qtdRelatorios = 10;
        return comprarRelatorio();
    }
    
    public String comprarSilver(){
        this.compraRelatorio.setValorRelatorio(800);
        this.qtdRelatorios = 20;
        return comprarRelatorio();
    }
    
    public String comprarGold(){
        this.compraRelatorio.setValorRelatorio(1000);
        this.qtdRelatorios = 35;
        return comprarRelatorio();
    }
}
