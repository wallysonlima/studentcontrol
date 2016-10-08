package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import factory_method.DB;

/**
 * Created by wally on 01/02/16.
 */
public class PresencaDAO {

    public int qtdePresenca(int codigo_turma, String ra) {
        DB conexao = new DB();
        String sql = String.format("select count(presenca) from Presenca, Aula, Discente_Turma where" +
                " Presenca.codigo_aula = Aula.codigo_aula and" +
                " Aula.codigo_turma = Discente_Turma.codigo_turma and" +
                " Presenca.ra = Discente_Turma.ra and" +
                " Discente_Turma.ra = '%s' and" +
                " Discente_Turma.codigo_turma = '%d';", ra, codigo_turma);

        int qtde = 0;

        try {
            ResultSet rs = conexao.select(sql);
            rs.first();
            qtde = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return qtde;
    }

    public void inserirPresenca(int codigo_aula, String ra, boolean presenca) {
        DB conexao = new DB();
        String sql = "Insert into Presenca (codigo_aula, ra, presenca) values (?, ?, ?);";
        conexao.conecta();
        PreparedStatement ps = null;

        try {
            ps = conexao.getConn().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ps.setInt(1, codigo_aula);
            ps.setString(2, ra);
            ps.setBoolean(3, presenca );
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.desconecta();
        }
    }
}
