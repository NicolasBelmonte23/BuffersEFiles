package ListsJ;

public class Eletrodomestico {
    private String marca;
    private double preco;
    private int voltagem;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(int voltagem) {
        this.voltagem = voltagem;
    }

    public int contaEletrodomestico(List<Eletrodomestico> eletro, double valorLimite) throws IllegalArgumentException {
        if (valorLimite <= 0 || eletro.isEmpty()) throw new IllegalArgumentException();
        return contaEletrodomestico(eletro, valorLimite, 0);
    }

    private int contaEletrodomestico(List<Eletrodomestico> eletro, double valorLimite, int i){
        if(i == eletro.numElements()){
           return 0;
        }
        int contador = 0;
        if(eletro.get(i).getPreco() > valorLimite){
            contador = 1;
        }
        return contador + contaEletrodomestico(eletro,valorLimite,i+1);
    }
}
