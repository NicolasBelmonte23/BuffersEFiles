package RecusaoMaisAvancado;

public class Main {
    public static void main(String[] args) {
//        int busca1 = 30;
//        int[] meuArray = {10, 25, 30, 45, 50};
//        Exercicios app = new Exercicios();
//
//        System.out.println("Procurando " + busca1 + ": " + app.temInteiroNoArray(meuArray, busca1));
//        System.out.println(app.numeroPrimo(4));
//        System.out.println(app.inverteString("nico"));
//        System.out.println(app.palindromo("anas"));
//        System.out.println(app.palindromo("ana"));
        System.out.println(numero(6));
    }

    public static int numero(int x) {
        if (x <= 0) {
            System.out.println(0);
            System.out.println("fim do pograma");
            return 0;
        }
        System.out.println(x);
        return numero(x - 3);
    }
}
