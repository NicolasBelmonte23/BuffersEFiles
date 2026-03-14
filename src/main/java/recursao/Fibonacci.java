package recursao;

public class Fibonacci {
    public static void main(String[] args) {
//        System.out.println("O fibonacci é: " + fibonacci(-1));
//        System.out.println("O fatorial é: " + fatorial(220l));
//        int ar[] = new int[5];
//        ar[0]= 1;
//        ar[1]= 2;
//        ar[2]= 3;
//        ar[3]= 4;
//        ar[4]= 5;
//        arr(ar,4);
        double[][] matriz = {
                {0.5, 2.5, 1.0, 4.0},
                {0.5, 2.5, 1.0, 4.0},
                {0.5, 2.5, 1.0, 4.0}
        };

        // Iniciamos a recursão na linha 0 e coluna 0
        double total = elementos(matriz, 1, 1);
        System.out.println("A soma total é: " + total);
    }

//  Metodo para calcular o fibonacci do numero passado no parametro.
    public static int fibonacci(int numero) {
        if (numero <= 1) {
            return numero;
        } else {
            return fibonacci(numero - 2) + fibonacci(numero - 1);
        }
    }

    public int inteiro(int m, int n) {
        if (m == 0) {
            return n + 1;
        }
        if (m != 0 && n == 0) {
            return inteiro(m - 1, 1);
        } else {
            return inteiro(m - 1, inteiro(m, n - 1));
        }
    }

    public static double elementos(double elementos[][]) throws IllegalArgumentException{
        if (elementos == null) throw new IllegalArgumentException();
        return elementos(elementos, 0, 0);
    }
    private static double elementos(double elementos[][], int linha, int coluna) {
        if (linha >= elementos.length) {
            return 0;
        }
        if (coluna >= elementos[linha].length) {
            return elementos(elementos, linha + 1, 0);
        }
        return elementos[linha][coluna] + elementos(elementos, linha, coluna + 1);
    }
}


