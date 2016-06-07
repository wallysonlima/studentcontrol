package view.sga_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UI_Menu_Professor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iu__menu__professor);
    }

    public void criar_aula(View view) {
        Intent intent = new Intent(this, UI_Criar_Aula.class);
        startActivity(intent);
    }
}
