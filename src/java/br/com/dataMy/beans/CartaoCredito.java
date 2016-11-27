package br.com.dataMy.beans;

/**
 *
 * @author ric_l
 */
public class CartaoCredito {
    private int id;
    private String nomeTitular;
    private String numeroCartao;
    private int userId;

    public CartaoCredito(int id, String nomeTitular, String numeroCartao, int userId) {
        this.id = id;
        this.nomeTitular = nomeTitular;
        this.numeroCartao = numeroCartao;
        this.userId = userId;
    }

    public CartaoCredito() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
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
