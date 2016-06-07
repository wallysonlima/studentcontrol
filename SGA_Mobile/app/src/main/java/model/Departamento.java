package model;

import java.util.ArrayList;

/**
 * Created by wally on 27/12/15.
 */
public class Departamento {
    String nome;
    ArrayList<Curso> cursos = new ArrayList<Curso>();
    ArrayList<Docente> docentes = new ArrayList<Docente>();

    public Departamento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public ArrayList<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(ArrayList<Docente> docentes) {
        this.docentes = docentes;
    }
}
