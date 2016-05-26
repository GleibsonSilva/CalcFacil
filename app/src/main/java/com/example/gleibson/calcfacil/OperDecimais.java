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
import android.widget.RadioGroup;
import android.widget.Toast;

public class OperDecimais extends AppCompatActivity {

    private EditText num1, num2;
    private RadioGroup radio;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oper_decimais);
    }

    /**
     * Método de ação do botão da activity Operações com decimais.
     *
     * @param view botão de calcular X.
     */
    public void botaoDecimais(View view) {
        double n = calcularX();
        imprimirResult(n);
    }

    /**
     * Método que cria uma caixa de diálogo com o resultado do cálculo realizado pela activity.
     *
     * @param x variável double resultante do calculo.
     * @return caixa de diálogo.
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
     * Método que calcula as operações com os numero decimais.
     *
     * @return resultado da operação escolhida numa variável double.
     */
    public double calcularX() {
        double a, b, resultado = 0;
        num1 = (EditText) findViewById(R.id.numero_1);
        num2 = (EditText) findViewById(R.id.numero_2);
        radio = (RadioGroup) findViewById(R.id.radio_operacoes);
        a = validaNumero(num1);
        b = validaNumero(num2);
        int opcao = radio.getCheckedRadioButtonId();
        if (opcao == R.id.mais) {
            resultado = a + b;
        }else {
            if (opcao == R.id.menos) {
                resultado = a - b;
            } else {
                if (opcao == R.id.vezes) {
                    resultado = a * b;
                } else {
                    if (opcao == R.id.divisao) {
                        if (b == 0) {
                            Toast.makeText(this, "Não existe divisão por 0!",
                                    Toast.LENGTH_SHORT).show();
                        }
                        resultado = a / b;
                    }
                }
            }
        }
        return resultado;
    }

    /**
     * Método que limpa os campos da tela para inserção de numeros.
     *
     * @param view botão.
     */
    public void limparOperDecimais(View view){
        num1 = (EditText) findViewById(R.id.numero_1);
        num2 = (EditText) findViewById(R.id.numero_2);
        num1.setText("");
        num2.setText("");
    }

    /**
     * Método que verifica se os EditTexts estão vazios.
     *
     * @param field EditText da view.
     * @return variável double contendo o valor digitado pelo usuário convertido para double.
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_geral, menu);
        return true;
    }

    /**
     *
     * @param item
     * @return
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.inicio:
                Intent intent = new Intent(OperDecimais.this, Main.class);
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