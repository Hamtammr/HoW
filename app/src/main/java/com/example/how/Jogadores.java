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

    Button btnSalvarPlayer;
    EditText nomePlayer, idadePlayer;
    ListView listaJogador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogadores);

        btnSalvarPlayer = findViewById(R.id.btnSalvarJoga);
        nomePlayer = findViewById(R.id.nomeJoga);
        idadePlayer = findViewById(R.id.idadeJoga);

        //Listeners

        btnSalvarPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Jogador jogador;

                try {
                    jogador = new Jogador(1,nomePlayer.getText().toString(), Integer.parseInt(idadePlayer.getText().toString()));

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

//        btnExcluirJog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(Jogadores.this, "BLABLALBA", Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}