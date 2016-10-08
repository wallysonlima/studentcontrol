package view.sga_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import controller.Controlador;
import dao.DisciplinaDAO;
import model.Discente;
import model.Disciplina;
import model.Turma;

public class UI_DiscenteFrequencia extends AppCompatActivity {
    Controlador controlador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui__discente_frequencia);
        controlador = UI_LoginActivity.controlador;
        preencherLinhasTabelaDiscente();
    }

    public void preencherLinhasTabelaDiscente() {
        TableLayout tabela = (TableLayout) findViewById(R.id.tableLayoutDiscFreq);
        float frequenciaDiscente[];
        frequenciaDiscente = controlador.getFrequenciaDiscente();
        ArrayList<Disciplina> disciplina = (new DisciplinaDAO()).getDisciplinaDiscente(controlador.getDiscenteAtual().getRa());
        int qtdeAulas = controlador.qtdeAula();
        ArrayList<Turma> turmas = controlador.getTurmasDiscentes();
        int k = 0;
        int i = 1;

        for( Disciplina di: disciplina ) {
            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);

            TextView textViewdisciplina = new TextView(this);
            textViewdisciplina.setText( di.getNome() );

            TextView frequencia = new TextView(this);
            frequencia.setText(Float.toString(frequenciaDiscente[k]) + " %");

            controlador.setTurma_atual(turmas.get(k) );
            qtdeAulas = controlador.qtdeAula();
            TextView qtdeAulasDadas = new TextView(this);
            qtdeAulasDadas.setText( Integer.toString( qtdeAulas ) );

            row.addView(textViewdisciplina);
            row.addView(frequencia);
            row.addView(qtdeAulasDadas);
            tabela.addView(row, i);
            i++;
            k++;
        }

    }

    public void sairActivityDiscente(View view) {
        this.finish();
    }
}
