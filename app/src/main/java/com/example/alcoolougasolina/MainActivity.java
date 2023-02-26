package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);

    }

    public void calcularPreco(View view){

        //Recuperando valores digitados

        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //validar campos preenchidos

        Boolean camposValidados = validarCampo(precoAlcool, precoGasolina);
        if (camposValidados){

            Double valorAlcool   = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            /* Fazer Calulo de menor preço
             * Se (valorAlcool / valorGasolina) >= 0.7 é melhor utilizar gasolina
             * senão é melhor utilizar alcool
             */

            Double resultado = valorAlcool / valorGasolina;
            if(resultado >= 0.7){ textResultado.setText("Melhor utilizar gasolina");
            }else{ textResultado.setText("Melhor utilizar Alcool");}

        }else {
            textResultado.setText("Preencha os valores primeiro");
        }

    }

    public Boolean validarCampo(String pAlcool, String pGasolina){
        Boolean camposValidados = true;

        if(pAlcool == null || pAlcool.equals("")){ camposValidados = false;}
        else if(pGasolina == null || pGasolina.equals("")){ camposValidados = false;}

        return  camposValidados;
    }
}