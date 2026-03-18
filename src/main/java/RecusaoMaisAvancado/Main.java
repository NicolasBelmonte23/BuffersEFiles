package RecusaoMaisAvancado;

public class Main {
    public static void main(String[] args) {
        int busca1 = 30;
        int[] meuArray = {10, 25, 30, 45, 50};
        Exercicios app = new Exercicios();

        System.out.println("Procurando " + busca1 + ": " + app.temInteiroNoArray(meuArray, busca1));
        System.out.println(app.numeroPrimo(4));
        System.out.println(app.inverteString("nico"));
        System.out.println(app.palindromo("anas"));
        System.out.println(app.palindromo("ana"));
    }
}
