package br.com.dataMy.beans;

/**
 *
 * @author ric_l
 */
public class CartaoCredito {
    private int idCartaoCredito;   
    private String numeroCartao;
    private int userId;

    public CartaoCredito(int idCartaoCredito, String numeroCartao, int userId) {
        this.idCartaoCredito = idCartaoCredito;
        this.numeroCartao = numeroCartao;
        this.userId = userId;
    }

    public CartaoCredito() {
    }
    
    public int getId() {
        return idCartaoCredito;
    }

    public void setId(int idCartaoCredito) {
        this.idCartaoCredito = idCartaoCredito;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
        
}
