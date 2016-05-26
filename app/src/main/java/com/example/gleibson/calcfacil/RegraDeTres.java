package com.example.gleibson.calcfacil;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegraDeTres extends AppCompatActivity {

    private EditText num1, num2, num3;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regra_tres);
    }

    /**
     * Método de ação do botão da activity "Regra de tres".
     *
     * @param view
     */
    public void botaoRegraTres(View view){
        double n = calcularX();
            imprimirResult(n);
    }

    /**
     * Método que cria uma caixa de diálogo, contendo a resposta.
     *
     * @param x resultado do cálculo.
     * @return caixa de diálogo.
     */
    public Dialog imprimirResult(double x){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Resultado");
        builder.setMessage("X vale: " + x);
        builder.setPositiveButton("Ok", null);
        AlertDialog dialog = builder.create();
        dialog.show();
        return dialog;
    }

    /**
     * Método que calcula a regra de tres.
     *
     * @return soma do cálculo;
     */
    public double calcularX(){
        double a, b, c, soma;
        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        num3 = (EditText) findViewById(R.id.num3);
        a = validaNumero(num1);
        b = validaNumero(num2);
        c = validaNumero(num3);
        soma = (b * c) / a;
        return soma;
    }

    /**
     * Método que limpa os campos para inserção de numeros.
     *
     * @param view botão.
     */
    public void limparRegraTres(View view){
        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        num3 = (EditText) findViewById(R.id.num3);
        num1.setText("");
        num2.setText("");
        num3.setText("");
    }

    /**
     * Método que testa se os EditText estão vazios antes do cálculo.
     *
     * @param field EditText utilizado.
     * @return variável double contendo o valor do EditText ja convertido para double.
     */
    public double validaNumero(EditText field){
        if (field.getText().toString().equals("")||field.getText().toString().equals(null)){
            Toast.makeText(this, "Insira valores para calcular!", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            double num = Double.parseDouble(field.getText().toString());
            return num;
        }
    }

    /**
     * Método que cria um menu inflando um layout de menu pré-definido.
     *
     * @param menu
     * @return
     */
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_geral, menu);
        return true;
    }

    /**
     * Método que cria os menus contidos no menu criado acima.
     *
     * @param item
     * @return
     */
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.inicio:
                Intent intent = new Intent(RegraDeTres.this, Main.class);
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
