package model;

/**
 * Created by wally on 27/12/15.
 */
public enum EstadoLogin {
    NAO_ENCONTROU(0), DOCENTE(1), DISCENTE(2);

    private final int opcao;

    EstadoLogin(int opcao) {
        this.opcao = opcao;
    }

    public int getOpcao() {
        return this.opcao;
    }
}
