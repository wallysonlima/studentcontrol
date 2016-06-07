package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import factory_method.DB;
import model.Discente;

/**
 * Created by Luiz on 9/27/2015.
 */
public class DiscenteDAO {

    public Discente buscarDiscente(String email) {
        DB conexao = new DB();
        String sql = String.format( "SELECT * FROM Discente where email = '%s' ;", email);
        ResultSet rs = null;
        try {
            rs = conexao.select(sql);

            if ( rs.first() )
                return ( new Discente(rs) );

            else
                return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            conexao.desconecta();
        }

    }

    public Discente selectByEmail(String email){
        DB conexao = new DB();
        ResultSet rs = null;
        rs = conexao.select( String.format( "SELECT * FROM Discente where email = '%s' ;", email) );

        try {
            if (rs.first() )
                return (new Discente(rs));

            else
                return null;
        } catch( SQLException e ){
            throw new RuntimeException();
        } finally {
            conexao.desconecta();
        }

    }

    public ArrayList<Discente> getDiscente() {
        DB conexao = new DB();
        String sql = "select * from Discente;";
        ArrayList<Discente> lista = new ArrayList<Discente>();
        ResultSet rs = null;

        try {
            rs = conexao.select(sql);

            if ( rs != null ){
                while ( rs.next() ) {
                    Discente obj = new Discente();
                    obj.setRa(rs.getString("ra"));
                    obj.setNome(rs.getString("nome_discente"));
                    obj.setEmail(rs.getString("email"));
                    obj.setSenha((rs.getString("senha")));

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
