package model;

/**
 * Created by wally on 29/01/16.
 */
public class DiscenteTurma {
    String ra;
    int codigo_turma;

    public DiscenteTurma() {}

    public DiscenteTurma(String ra, int codigo_turma) {
        this.ra = ra;
        this.codigo_turma = codigo_turma;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public int getCodigo_turma() {
        return codigo_turma;
    }

    public void setCodigo_turma(int codigo_turma) {
        this.codigo_turma = codigo_turma;
    }
}
