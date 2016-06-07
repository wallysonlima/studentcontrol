package model;

/**
 * Created by wally on 27/12/15.
 */
public class Presenca {
    String presenca, ra;

    public Presenca(String presenca, String ra) {
        this.presenca = presenca;
        this.ra = ra;
    }

    public String getPresenca() {
        return presenca;
    }

    public void setPresenca(String presenca) {
        this.presenca = presenca;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }
}
