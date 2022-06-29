package com.example.how;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Jogadores extends AppCompatActivity {

    // Botões - tela Jogadores

    Button btnSalvarJog, btnExcluirJog;
    EditText nomeJogador, idadeJogador;
    ListView listaJogador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogadores);

        btnSalvarJog = findViewById(R.id.btnSalvarJoga);
        btnExcluirJog = findViewById(R.id.btnExcluirJoga);
        nomeJogador = findViewById(R.id.nomeJoga);
        idadeJogador = findViewById(R.id.idadeJoga);

        //Listeners

        btnSalvarJog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Jogador jogador;

                try {
                    jogador = new Jogador(1,nomeJogador.getText().toString(), Integer.parseInt(idadeJogador.getText().toString()));

                    Toast.makeText(Jogadores.this, jogador.toString(), Toast.LENGTH_SHORT).show();

                }
                catch (Exception e){
                    Toast.makeText(Jogadores.this, "Error", Toast.LENGTH_SHORT).show();
                    jogador = new Jogador(-1,"erro",0);

                }

                DBHelper dataBaseHelper = new DBHelper(Jogadores.this);

                boolean success = dataBaseHelper.addJogador(jogador);

                Toast.makeText(Jogadores.this, "Success"+ success, Toast.LENGTH_SHORT).show();
            }
        });

        btnExcluirJog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Jogadores.this, "BLABLALBA", Toast.LENGTH_SHORT).show();
            }
        });

    }
}