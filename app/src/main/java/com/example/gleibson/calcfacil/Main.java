package com.example.gleibson.calcfacil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Main extends AppCompatActivity {

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Método de ação do botão que chama a activity Regra de Tres.
     *
     * @param view botão.
     */
    public void regraDeTres(View view){
        Intent intentRegra = new Intent(Main.this, RegraDeTres.class);
        startActivity(intentRegra);
    }

    /**
     * Método de ação do botão que chama a activity Retira Porcentagem.
     *
     * @param view botão.
     */
    public void retiraPorncentagem(View view){
        Intent intentRetira = new Intent(Main.this, RetiraPorcentagem.class);
        startActivity(intentRetira);
    }

    /**
     * Método de ação do botão que chama a activity Soma Porcentagem.
     *
     * @param view botão.
     */
    public void somaPorncentagem(View view){
        Intent intentSoma = new Intent(Main.this, SomaPorcentagem.class);
        startActivity(intentSoma);
    }

    /**
     * Método de ação do botão que chama a activity Operações com Decimais.
     *
     * @param view botão.
     */
    public void operacaoDecimais(View view){
        Intent intentDecimais = new Intent(Main.this, OperDecimais.class);
        startActivity(intentDecimais);
    }

    /**
     * Método de ação do botão que chama a activity Divisão de Fração.
     *
     * @param view botão.
     */
    public void divisaoFracao(View view){
        Intent intentFracao = new Intent(Main.this, DivisaoFracao.class);
        startActivity(intentFracao);
    }

    /**
     *
     * @param menu
     * @return
     */
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
        return true;
    }

    /**
     *
     * @param item
     * @return
     */
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.sair:
                this.finish();
                Intent intente = new Intent(Intent.ACTION_MAIN);
                intente.addCategory(Intent.CATEGORY_HOME);
                intente.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intente);
                return false;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
