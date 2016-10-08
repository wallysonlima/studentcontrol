package model;

import java.util.ArrayList;

/**
 * Created by wally on 27/12/15.
 */
public class Turma {
    String nome;
    int codigo_turma, codigo_disciplina, codigo_docente;

    public Turma(String nome, int codigo_turma, int codigo_disciplina, int codigo_docente) {
        this.nome = nome;
        this.codigo_turma = codigo_turma;
        this.codigo_disciplina = codigo_disciplina;
        this.codigo_docente = codigo_docente;
    }

    public Turma() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo_turma() {
        return codigo_turma;
    }

    public void setCodigo_turma(int codigo_turma) {
        this.codigo_turma = codigo_turma;
    }

    public int getCodigo_disciplina() {
        return codigo_disciplina;
    }

    public void setCodigo_disciplina(int codigo_disciplina) {
        this.codigo_disciplina = codigo_disciplina;
    }

    public int getCodigo_docente() {
        return codigo_docente;
    }

    public void setCodigo_docente(int codigo_docente) {
        this.codigo_docente = codigo_docente;
    }

    public String toString() {
        return ( this.nome );
    }
}

