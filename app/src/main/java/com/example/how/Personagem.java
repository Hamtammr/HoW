package com.example.how;

public class Personagem {
    private int IDPersonagem;
    private String nomePersonagem;
    private String Classe;
    private String Raca;

    public Personagem(int IDPersonagem, String nomePersonagem, String classe, String raca) {
        this.IDPersonagem = IDPersonagem;
        this.nomePersonagem = nomePersonagem;
        this.Classe = classe;
        this.Raca = raca;
    }


    @Override
    public String toString() {
        return "Personagem{" +
                "IDPersonagem=" + IDPersonagem +
                ", nomePersonagem='" + nomePersonagem + '\'' +
                ", Classe='" + Classe + '\'' +
                ", Raca='" + Raca + '\'' +
                '}';
    }

    public int getIDPersonagem() {
        return IDPersonagem;
    }

    public void setIDPersonagem(int IDPersonagem) {
        this.IDPersonagem = IDPersonagem;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    public String getClasse() {
        return Classe;
    }

    public void setClasse(String classe) {
        Classe = classe;
    }

    public String getRaca() {
        return Raca;
    }

    public void setRaca(String raca) {
        Raca = raca;
    }
}
