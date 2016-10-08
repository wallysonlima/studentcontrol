package view.sga_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import controller.Controlador;
import factory_method.DB;
import model.Discente;


public class UI_LoginActivity extends AppCompatActivity {
    public static Controlador controlador = new Controlador();
    Button btEntrar, btLimpar;
    EditText email, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void limpar(View view) {
        ((EditText) findViewById(R.id.edEmail)).setText("");
        ((EditText) findViewById(R.id.edSenha)).setText("");
    }


    public void login(View view) {
        btLimpar = (Button) findViewById(R.id.btLimpar);
        btEntrar = (Button) findViewById(R.id.btEntrar);
        email = (EditText) findViewById(R.id.edEmail);
        senha = (EditText) findViewById(R.id.edSenha);
        Discente aluno = new Discente();

        if (new DB().is_status()) {
            // Faz o login no controlador
            int login = controlador.logar(email.getText().toString(), senha.getText().toString());

            // Obtém resposta e compara para saber se é aluno ou professor ou não fez o login
            if (login == Controlador.logonDiscente) {
                Toast.makeText(UI_LoginActivity.this, "Discente efetuou o login com sucesso !",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, UI_DiscenteFrequencia.class);
                startActivity(intent);

            } else if (login == Controlador.logonDocente) {
                Toast.makeText(UI_LoginActivity.this, "Docente efetuou o login com sucesso !",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, UI_Menu_Professor.class);
                startActivity(intent);
            } else if (login == Controlador.erroLogon) {
                Toast.makeText(UI_LoginActivity.this, "Erro no email ou senha !",
                        Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(UI_LoginActivity.this, "Erro ! Problema ao conectar o Banco de Dados !",
                    Toast.LENGTH_SHORT).show();
        }

    }
}

