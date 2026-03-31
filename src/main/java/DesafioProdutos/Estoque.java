package DesafioProdutos;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Estoque {
    private Produto[] produtos;

    public Estoque(Produto[] produtos) {
        this.produtos = produtos;
    }

    public Produto[] getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto[] produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "produtos=" + Arrays.toString(produtos) +
                '}';
    }

    public void ordenaProdutosPorValor(){
            for(int i = 0; i < produtos.length;i++){
                Produto produtoAtual = produtos[i];
                double valorProcurado = produtoAtual.getValor();

                int inferior = 0;
                int superior = i - 1;
                while (inferior <= superior) {
                    int meio = inferior +(superior - inferior) / 2;//Subtraindo o final do começo depois dividindo e soma tudo. Ajuda com arrays gigantescos.
                    if (valorProcurado < produtos[meio].getValor()) {
                        superior = meio-1;
                    } else {
                        inferior = meio + 1;
                    }
                }
                for(int j = i; j >= inferior; j--){
                    produtos[j+1] = produtos[j];
                }
                produtos[inferior] = produtoAtual;
            }
    }

    public Perecivel[] obterProdutosPereciveis() {
        int cont = 0;
        // Primeiro contamos quantos perecíveis existem para criar o array do tamanho certo
        for (Produto p : produtos) {
            if (p instanceof Perecivel) cont++;
        }

        Perecivel[] listaPereciveis = new Perecivel[cont];
        int i = 0;
        for (Produto p : produtos) {
            if (p instanceof Perecivel) {
                listaPereciveis[i++] = (Perecivel) p;
            }
        }
        return listaPereciveis;
    }

    // Ordenação Decrescente de Quantidade usando lógica de Pesquisa Binária
    // Importante: Quantidade está na classe NaoPerecivel
    public void ordenaNaoPereciveisPorQuantidade(NaoPerecivel[] lista) {
        for (int i = 1; i < lista.length; i++) {
            NaoPerecivel atual = lista[i];
            int qtdAtual = atual.getQuantidadeEstoque();

            int inicio = 0;
            int fim = i - 1;

            // Pesquisa Binária para achar a posição de inserção (Ordem Decrescente)
            while (inicio <= fim) {
                int meio = inicio + (fim - inicio) / 2;

                // Para ordem DECRESCENTE: se o atual é MAIOR que o meio, ele vem antes (esquerda)
                if (qtdAtual > lista[meio].getQuantidadeEstoque()) {
                    fim = meio - 1;
                } else {
                    inicio = meio + 1;
                }
            }

            // Deslocamento dos elementos
            for (int j = i - 1; j >= inicio; j--) {
                lista[j + 1] = lista[j];
            }
            lista[inicio] = atual;
        }
    }
}
