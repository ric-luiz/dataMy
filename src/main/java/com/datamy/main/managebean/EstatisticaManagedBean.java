package com.datamy.main.managebean;

import com.datamy.main.bean.Estatistica;
import com.datamy.main.dao.EstatisticaDao;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    
    public String colorLink(Estatistica estatistica){
        if(estatistica==null){
            return "background-color: #5cb85c";
        } else if(estatistica.getStatus().equals("Feito")){
            return "background-color: #a94442";
        } else {
            return "background-color: #ffe764; color:black";
        }                        
    }
    
    public String textLink(Estatistica estatistica){
        if(estatistica==null){
            return "A Fazer";
        } else {
            return estatistica.getStatus();
        }
    }
    
    public String text(Estatistica estatistica) throws ParseException{
        if(estatistica==null){
            return "Relatório Disponível";
        } else {
            
            Calendar c = Calendar.getInstance();
            c.setTime(estatistica.getDataUso());
            String data = c.get(Calendar.DAY_OF_MONTH)+"/"+c.get(Calendar.MONTH)+"/"+c.get(Calendar.YEAR);
            return "Relatório Usado em "+data;
        }
    }
}
