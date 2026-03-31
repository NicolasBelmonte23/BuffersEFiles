package pesquisaBinaria;

public class PesquisaBidimencional {

    public static void main(String[] args) {
        int[][] matrizExemplo = {
                {1, 5, 9},
                {10, 15, 20},
                {25, 30, 35}
        };

        int alvo = 15;
        int[] resultado = pesquisaBinaria2D(matrizExemplo, alvo);

        System.out.printf("Alvo %d encontrado na Linha: %d, Coluna: %d%n",
                alvo, resultado[0], resultado[1]);
    }

    public static int[] pesquisaBinaria2D(int[][] matriz, int alvo) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            return new int[]{-1, -1};
        }
        int linhas = matriz.length;
        int colunas = matriz[0].length;

        int inicio = 0;
        int fim = (linhas * colunas) - 1;

        while (inicio <= fim) {
            // Cálculo do meio seguro para evitar overflow (Pingo Style!)
            int meioVirtual = inicio + (fim - inicio) / 2;

            // Conversão do índice virtual para coordenadas reais da matriz
            int r = meioVirtual / colunas;
            int c = meioVirtual % colunas;

            int valorAtual = matriz[r][c];

            if (valorAtual == alvo) {
                return new int[]{r, c}; // Achamos! Retorna a posição exata
            }

            if (valorAtual < alvo) {
                inicio = meioVirtual + 1; // Busca na metade da direita
            } else {
                fim = meioVirtual - 1;    // Busca na metade da esquerda
            }
        }

        return new int[]{-1, -1}; // Não encontrado
    }
}
