package view.sga_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import controller.Controlador;
import dao.AulaDAO;
import dao.DisciplinaDAO;
import model.Discente;

public class UI_Frequencia extends AppCompatActivity {
    Controlador controlador;
    EditText disciplina, turma, data, aulas_dadas;
    ArrayList<Discente> discentesDaTurma;
    TableLayout tabela;
    float frequenciaDiscente[];
    ArrayList<EditText> listaEditText = new ArrayList<EditText>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui__frequencia);
        controlador = UI_LoginActivity.controlador;
        disciplina = (EditText) findViewById(R.id.editTextDisciplina);
        disciplina.setText(((new DisciplinaDAO()).getDisciplinaTurma(controlador.getTurma_atual().getCodigo_disciplina())).getNome());
        turma = (EditText) findViewById(R.id.editTextTurma);
        turma.setText(controlador.getTurma_atual().getNome());
        data = (EditText) findViewById(R.id.editTextData);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        data.setText(format.format(controlador.getAula_atual().getData_aula().getTime()));
        aulas_dadas = (EditText) findViewById(R.id.editTextAulasDadas);
        aulas_dadas.setText(Integer.toString((new AulaDAO()).qtdeAulas(controlador.getTurma_atual().getCodigo_turma())));

        preencherLinhasTabelas();
    }

    public void registrarFrequencia(View view) {
        int linha = 0;

        for( Discente di: discentesDaTurma ) {
            //TableRow row = (TableRow) tabela.getChildAt( linha );
            //EditText et = (EditText) row.getChildAt(COLUNA);
            boolean presenca;

            if ( !listaEditText.get(linha).getText().toString().equals("0") )
                presenca = true;
            else
                presenca = false;

            controlador.inserirPresenca(
                    controlador.getAula_atual().getCodigo_aula(),
                    di.getRa(),
                    presenca);

            linha++;
        }

        Toast.makeText(UI_Frequencia.this, "Presença Inserida com Sucesso !",
                Toast.LENGTH_SHORT).show();

        this.finish();
        Intent mainActivity = new Intent(UI_Frequencia.this, UI_Menu_Professor.class);
        startActivity(mainActivity);
    }

    public void sair(View view) {
        this.finish();
        Intent mainActivity = new Intent(UI_Frequencia.this, UI_Menu_Professor.class);
        startActivity(mainActivity);
    }

    public void preencherLinhasTabelas() {
        discentesDaTurma = controlador.getDiscentesDaTurma();
        tabela = (TableLayout) findViewById(R.id.tableLayoutFrequencia);
        frequenciaDiscente = controlador.getFrequencia();

        for( Discente di: discentesDaTurma ) {
            int i = 1;
            int k = 0;
            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);

            TextView ra = new TextView(this);
            ra.setText(di.getRa());

            TextView discente = new TextView(this);
            discente.setText(di.getNome());

            TextView frequencia = new TextView(this);
            frequencia.setText(Float.toString(frequenciaDiscente[k]) + " %");

            EditText presenca = new EditText(this);
            presenca.setInputType(InputType.TYPE_CLASS_NUMBER);
            presenca.setText("1");
            listaEditText.add(presenca);

            row.addView(ra);
            row.addView(discente);
            row.addView(frequencia);
            row.addView(presenca);
            tabela.addView(row, i);
            i++;
        }

    }
}
