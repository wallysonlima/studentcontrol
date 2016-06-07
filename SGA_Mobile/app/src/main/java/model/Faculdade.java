package model;

import java.util.ArrayList;

/**
 * Created by wally on 27/12/15.
 */
public class Faculdade {
    String nome;
    ArrayList<Departamento> departamentos = new ArrayList<Departamento>();

    public Faculdade(String nome) {
        this.nome = nome;
    }

    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(ArrayList<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
