package DesafioProdutos;

public class Perecivel extends Produto{
    private Data dataValidade;

    public Perecivel(Data dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Data getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Data dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return "Perecivel{" +
                "dataValidade=" + dataValidade +
                '}';
    }
}
