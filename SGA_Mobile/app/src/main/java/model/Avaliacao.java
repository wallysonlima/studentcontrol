package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by wally on 27/12/15.
 */
public class Avaliacao {
    String descricao;
    Date data = new Date();
    ArrayList<Nota> notas = new ArrayList<Nota>();

    public Avaliacao(Date data, String descricao) {
        this.data = data;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }
}
