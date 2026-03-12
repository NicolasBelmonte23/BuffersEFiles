package dev.uni;

public class Vestuario extends Produtos{

    private int qntEstoque;

    public Vestuario(String nome, String descricao, double preco) {
        super(nome, descricao, preco);
    }

    public int getQntEstoque() {
        return qntEstoque;
    }

    public void setQntEstoque(int qntEstoque) {
        this.qntEstoque = qntEstoque;
    }
}
