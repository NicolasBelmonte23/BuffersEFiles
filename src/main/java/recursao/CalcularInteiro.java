package recursao;

public class CalcularInteiro {
    public static void main(String[] args) {
        inteiro(10,5);
    }
//    metodo para fazer a soma dos numeros inteiros.
    public static int inteiro(int m, int n) {
        if (m == 0) {
            return n + 1;
        }
        if (m != 0 && n == 0) {
            return inteiro(m - 1, 1);
        } else {
            return inteiro(m - 1, inteiro(m, n - 1));
        }
    }
}
