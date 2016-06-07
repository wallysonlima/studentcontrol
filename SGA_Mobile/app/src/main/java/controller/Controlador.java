package controller;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DiscenteDAO;
import dao.DocenteDAO;
import factory_method.DB;
import model.Discente;
import model.Docente;
import model.EstadoLogin;

/**
 * Created by wally on 27/12/15.
 */
public class Controlador {
    Docente docente = new Docente();
    Discente discente = new Discente();

    //Método de Login
    public int logar(String email, String senha ) {

        if ( (discente = (new DiscenteDAO()).buscarDiscente(email)) != null  )
            if ( discente.getSenha().equals(senha) )
                return EstadoLogin.DISCENTE.getOpcao();
            else
                return EstadoLogin.NAO_ENCONTROU.getOpcao();
        else if ( (docente = (new DocenteDAO()).buscarDocente( email )) != null )
            if ( docente.getSenha().equals(senha) )
                return EstadoLogin.DOCENTE.getOpcao();
            else
                return EstadoLogin.NAO_ENCONTROU.getOpcao();
        else return EstadoLogin.NAO_ENCONTROU.getOpcao();
    }

    public Docente getDocenteAtual() {
        return this.docente;
    }

    public Discente getDiscenteAtual() {
        return this.discente;
    }
}
