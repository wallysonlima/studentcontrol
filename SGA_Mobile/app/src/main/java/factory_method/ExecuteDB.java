package factory_method;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by wally on 13/12/15.
 */
public class ExecuteDB extends AsyncTask<String, Void, ResultSet> {

    private Connection connection;
    private String query;

    public ExecuteDB(Connection connection, String query) {
        this.query = query;
        this.connection = connection;
    }

    @Override
    protected ResultSet doInBackground(String... params) {
        ResultSet resultSet = null;

        try {
            resultSet = connection.prepareStatement(query).executeQuery();
        } catch(Exception e) {

        } finally {
            try {
                //connection.close();
            } catch (Exception e) {

            }
        }

        return resultSet;
    }

    public void execute_Update() {

        try {
            connection.prepareStatement(query).executeUpdate();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
