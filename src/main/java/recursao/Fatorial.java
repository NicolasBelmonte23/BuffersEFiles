package recursao;

public class Fatorial {
    public static void main(String[] args) {
        fatorial(10l);
    }

//    Metodo para calcular o fatorial do numero passado no parametro.
    public static Long fatorial(Long numero) throws IllegalArgumentException {
        if (numero < 0) {
            throw new IllegalArgumentException();
        }
        return fibo2(numero);
    }

    private static Long fibo2(Long n) {
        if (n <= 1) {
            return 1l;
        }
        return n * fibo2(n - 1);
    }
}
