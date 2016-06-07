package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory_method.DB;
import model.Docente;

/**
 * Created by wally on 27/12/15.
 */
public class DocenteDAO {

    public Docente buscarDocente(String email) {
        DB conexao = new DB();
        String sql = String.format( "SELECT * FROM Docente where email = '%s' ;", email);
        ResultSet rs = null;

        try {
            rs = conexao.select(sql);

            if ( rs.next() )
                return (new Docente(rs));
            else
                return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            conexao.desconecta();
        }

    }

    public Docente selectByEmail(String email){
        DB conexao = new DB();
        ResultSet rs = null;

        try{
            rs = conexao.select( String.format( "SELECT * FROM Docente where email = '%s' ;", email) );

            if ( rs.next() )
                return (new Docente(rs));
            else
                return null;

        }catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            conexao.desconecta();
        }
    }

    public ArrayList<Docente> getDocente() {
        String sql = "select * from Docente;";
        ArrayList<Docente> lista = new ArrayList<Docente>();
        DB conexao = new DB();

        try {
            ResultSet rs = conexao.select(sql);

            if ( rs != null ){
                while ( rs.next() ) {
                    Docente obj = new Docente();
                    obj.setNome(rs.getString("nome_docente"));
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
