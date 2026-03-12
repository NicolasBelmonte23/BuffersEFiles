package dev.uni;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Estoque {
    private Produtos[] produtos;

    public void preencheEstoque(String arquivo) {
        List<Produtos> listaProdutos = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha = br.readLine();

            // Pular o cabeçalho
            if (linha != null && linha.startsWith("Produto")) {
                linha = br.readLine();
            }

            while (linha != null) {
                if (!linha.trim().isEmpty()) {
                    String[] dados = linha.split("\\*");
                    if (dados.length >= 5) {
                        String nome = dados[0].trim();
                        String descricao = dados[1].trim();
                        double preco = Double.parseDouble(dados[2].trim());
                        String tipo = dados[3].trim();
                        String extra = dados[4].trim();

                        Produtos produto = null;

                        if (tipo.equalsIgnoreCase("Alimento")) {
                            try {
                                Date data = sdf.parse(extra);
                                produto = new Alimentos(nome, descricao, preco, data);
                            } catch (ParseException e) {
                                System.out.println("Erro ao analisar data para: " + nome);
                            }
                        } else if (tipo.equalsIgnoreCase("Vestuário") || tipo.equalsIgnoreCase("Vestuario")) {
                            Vestuario vestuario = new Vestuario(nome, descricao, preco);
                            vestuario.setQntEstoque(Integer.parseInt(extra));
                            produto = vestuario;
                        } else if (tipo.equalsIgnoreCase("Eletrodomestico")) {
                            Eletrodomestico eletro = new Eletrodomestico(nome, descricao, preco);
                            eletro.setImposto(Double.parseDouble(extra));
                            produto = eletro;
                        }

                        if (produto != null) {
                            listaProdutos.add(produto);
                        }
                    }
                }
                linha = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro de formato numérico: " + e.getMessage());
        }

        produtos = listaProdutos.toArray(new Produtos[0]);
    }

    public Produtos[] getProdutos() {
        return produtos;
    }
}
