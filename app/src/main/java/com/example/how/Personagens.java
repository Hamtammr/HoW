package com.example.how;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Personagens extends AppCompatActivity {

    // Botões - tela Personagens

    Button btnSalvarChar, btnExcluirChar,pesquisarChar;
    EditText nomeChar, racaChar, classeChar,idChar;
    ListView listaChar;
    ArrayAdapter persoArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personagens);

        btnSalvarChar = findViewById(R.id.btnSalvarPerso);
        btnExcluirChar = findViewById(R.id.btnExcluirPerso);
        nomeChar = findViewById(R.id.nomePerso);
        racaChar = findViewById(R.id.racaPerso);
        classeChar = findViewById(R.id.classePerso);
        idChar = findViewById((R.id.idPerso));
        pesquisarChar = findViewById(R.id.pesquisaPerso);

        //Listeners

        btnSalvarChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Personagem personagem;

                try {
                    personagem = new Personagem(1,nomeChar.getText().toString(),classeChar.getText().toString(),racaChar.getText().toString() );
                    Toast.makeText(Personagens.this, personagem.toString(), Toast.LENGTH_SHORT).show();
                }
                catch(Exception e) {
                    Toast.makeText(Personagens.this, "Error", Toast.LENGTH_SHORT).show();
                    personagem = new Personagem(-1, "erro", "nulo", "nulo");
                }

                DBHelper dataBaseHelper = new DBHelper(Personagens.this);

                boolean success = dataBaseHelper.addPersonagem(personagem);

                Toast.makeText(Personagens.this, "Success"+ success, Toast.LENGTH_SHORT).show();


            }
        });

       pesquisarChar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               DBHelper dbHelper = new DBHelper(Personagens.this);
               List<Personagem> everyPerso = dbHelper.getPersonagens();

               persoArrayAdapter = new ArrayAdapter<Personagem>(Personagens.this, android.R.layout.simple_list_item_1, everyPerso);
               listaChar.setAdapter(persoArrayAdapter);

               //Toast.makeText(Personagens.this, everyPerso.toString(), Toast.LENGTH_SHORT).show();
           }
       });

        btnExcluirChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Personagens.this, "BLABLALBA", Toast.LENGTH_SHORT).show();
            }
        });

    }
}