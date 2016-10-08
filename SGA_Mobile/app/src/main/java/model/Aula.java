package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by wally on 27/12/15.
 */
public class Aula {
    String local, descricao;
    int codigo_turma, codigo_aula;
    Calendar data_aula, horario_aula;

    ArrayList<Presenca> presencas = new ArrayList<Presenca>();

    public Aula() {}

    public Aula(int codigo_turma, Calendar data_aula, Calendar horario_aula, String descricao, String local) {
        this.local = local;
        this.codigo_turma = codigo_turma;
        this.data_aula = data_aula;
        this.horario_aula = horario_aula;
        this.descricao = descricao;
    }

    public int getCodigo_aula() {
        return codigo_aula;
    }

    public void setCodigo_aula(int codigo_aula) {
        this.codigo_aula = codigo_aula;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCodigo_turma() {
        return codigo_turma;
    }

    public void setCodigo_turma(int codigo_turma) {
        this.codigo_turma = codigo_turma;
    }

    public Calendar getData_aula() {
        return data_aula;
    }

    public void setData_aula(Calendar data_aula) {
        this.data_aula = data_aula;
    }

    public Calendar getHorario_aula() {
        return horario_aula;
    }

    public void setHorario_aula(Calendar horario_aula) {
        this.horario_aula = horario_aula;
    }
}
