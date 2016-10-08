package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by wally on 27/12/15.
 */
public class Docente {
    String nome, email, senha;
    int codigo_docente, codigo_depart;
    ArrayList<Turma> turmas = new ArrayList<Turma>();

    public Docente() {

    }

    public Docente(String nome, String email, String senha, int codigo_docente, int codigo_depart) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.codigo_docente = codigo_docente;
        this.codigo_depart = codigo_depart;
    }

    public Docente(ResultSet rs) throws SQLException {
        this.nome = rs.getString("nome_docente");
        this.email = rs.getString("email");
        this.senha = rs.getString("senha");
        this.codigo_docente = rs.getInt("codigo_docente");
        this.codigo_depart = rs.getInt("codigo_depart");
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

    public int getCodigo_docente() {
        return codigo_docente;
    }

    public void setCodigo_docente(int codigo_docente) {
        this.codigo_docente = codigo_docente;
    }

    public int getCodigo_depart() {
        return codigo_depart;
    }

    public void setCodigo_depart(int codigo_depart) {
        this.codigo_depart = codigo_depart;
    }
}
