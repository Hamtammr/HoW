package com.example.how;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    //Constantes da tabela Jogador
    public static final String TABELA_JOGADOR = "TABELA_JOGADOR";
    public static final String COL_NOME_JOGADOR = "NomeJogador";
    public static final String COL_IDADE = "Idade";
    public static final String COL_IDJOGADOR = "IDJogador";

    //Constantes da tabela Personagem
    public static final String TABELA_PERSONAGEM = "TABELA_PERSONAGEM";
    public static final String COL_IDPERSONAGEM = "IDPersonagem";
    public static final String COL_NOME_PERSONAGEM = "NomePersonagem";
    public static final String COL_RACA = "Raca";
    public static final String COL_CLASSE = "Classe";

    //Constantes da tabela Campanha
    public static final String TABELA_CAMPANHA = "TABElA_CAMPANHA";
    public static final String COL_IDCAMPANHA = "IDCampanha";
    public static final String COL_NOME_CAMPANHA = "NomeCampanha";
    public static final String COL_SISTEMA = "Sistema";

    public DBHelper(@Nullable Context context) {
        super(context, "howDB.db", null, 1);
    }

    // Comando para criação de tabelas - Executado ao acessar o DB
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableJogador = "CREATE TABLE " + TABELA_JOGADOR + " (" + COL_IDJOGADOR + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NOME_JOGADOR + " TEXT, " + COL_IDADE + " INTEGER)";

        db.execSQL(createTableJogador);

        String createTablePersonagem = "CREATE TABLE " + TABELA_PERSONAGEM + " (" + COL_IDPERSONAGEM + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NOME_PERSONAGEM + " TEXT, " + COL_RACA + " TEXT, " + COL_CLASSE + " TEXT)";

        db.execSQL(createTablePersonagem);

        String createTableCampanha = "CREATE TABLE " + TABELA_CAMPANHA + " (" + COL_IDCAMPANHA + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NOME_CAMPANHA + " TEXT, " + COL_SISTEMA + " TEXT)";

        db.execSQL(createTableCampanha);



    }

    // Comando para atualização do banco de dados
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addJogador(Jogador jogador){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_NOME_JOGADOR, jogador.getNomeJogador());
        cv.put(COL_IDADE, jogador.getIdadeJogador());

        long insert = db.insert(TABELA_JOGADOR, null, cv);
        if (insert == -1) {
            return false;
        }else {
            return true;
        }
    }

    public boolean addPersonagem(Personagem personagem) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_NOME_PERSONAGEM, personagem.getNomePersonagem());
        cv.put(COL_RACA, personagem.getRaca());
        cv.put(COL_CLASSE, personagem.getClasse());

        long insert = db.insert(TABELA_PERSONAGEM, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }
}
