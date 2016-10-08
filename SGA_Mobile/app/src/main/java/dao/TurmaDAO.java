package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import factory_method.DB;
import model.Discente;
import model.Docente;
import model.Turma;

/**
 * Created by wally on 25/01/16.
 */
public class TurmaDAO {

    public ArrayList<Turma> getTurmaDocente(Docente docente) {
        DB conexao = new DB();
        String sql = String.format("select codigo_turma, codigo_disciplina, Turma.codigo_docente, nome_turma from" +
                        " Turma, Docente where Turma.codigo_docente = Docente.codigo_docente and" +
                        " Docente.codigo_docente = '%d' ORDER BY(nome_turma);", docente.getCodigo_docente() );

        ArrayList<Turma> lista = new ArrayList<Turma>();
        ResultSet rs = null;

        try {
            rs = conexao.select(sql);

            if ( rs != null )
                while( rs.next() ) {
                    Turma obj = new Turma();
                    obj.setCodigo_docente( rs.getInt("codigo_docente"));
                    obj.setCodigo_turma( rs.getInt("codigo_turma"));
                    obj.setCodigo_disciplina( rs.getInt("codigo_disciplina"));
                    obj.setNome( rs.getString("nome_turma") );

                    lista.add( obj );
                    obj = null;
                }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            conexao.desconecta();
        }

        return lista;
    }

    public ArrayList<Turma> getTurmaDiscente(Discente discente) {
        DB conexao = new DB();
        String sql = String.format("select Turma.codigo_turma from Turma, Discente_Turma, Discente where" +
                " Turma.codigo_turma = Discente_Turma.codigo_turma and" +
                " Discente_Turma.ra = Discente.ra and" +
                " Discente.ra = '%s';", discente.getRa() );

        ArrayList<Turma> lista = new ArrayList<Turma>();
        ResultSet rs = null;

        try {
            rs = conexao.select(sql);

            if ( rs != null )
                while( rs.next() ) {
                    Turma obj = new Turma();
                    obj.setCodigo_turma( rs.getInt("codigo_turma"));
                    lista.add( obj );
                    obj = null;
                }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            conexao.desconecta();
        }

        return lista;
    }
}