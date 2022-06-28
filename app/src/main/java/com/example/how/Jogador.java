package com.example.how;

public class Jogador {
    private int IDJogador;
    private String nomeJogador;
    private int idadeJogador;

    public Jogador(int IDJogador, String nomeJogador, int idadeJogador) {
        this.IDJogador = IDJogador;
        this.nomeJogador = nomeJogador;
        this.idadeJogador = idadeJogador;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "IDJogador=" + IDJogador +
                ", nomeJogador='" + nomeJogador + '\'' +
                ", idadeJogador=" + idadeJogador +
                '}';
    }

    public int getIDJogador() {
        return IDJogador;
    }

    public void setIDJogador(int IDJogador) {
        this.IDJogador = IDJogador;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public int getIdadeJogador() {
        return idadeJogador;
    }

    public void setIdadeJogador(int idadeJogador) {
        this.idadeJogador = idadeJogador;
    }
}

