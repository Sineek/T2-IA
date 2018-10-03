package javaapplication1;

public class Prisioneiro {
    private String nome;
    private Escolha escolha;

    public Prisioneiro(String nome, Escolha escolha) {
        this.nome = nome;
        this.escolha = escolha;
    }

    public Prisioneiro() {
    }

    public Prisioneiro(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Escolha getEscolha() {
        return escolha;
    }

    public void setEscolha(Escolha escolha) {
        this.escolha = escolha;
    }
    
}
