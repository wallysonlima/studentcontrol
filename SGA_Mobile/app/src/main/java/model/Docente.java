package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by wally on 27/12/15.
 */
public class Docente {
    String nome, email, senha;
    ArrayList<Turma> turmas = new ArrayList<Turma>();

    public Docente() {

    }

    public Docente(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Docente(ResultSet rs) throws SQLException {
        this.nome = rs.getString("nome_docente");
        this.email = rs.getString("email");
        this.senha = rs.getString("senha");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
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
