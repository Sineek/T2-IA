package javaapplication1;

public class Escolha {
    private String nome;
    private int grau;

    public Escolha(int grau) {
        this.grau = grau;
    }

    public Escolha() {
    }
    
    public Escolha(String nome, int grau) {
        this.nome = nome;
        this.grau = grau;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    

    public int getGrau() {
        return grau;
    }

    public void setGrau(int grau) {
        this.grau = grau;
    }
    
}
