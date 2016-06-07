package model;

import java.util.ArrayList;

/**
 * Created by wally on 27/12/15.
 */
public class Aula {
    String horario, local;
    ArrayList<Presenca> presencas = new ArrayList<Presenca>();

    public Aula(String horario, String local) {
        this.horario = horario;
        this.local = local;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
