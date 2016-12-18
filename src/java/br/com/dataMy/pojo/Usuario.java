package br.com.dataMy.pojo;

/**
 *
 * @author ric_l
 */
public class Usuario {
    private int idUsuario;
    private String nome;
    private String perfil;
    private String status;
    private String username;
    private String password;
    private String email;
    private String cpf;

    public Usuario() {
    }    

    public Usuario(int idUsuario, String nome, String perfil, String status, String username, String password, String email, String cpf) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.perfil = perfil;
        this.status = status;
        this.username = username;
        this.password = password;
        this.email = email;
        this.cpf = cpf;
    }        

    public int getId() {
        return idUsuario;
    }

    public void setId(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
            
}
