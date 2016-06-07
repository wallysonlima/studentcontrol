package model;

import java.util.ArrayList;

/**
 * Created by wally on 27/12/15.
 */
public class Disciplina {
    String nome, descricao, carga_horaria;
    ArrayList<Turma> turmas = new ArrayList<Turma>();

    public Disciplina(String nome, String descricao, String carga_horaria) {
        this.nome = nome;
        this.descricao = descricao;
        this.carga_horaria = carga_horaria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(String carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }
}
