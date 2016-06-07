package model;

import java.util.ArrayList;

/**
 * Created by wally on 27/12/15.
 */
public class Turma {
    String nome;
    ArrayList<Aula> aulas = new ArrayList<Aula>();
    int qtdeAulas;

    ArrayList<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();

    public Turma(String nome) {
        this.nome = nome;
    }

    public Turma() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(ArrayList<Aula> aulas) {
        this.aulas = aulas;
    }

    public int getQtdeAulas() {
        return qtdeAulas;
    }

    public void setQtdeAulas(int qtdeAulas) {
        this.qtdeAulas = qtdeAulas;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public String toString() {
        return ( this.nome );
    }
}

