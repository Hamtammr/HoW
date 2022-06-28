package com.example.how;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Personagens extends AppCompatActivity {


    // Botões - tela Personagens

    Button btnSalvarPerso, btnExcluirPerso;
    EditText nomePerso, racaPerso, classePerso;
    ListView listaJogador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personagem);
    }
}