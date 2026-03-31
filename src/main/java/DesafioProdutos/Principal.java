package DesafioProdutos;

public class Principal {
    public static void main(String[] args) {
        // Criando algumas datas
        Data d1 = new Data(10, 12, 2026);
        Data d2 = new Data(05, 01, 2027);

        // Criando Produtos
        Perecivel p1 = new Perecivel( d1);
        Perecivel p2 = new Perecivel(d2);

        NaoPerecivel n1 = new NaoPerecivel( 100);
        NaoPerecivel n2 = new NaoPerecivel(50);
        NaoPerecivel n3 = new NaoPerecivel(200);

        // Criando o array de Produto (Polimorfismo!)
        Produto[] listaGeral = {p1, n1, p2, n2, n3};

        // Inicializando o Estoque
        Estoque estoque = new Estoque(listaGeral);

        // 1. Testando filtro de perecíveis
        System.out.println("--- Produtos Perecíveis Encontrados ---");
        Perecivel[] apenasPereciveis = estoque.obterProdutosPereciveis();
        for (Perecivel p : apenasPereciveis) {
            System.out.println(p);
        }

        // 2. Criando array de não-perecíveis para testar a ordenação por quantidade
        NaoPerecivel[] listaParaOrdenar = {n1, n2, n3};

        System.out.println("\n--- Não Perecíveis ANTES da Ordenação (Qtd) ---");
        exibirNaoPereciveis(listaParaOrdenar);

        estoque.ordenaNaoPereciveisPorQuantidade(listaParaOrdenar);

        System.out.println("\n--- Não Perecíveis DEPOIS da Ordenação (Decrescente) ---");
        exibirNaoPereciveis(listaParaOrdenar);
    }

    private static void exibirNaoPereciveis(NaoPerecivel[] lista) {
        for (NaoPerecivel n : lista) {
            System.out.println(n.getNome() + " - Qtd: " + n.getQuantidadeEstoque());
        }
    }
}
