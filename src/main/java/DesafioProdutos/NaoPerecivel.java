package DesafioProdutos;

public class NaoPerecivel extends Produto{
    private int quantidadeEstoque;

    public NaoPerecivel(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public String toString() {
        return "NaoPerecivel{" +
                "quantidadeEstoque=" + quantidadeEstoque +
                '}';
    }
}
