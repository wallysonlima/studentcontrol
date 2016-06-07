package view.sga_mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import dao.TurmaDAO;
import model.Turma;

public class UI_Criar_Aula extends AppCompatActivity {
    Spinner turmaSpinner;
    ArrayAdapter<Turma> turmaAdapter;
    UI_LoginActivity login = new UI_LoginActivity();
    Turma turmaSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui__criar__aula);
        addTurmaSpinner();
    }

    public void addTurmaSpinner() {
        ArrayList<Turma> turmas;
        turmas = (new TurmaDAO()).getTurmaDocente( login.controlador.getDocenteAtual() );

        turmaSpinner = (Spinner) findViewById(R.id.spinnerTurma);
        turmaAdapter = new ArrayAdapter<Turma>(this, android.R.layout.simple_spinner_item, turmas );
        turmaSpinner.setAdapter(turmaAdapter);
        turmaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " selecionado", Toast.LENGTH_LONG ).show();
                turmaSelecionado = (Turma) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
