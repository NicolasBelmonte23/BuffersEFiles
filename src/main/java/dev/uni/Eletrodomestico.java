package dev.uni;

public class Eletrodomestico extends Produtos{

    private double imposto;

    public Eletrodomestico(String nome, String descricao, double preco) {
        super(nome, descricao, preco);
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }
}
