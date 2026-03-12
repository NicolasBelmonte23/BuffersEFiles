package dev.uni;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // --- 1. Pedindo o arquivo pro chefe (você) ---
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o nome do arquivo de produtos (ex: produtos.txt): ");
        String nomeArquivo = teclado.nextLine();
        teclado.close();

        // --- 2. Montando o estoque ---
        Estoque estoque = new Estoque();
        estoque.preencheEstoque(nomeArquivo);
        System.out.println("Estoque preenchido! Partindo para a análise...");

        // --- 3. A Caça aos Dados ---
        Alimentos alimentoMaisCaro = null;
        Eletrodomestico eletroMaisBarato = null;
        StringBuilder vestuarioInfo = new StringBuilder();

        // Inicializando com valores extremos pra facilitar a comparação
        double maiorPrecoAlimento = 0.0;
        double menorPrecoEletro = Double.MAX_VALUE;

        for (Produtos p : estoque.getProdutos()) {
            // Usamos 'instanceof' pra saber a "tribo" de cada produto
            if (p instanceof Alimentos) {
                if (p.getPreco() > maiorPrecoAlimento) {
                    maiorPrecoAlimento = p.getPreco();
                    alimentoMaisCaro = (Alimentos) p;
                }
            } else if (p instanceof Eletrodomestico) {
                if (p.getPreco() < menorPrecoEletro) {
                    menorPrecoEletro = p.getPreco();
                    eletroMaisBarato = (Eletrodomestico) p;
                }
            } else if (p instanceof Vestuario) {
                Vestuario v = (Vestuario) p;
                vestuarioInfo.append(v.getNome())
                             .append(" - Quantidade: ")
                             .append(v.getQntEstoque())
                             .append("\n");
            }
        }

        // --- 4. Gerando o Relatório (O Dossiê) ---
        try (PrintWriter out = new PrintWriter(new FileWriter("info.txt"))) {
            out.println("--- RELATÓRIO DE ESTOQUE ---");
            out.println();

            out.println("a) Alimento mais caro:");
            if (alimentoMaisCaro != null) {
                out.println("   - Nome: " + alimentoMaisCaro.getNome() + " | Preço: R$" + alimentoMaisCaro.getPreco());
            } else {
                out.println("   - Nenhum alimento encontrado.");
            }
            out.println();

            out.println("b) Eletrodoméstico mais barato:");
            if (eletroMaisBarato != null) {
                out.println("   - Nome: " + eletroMaisBarato.getNome() + " | Preço: R$" + eletroMaisBarato.getPreco());
            } else {
                out.println("   - Nenhum eletrodoméstico encontrado.");
            }
            out.println();

            out.println("c) Vestuário em estoque:");
            if (vestuarioInfo.length() > 0) {
                out.print(vestuarioInfo.toString());
            } else {
                out.println("   - Nenhum item de vestuário encontrado.");
            }

            System.out.println("\nArquivo 'info.txt' gerado com sucesso! Pode conferir na pasta do projeto.");

        } catch (IOException e) {
            System.err.println("Eita, Giovana! Deu erro ao escrever o arquivo: " + e.getMessage());
        }
    }
}
