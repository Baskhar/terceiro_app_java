package com.example.switchemjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.slider.Slider;

public class MainActivity extends AppCompatActivity {


    private TextView texto;
    private Switch   seletor;
    private Button   botao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = findViewById(R.id.textView);
        seletor = findViewById(R.id.switch1);
        botao = findViewById(R.id.button);

        //função que configura o seletor
        seletor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                texto.setText(converterparatexto(b));//campo de texto recebe o valor que retorna da função 'converterparatexto'
            }
        });
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, converterparatexto(seletor.isChecked()), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String converterparatexto(boolean b) {
        //b = isChecked
        String textoExibir = "";
        if(b){
            textoExibir = "Ligado";
        }else{
            textoExibir = "Desligado";
        }
        return textoExibir;
    }
}