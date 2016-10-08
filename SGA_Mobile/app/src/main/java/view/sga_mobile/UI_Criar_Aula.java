package view.sga_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import controller.Controlador;
import dao.TurmaDAO;
import model.Aula;
import model.Turma;

public class UI_Criar_Aula extends AppCompatActivity {
    Spinner turmaSpinner;
    ArrayAdapter<Turma> turmaAdapter;
    Controlador controlador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui__criar__aula);
        controlador = UI_LoginActivity.controlador;
        addTurmaSpinner();
    }

    public void addTurmaSpinner() {
        ArrayList<Turma> turmas;
        turmas = (new TurmaDAO()).getTurmaDocente(controlador.getDocenteAtual());
        turmaSpinner = (Spinner) findViewById(R.id.spinnerTurma);
        turmaAdapter = new ArrayAdapter<Turma>(this, android.R.layout.simple_list_item_single_choice, turmas);
        turmaSpinner.setAdapter(turmaAdapter);
        turmaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " selecionado", Toast.LENGTH_LONG).show();
                controlador.setTurma_atual((Turma) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void limparAula(View view) {
        ((EditText) findViewById(R.id.editTextData)).setText("");
        ((EditText) findViewById(R.id.editTextHorario)).setText("");
        ((EditText) findViewById(R.id.editTextLocal)).setText("");
        ((EditText) findViewById(R.id.editTextDescricao)).setText("");
    }

    public void criarAula(View view) {
        String strData = ((EditText) findViewById(R.id.editTextData)).getText().toString();
        String strHorario = ((EditText) findViewById(R.id.editTextHorario)).getText().toString();
        String local = ((EditText) findViewById(R.id.editTextLocal)).getText().toString();
        String descricao = ((EditText) findViewById(R.id.editTextDescricao)).getText().toString();
        int codigo_turma = controlador.getTurma_atual().getCodigo_turma();

        SimpleDateFormat formatter, formatterHora;
        Calendar data = Calendar.getInstance();
        Calendar hora = Calendar.getInstance();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatterHora = new SimpleDateFormat("HH:mm");

        try {
            data.setTime(formatter.parse(strData));
            hora.setTime(formatterHora.parse(strHorario));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (!strHorario.equals("") && !data.equals("") && !local.equals("") && !descricao.equals("")) {
            controlador.setAula_atual(new Aula(codigo_turma, data, hora, descricao, local));
            controlador.criarAula(codigo_turma, data, hora, local, descricao);
            Toast.makeText(UI_Criar_Aula.this, "Aula Criada com Sucesso !",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, UI_Frequencia.class);
            startActivity(intent);

        } else {
            Toast.makeText(UI_Criar_Aula.this, "Erro ! Preencha Todos os Campos !",
                    Toast.LENGTH_SHORT).show();
        }

    }
}
