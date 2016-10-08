package view.sga_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import controller.Controlador;
import dao.DisciplinaDAO;
import dao.TurmaDAO;
import model.Discente;
import model.Turma;

public class UI_VerPresenca extends AppCompatActivity {
    Spinner turmaSpinner;
    Controlador controlador = UI_LoginActivity.controlador;
    EditText qtdeAula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui__ver_presenca);
        addTurmaSpinner();
    }


    public void sairActivity(View view) {
        this.finish();
        Intent mainActivity = new Intent(UI_VerPresenca.this, UI_Menu_Professor.class);
        startActivity(mainActivity);
    }

    public void addTurmaSpinner() {
        ArrayList<Turma> turmas;
        ArrayAdapter<Turma> turmaAdapter;
        turmas = (new TurmaDAO()).getTurmaDocente(controlador.getDocenteAtual());
        turmaSpinner = (Spinner) findViewById(R.id.turmaSpinner);
        turmaAdapter = new ArrayAdapter<Turma>(this, android.R.layout.simple_list_item_single_choice, turmas);
        turmaSpinner.setAdapter(turmaAdapter);
        turmaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " selecionado", Toast.LENGTH_LONG).show();
                controlador.setTurma_atual((Turma) parent.getItemAtPosition(position));
                qtdeAula =  (EditText) findViewById(R.id.editTextQtdeAulas);
                qtdeAula.setText(Integer.toString(controlador.qtdeAula()));
                preencherLinhasTabelas();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void preencherLinhasTabelas() {
        ArrayList<Discente> discentesDaTurma = controlador.getDiscentesDaTurma();
        TableLayout tabela = (TableLayout) findViewById(R.id.tableLayoutVerPresenca);
        float frequenciaDiscente[];
        frequenciaDiscente = controlador.getFrequencia();
        String disciplina = ((new DisciplinaDAO()).getDisciplinaTurma(controlador.getTurma_atual().getCodigo_disciplina())).getNome();

        for( Discente di: discentesDaTurma ) {
            int i = 1;
            int k = 0;
            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);

            TextView textViewdisciplina = new TextView(this);
            textViewdisciplina.setText(disciplina);

            TextView discente = new TextView(this);
            discente.setText(di.getNome());

            TextView frequencia = new TextView(this);
            frequencia.setText(Float.toString(frequenciaDiscente[k]) + " %");

            row.addView(discente);
            row.addView(frequencia);
            row.addView(textViewdisciplina);
            tabela.addView(row, i);
            i++;
        }

    }
}
