package dao;

import android.support.annotation.NonNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory_method.DB;
import model.DiscenteTurma;
import model.Disciplina;

/**
 * Created by wally on 29/01/16.
 */
public class DisciplinaDAO {

    public Disciplina getDisciplinaTurma(@NonNull int codigo_disciplina) {
        DB conexao = new DB();
        String sql = String.format("select Disciplina.codigo_disciplina, nome_disciplina from Disciplina, Turma" +
                " where Disciplina.codigo_disciplina = Turma.codigo_disciplina and" +
                " Disciplina.codigo_disciplina = '%d';", codigo_disciplina);


        ResultSet rs = null;
        try {
            rs = conexao.select(sql);

            if (rs.first())
                return (new Disciplina(rs));

            else
                return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            conexao.desconecta();
        }


    }

    public ArrayList<Disciplina> getDisciplinaDiscente(String ra) {
        DB conexao = new DB();
        String sql = String.format("select nome_disciplina from Disciplina, Discente_Turma, Turma where" +
                " Disciplina.codigo_disciplina = Turma.codigo_disciplina and" +
                " Discente_Turma.codigo_turma = Turma.codigo_turma and" +
                " Discente_Turma.ra = '%s';", ra);


        ResultSet rs = null;
        ArrayList<Disciplina> lista = new ArrayList<Disciplina>();

        try {
            rs = conexao.select(sql);

            if ( rs != null ){
                while ( rs.next() ) {
                    Disciplina obj = new Disciplina();
                    obj.setNome(rs.getString("nome_disciplina"));
                    lista.add(obj);
                    obj = null;
                }
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            conexao.desconecta();
        }

        return lista;
    }
}
