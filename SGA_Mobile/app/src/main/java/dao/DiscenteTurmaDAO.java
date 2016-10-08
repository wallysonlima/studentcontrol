package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory_method.DB;
import model.Discente;
import model.DiscenteTurma;

/**
 * Created by wally on 29/01/16.
 */
public class DiscenteTurmaDAO {

    public ArrayList<Discente> getDiscenteDaTurma(int codigo_turma) {
        DB conexao = new DB();
        String sql = String.format("select Discente.ra, nome_discente from Discente_Turma, Turma, Discente where" +
                " Turma.codigo_turma = Discente_Turma.codigo_turma and" +
                " Discente_Turma.ra = Discente.ra and Discente_Turma.codigo_turma = '%d' ORDER BY(nome_discente) DESC;", codigo_turma);

        ArrayList<Discente> lista = new ArrayList<Discente>();
        ResultSet rs = null;

        try {
            rs = conexao.select(sql);

            if ( rs != null )
                while( rs.next() ) {
                    Discente obj = new Discente();
                    obj.setRa( rs.getString("ra") );
                    obj.setNome( rs.getString("nome_discente") );

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

    public ArrayList<DiscenteTurma> getDiscenteTurma() {
        DB conexao = new DB();
        String sql = "select * from Discente_Turma;";
        ResultSet rs;
        ArrayList<DiscenteTurma> lista = new ArrayList<DiscenteTurma>();

        try {
            rs = conexao.select(sql);

            if ( rs != null ){
                while ( rs.next() ) {
                    DiscenteTurma obj = new DiscenteTurma();
                    obj.setRa(rs.getString("ra"));
                    obj.setCodigo_turma(rs.getInt("codigo_turma"));
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
