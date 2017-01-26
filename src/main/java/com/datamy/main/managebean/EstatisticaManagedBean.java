package com.datamy.main.managebean;

import com.datamy.main.dao.EstatisticaDao;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ric_l
 */
@ManagedBean(name = "estatistica", eager = true)
@RequestScoped
public class EstatisticaManagedBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private EstatisticaDao eDao;

    public EstatisticaManagedBean() {
        this.eDao = new EstatisticaDao();
    }
        
    public void criarEstatistica(String id){
        System.out.println(id);        
    }
    
    public void getEstatistica(){
    
    }
    
    public String colorLink(int id){
        if(id==0){
            return "background-color: #5cb85c";
        } else {
            return "background-color: #a94442";
        }                        
    }
    
    public String textLink(int id){
        if(id==0){
            return "A Fazer";
        } else {
            return "Usado";
        }
    }
}
