package model;

/**
 * Created by wally on 27/12/15.
 */
public class Presenca {
    String ra;
    int codigo_aula;
    boolean presenca;

    public Presenca(String ra, int codigo_aula, boolean presenca) {
        this.ra = ra;
        this.codigo_aula = codigo_aula;
        this.presenca = presenca;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public int getCodigo_aula() {
        return codigo_aula;
    }

    public void setCodigo_aula(int codigo_aula) {
        this.codigo_aula = codigo_aula;
    }

    public boolean getPresenca() {
        return presenca;
    }

    public void setPresenca(boolean presenca) {
        this.presenca = presenca;
    }
}
