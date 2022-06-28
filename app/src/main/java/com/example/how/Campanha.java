package com.example.how;

public class Campanha {
    private int IDcamp;
    private String nome;
    private String sistema;

    public Campanha(int IDcamp, String nome, String sistema) {
        this.IDcamp = IDcamp;
        this.nome = nome;
        this.sistema = sistema;
    }

    @Override
    public String toString() {
        return "Campanha{" +
                "IDcamp=" + IDcamp +
                ", nome='" + nome + '\'' +
                ", sistema='" + sistema + '\'' +
                '}';
    }

    public int getIDcamp() {
        return IDcamp;
    }

    public void setIDcamp(int IDcamp) {
        this.IDcamp = IDcamp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }
}
