package DesafioProdutos;

public abstract class Produto {
    private String nome;
    private String descrição;
    private double valor;

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", descrição='" + descrição + '\'' +
                ", valor=" + valor +
                '}';
    }
}
