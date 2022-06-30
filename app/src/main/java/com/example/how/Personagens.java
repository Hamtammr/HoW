package com.example.how;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    Button btnSalvarChar,btn_pesqChar;
    EditText nomeChar, racaChar, classeChar,idChar;
    ListView listaChar;

    ArrayAdapter persoArrayAdapter;
    DBHelper dbHelper ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personagens);

        btnSalvarChar = findViewById(R.id.btnSalvarPerso);
        nomeChar = findViewById(R.id.nomePerso);
        racaChar = findViewById(R.id.racaPerso);
        classeChar = findViewById(R.id.classePerso);
        idChar = findViewById((R.id.idPerso));
        btn_pesqChar = findViewById(R.id.btn_pesqPerso);
        listaChar = findViewById(R.id.listaPerso);

        dbHelper = new DBHelper(Personagens.this);
        listarPersonagens(dbHelper);


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
                listarPersonagens(dbHelper);


            }
        });

//        btnExcluirChar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(Personagens.this, "BLABLALBA", Toast.LENGTH_SHORT).show();
//            }
//        });

        btn_pesqChar.setOnClickListener(view -> {

            DBHelper dbHelper = new DBHelper(Personagens.this);

            listarPersonagens(dbHelper);

            //Toast.makeText(Personagens.this, todosPerso.toString(), Toast.LENGTH_SHORT).show();
        });

//        listaChar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//            }
//        });


        listaChar.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Personagem perso_Click = (Personagem) parent.getItemAtPosition(position);
                dbHelper.deletePersonagem(perso_Click);
                listarPersonagens(dbHelper);
                Toast.makeText(Personagens.this, "Deletado" + perso_Click.toString(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

//        listaChar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Personagem perso_Click = (Personagem) parent.getItemAtPosition(position);
//                dbHelper.deletePersonagem(perso_Click);
//                listarPersonagens(dbHelper);
//                Toast.makeText(Personagens.this, "Deletado" + perso_Click, Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    private void listarPersonagens(DBHelper dbHelper2) {
        persoArrayAdapter = new ArrayAdapter<Personagem>(Personagens.this, android.R.layout.simple_list_item_1, dbHelper2.getPersonagens());
        listaChar.setAdapter(persoArrayAdapter);
    }
}