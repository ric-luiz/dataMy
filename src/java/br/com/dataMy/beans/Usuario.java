package br.com.dataMy.beans;

/**
 *
 * @author ric_l
 */
public class Usuario {
    private int id;
    private String nome;
    private String perfil;
    private String status;
    private String username;
    private String password;

    public Usuario() {
    }    
    
    public Usuario(int id, String nome, String perfil, String status, String username, String password) {
        this.id = id;
        this.nome = nome;
        this.perfil = perfil;
        this.status = status;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
