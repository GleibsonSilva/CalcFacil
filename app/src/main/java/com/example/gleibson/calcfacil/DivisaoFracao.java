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

public class DivisaoFracao extends AppCompatActivity {

    private EditText num1, num2, num3, num4;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divisao_fracao);
    }

    /**
     * Método de ação do botão da activity Divisão de Fração.
     *
     * @param view botão.
     */
    public void botaoDivisaoFracao(View view){
        double n = calcularX();
        imprimirResult(n);
    }

    /**
     * Método de criação de uma caixa de diálogo para impressão do resultado da activity.
     *
     * @param x variável double resultante do cálculo.
     * @return caixa de diálogo para o usuário.
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
     * Método que calcula os valores e retorna o resultado.
     *
     * @return variável double.
     */
    public double calcularX(){
        double a, b, c, d, result;
        num1 = (EditText) findViewById(R.id.numerador1);
        num2 = (EditText) findViewById(R.id.numerador2);
        num3 = (EditText) findViewById(R.id.denominador1);
        num4 = (EditText) findViewById(R.id.denominador2);
        a = validaNumero(num1);
        b = validaNumero(num2);
        c = validaNumero(num3);
        d = validaNumero(num4);
        result = (a * d) / (c * b);
        return result;
    }

    /**
     * Método que limpa os campos de inserção de numeros.
     *
     * @param view botão.
     */
    public void limparDivisaoFracao(View view){
        num1 = (EditText) findViewById(R.id.numerador1);
        num2 = (EditText) findViewById(R.id.numerador2);
        num3 = (EditText) findViewById(R.id.denominador1);
        num4 = (EditText) findViewById(R.id.denominador2);
        num1.setText("");
        num2.setText("");
        num3.setText("");
        num4.setText("");
    }

    /**
     * Método que valida se os EditText estão vazios.
     *
     * @param field EditText da activity.
     * @return variável double com o valor infomado convertido para double.
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
     *
     * @param menu
     * @return
     */
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_geral, menu);
        return true;
    }

    /**
     *
     * @param item
     * @return
     */
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.inicio:
                Intent intent = new Intent(DivisaoFracao.this, Main.class);
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
