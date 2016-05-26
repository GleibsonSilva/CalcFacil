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

public class SomaPorcentagem extends AppCompatActivity {

    private EditText num1, num2;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soma_porcentagem);
    }

    /**
     * Método de ação do botão da activity de Soma de porcentagem.
     *
     * @param view botão da activity.
     */
    public void botaoSomaPorcentagem(View view){
        double n = calcularX();
        imprimirResult(n);
    }

    /**
     * Método que cria uma caixa de diálogo com o resultado do cálculo.
     *
     * @param x resultado do cálculo numa variável double.
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
     * Método que calcula o valor da porcentagem somada ao numero.
     *
     * @return variável double contendo o resultado.
     */
    public double calcularX(){
        double a, b, produto;
        num1 = (EditText) findViewById(R.id.num_1);
        num2 = (EditText) findViewById(R.id.num_2);
        a = validaNumero(num1);
        b = validaNumero(num2);
        produto = ((a / 100) + 1) * b;
        return produto;
    }

    /**
     * Método que limpa os campos para inserção de numeros.
     *
     * @param view botão limpar
     */
    public void limparSomaPorcentagem(View view){
        num1 = (EditText) findViewById(R.id.num_1);
        num2 = (EditText) findViewById(R.id.num_2);
        num1.setText("");
        num2.setText("");
    }

    /**
     * Método que valida se os EditText estão vazios.
     *
     * @param field EditText da activity.
     * @return variável double contendo o valor digitado pelo usuário, ja convertido para double.
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
                Intent intent = new Intent(SomaPorcentagem.this, Main.class);
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