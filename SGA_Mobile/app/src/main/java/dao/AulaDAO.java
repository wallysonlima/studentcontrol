package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import factory_method.DB;
import model.Aula;

/**
 * Created by wally on 27/01/16.
 */
public class AulaDAO {

    public void inserirAula(int codigo_turma, Calendar data_aula, Calendar horario_aula, String local, String descricao) {
        DB conexao = new DB();
        String sql = "Insert into Aula (codigo_turma, data_aula, horario_aula, descricao, local) values(?, ?, ?, ?, ?);";
        conexao.conecta();
        PreparedStatement ps = null;
        long time = horario_aula.getTimeInMillis();
        try {
            ps = conexao.getConn().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ps.setInt(1, codigo_turma);
            ps.setDate(2, new java.sql.Date(data_aula.getTimeInMillis()));
            ps.setTimestamp(3, new java.sql.Timestamp(time));
            ps.setString(4, descricao);
            ps.setString(5, local);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.desconecta();
        }
    }

    public int qtdeAulas(int codigo_turma) {
        DB conexao = new DB();
        String sql = String.format("Select count(codigo_aula) from Aula, Turma where" +
                " Aula.codigo_turma = Turma.codigo_turma and Turma.codigo_turma = %d;", codigo_turma);
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

    public int getCodigo_aula(Aula aula) {
        DB conexao = new DB();
        String sql = String.format("Select codigo_aula from Aula where" +
                " codigo_turma = %d and descricao = '%s' and local = '%s';",
                aula.getCodigo_turma(), aula.getDescricao(), aula.getLocal());
        int codigo = -1;

        ResultSet rs = conexao.select(sql);
        try {
            rs.first();
            codigo = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return codigo;
    }

}
