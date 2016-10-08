package controller;

import java.util.ArrayList;
import java.util.Calendar;

import dao.AulaDAO;
import dao.DiscenteDAO;
import dao.DiscenteTurmaDAO;
import dao.DocenteDAO;
import dao.PresencaDAO;
import dao.TurmaDAO;
import model.Aula;
import model.Discente;
import model.Docente;
import model.Turma;

/**
 * Created by wally on 27/12/15.
 */
public class Controlador {
    public static final int erroLogon = 0;
    public static final int logonDocente = 1;
    public static final int logonDiscente = 2;
    private Docente docente = new Docente();
    private Discente discente_atual = new Discente();
    private Turma turma_atual;
    private ArrayList<Discente> discentesTurmaAtual;
    private Aula aula_atual = new Aula();

    //Método de Login
    public int logar(String email, String senha) {

        if ((discente_atual = (new DiscenteDAO()).buscarDiscente(email)) != null) {
            if (discente_atual.getSenha().equals(senha))
                return logonDiscente;
            else
                return erroLogon;
        } else if ((docente = (new DocenteDAO()).buscarDocente(email)) != null) {
            if (docente.getSenha().equals(senha))
                return logonDocente;
            else
                return erroLogon;
        } else return erroLogon;
    }

    //Fiz uma gambiarra no CriarAula pois tinha feito a aula sem recuperar o codigo_aula, e eu preciso dele para a presenca
    public void criarAula(int codigo_turma, Calendar data_aula, Calendar horario_aula, String local, String descricao) {
        (new AulaDAO()).inserirAula(codigo_turma, data_aula, horario_aula, local, descricao);
        int codigo = (new AulaDAO()).getCodigo_aula(aula_atual);
        aula_atual.setCodigo_aula(codigo);
    }

    public ArrayList<Discente> getDiscentesDaTurma() {
        return ( discentesTurmaAtual = (new DiscenteTurmaDAO()).getDiscenteDaTurma( turma_atual.getCodigo_turma() ) );
    }

    public void inserirPresenca(int codigo_aula, String ra, boolean presenca) {
        (new PresencaDAO()).inserirPresenca(codigo_aula, ra, presenca);
    }

    public int qtdeAula() {
        return (new AulaDAO()).qtdeAulas( turma_atual.getCodigo_turma() );
    }

    public float[] getFrequencia() {
        int qtdeAula = qtdeAula();
        int presenca, i = 0;
        float frequencia[] = new float [60];

        for( Discente di: discentesTurmaAtual ) {
            presenca = ( new PresencaDAO()).qtdePresenca( turma_atual.getCodigo_turma(), di.getRa() );

            if ( presenca != 0 ) {
                frequencia[i] = ( (float) presenca * 100 ) / (float) qtdeAula;
                i++;
            }
            else {
                frequencia[i] = 0;
                i++;
            }
        }

        return frequencia;
    }

    public float[] getFrequenciaDiscente() {
        ArrayList<Turma> turmas = (new TurmaDAO()).getTurmaDiscente( discente_atual );
        float frequencia[] = new float[60];
        int i = 0;

        for( Turma tu: turmas ){
            turma_atual = tu;
            int qtdeAula = qtdeAula();
            int presenca = ( new PresencaDAO()).qtdePresenca( turma_atual.getCodigo_turma(), discente_atual.getRa() );

            if ( presenca != 0 ) {
                frequencia[i] = ( (float) presenca * 100 ) / (float) qtdeAula;
                i++;
            }
            else {
                frequencia[i] = 0;
                i++;
            }
        }

        return frequencia;
    }

    public ArrayList<Turma> getTurmasDiscentes() {
        return (new TurmaDAO()).getTurmaDiscente( getDiscenteAtual() );
    }

    public Docente getDocenteAtual() {
        return this.docente;
    }

    public Discente getDiscenteAtual() {
        return this.discente_atual;
    }

    public Turma getTurma_atual() {
        return turma_atual;
    }

    public void setTurma_atual(Turma turma_atual) {
        this.turma_atual = turma_atual;
    }

    public Aula getAula_atual() {
        return aula_atual;
    }

    public void setAula_atual(Aula aula_atual) {
        this.aula_atual = aula_atual;
    }
}
