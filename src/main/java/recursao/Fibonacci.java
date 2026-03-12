package recursao;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(6
        ));
    }

    public static int fibonacci(int numero){
        if(numero <= 1){
         return numero;
        }else{
         return fibonacci(numero -2) + fibonacci(numero -1);
        }
    }
}
