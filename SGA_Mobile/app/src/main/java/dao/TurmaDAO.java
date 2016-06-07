package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import factory_method.DB;
import model.Docente;
import model.Turma;

/**
 * Created by wally on 25/01/16.
 */
public class TurmaDAO {

    public ArrayList<Turma> getTurmaDocente(Docente docente) {
        DB conexao = new DB();
        String sql = String.format("select nome_turma from Turma, Docente where " +
                "Turma.codigo_docente = Docente.codigo_docente and Docente.email  = '%s';", docente.getEmail() );
        ArrayList<Turma> lista = new ArrayList<Turma>();
        ResultSet rs = null;

        try {
            rs = conexao.select(sql);

            if ( rs != null )
                while( rs.next() ) {
                    Turma obj = new Turma();
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
}