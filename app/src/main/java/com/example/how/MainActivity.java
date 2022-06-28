package com.example.how;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.playersBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openJogadores();
            }
        });
        button = (Button) findViewById(R.id.charBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPersonagens();
            }
        });
        button = (Button) findViewById(R.id.campBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCampanhas();
            }
        });
    }
    public void openJogadores(){
        Intent intent = new Intent(this, Jogadores.class);
        startActivity(intent);
    }
    public void openPersonagens(){
        Intent intent = new Intent(this, Personagens.class);
        startActivity(intent);
    }
    public void openCampanhas(){
        Intent intent = new Intent(this, Campanhas.class);
        startActivity(intent);
    }
}