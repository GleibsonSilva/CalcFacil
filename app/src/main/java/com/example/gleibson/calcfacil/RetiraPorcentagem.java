package com.example.gleibson.calcfacil;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;

public class RetiraPorcentagem extends AppCompatActivity {

    private EditText num1, num2;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retira_porcentagem);
    }

    /**
     * Método de ação do botão da activity Retiva Porcentagem.
     *
     * @param view botão calcular X.
     */
    public void botaoRetiraPorcentagem(View view) {
        double n = calcularX();
        imprimirResult(n);
    }

    /**
     * Método que cria uma caixa de diálogo com a resposta do cálculo.
     *
     * @param x variável double a ser mostrada.
     * @return dialogo ao usuário.
     */
    public Dialog imprimirResult(double x) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Resultado");
        builder.setMessage("X vale: " + x);
        builder.setPositiveButton("Ok", null);
        AlertDialog dialog = builder.create();
        dialog.show();
        return dialog;
    }

    /**
     * Método que calcula os valores da porcentagem.
     *
     * @return produto calculado.
     */
    public double calcularX() {
        double a, b, produto;
        num1 = (EditText) findViewById(R.id.numero1);
        num2 = (EditText) findViewById(R.id.numero2);
        a = validaNumero(num1);
        b = validaNumero(num2);
        produto = (a / 100) * b;
        return produto;
    }

    /**
     * Método que limpa os campos de inserção de numeros.
     *
     * @param view botão limpar.
     */
    public void limparRetiraPorcentagem(View view) {
        num1 = (EditText) findViewById(R.id.numero1);
        num2 = (EditText) findViewById(R.id.numero2);
        num1.setText("");
        num2.setText("");
    }

    /**
     * Método que valida se os EditText estão vazios.
     *
     * @param field EditText
     * @return variavel double contendo o conteúdo do EditText convertido para double.
     */
    public double validaNumero(EditText field) {
        if (field.getText().toString().equals("") || field.getText().toString().equals(null)) {
            Toast.makeText(this, "Insira valores para calcular!", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            double num = Double.parseDouble(field.getText().toString());
            return num;
        }
    }

    /**
     * @param menu
     * @return
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_geral, menu);
        return true;
    }

    /**
     * @param item
     * @return
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.inicio:
                Intent intent = new Intent(RetiraPorcentagem.this, Main.class);
                startActivity(intent);
                finish();
                return false;

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