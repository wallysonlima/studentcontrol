package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Luiz on 9/27/2015.
 */
public class Discente {

    private String ra;
    private String nome;
    private String email;
    private String senha;

    public Discente() {
    }

    public Discente(String ra, String nome, String email, String senha) {
        this.ra = ra;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Discente(ResultSet rs) throws SQLException{
        this.ra     = rs.getString("ra");
        this.nome   = rs.getString("nome_discente");
        this.email  = rs.getString("email");
        this.senha  = rs.getString("senha");
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
