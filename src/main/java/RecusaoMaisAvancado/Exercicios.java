package RecusaoMaisAvancado;

import java.util.Locale;

public class Exercicios {
    public boolean temInteiroNoArray(int[]a,int i)throws IllegalArgumentException{
        if(a == null)throw new IllegalArgumentException();
        return temInteiroNoArray(a,i,0);
    }
    private boolean temInteiroNoArray(int[]a,int i,int p){
        if(a[p] == i){
            return true;
        }
        if (p >= a.length) {
            return false;
        }
        return temInteiroNoArray(a,i,p+1);
    }

    public boolean numeroPrimo(int n)throws IllegalArgumentException{
        if(n <=1)throw new IllegalArgumentException();
        return numeroPrimo(n,2);
    }

    private static boolean numeroPrimo(int n, int divisor) {
        if (divisor * divisor > n) {
            return true;
        }
        if (n % divisor == 0) {
            return false;
        }
        return numeroPrimo(n, divisor + 1);
    }

    public String inverteString(String s)throws IllegalArgumentException{
        if(s == null)throw new IllegalArgumentException();
        return inverteString(s,0);
    }

    private String inverteString(String s,int p){
        if(p >= s.length()){
         return "";
        }
        return inverteString(s,p+1) + s.charAt(p);
    }

    public double positivo(int n)throws IllegalArgumentException{
        if(n <= 0)throw new IllegalArgumentException();
        return positivo2(n,0);
    }

    private double positivo2(int n,double i){
        if (i >= n) {
            return 1/i;
        }
        return 1/i + positivo2(n,i + 1);
    }

    public boolean  palindromo(String s)throws IllegalArgumentException{
        if(s == null)throw new IllegalArgumentException();
        s.replaceAll("[\\\\,.?!@(){}\\[\\]\\/]","").toUpperCase();
        return palindromo(s,0);
    }

    private boolean palindromo(String s, int i){
        if(i >= s.length()/2){
            return true;
        }
        return s.charAt(i) == s.charAt(s.length()-1-i) ? palindromo(s , i+1) : false;
    }

    public int achaPalindromo(String[] s)throws IllegalArgumentException{
        if(s == null)throw new IllegalArgumentException();
        return achaPalindromo(s,0);
    }

    private int achaPalindromo(String[] s, int i) {
        if (i >= s.length) {
            return 0;
        }
        return (palindromo(s[i]) ? 1 + achaPalindromo(s, i + 1) : achaPalindromo(s, i + 1));
    }

    public int contaInteiros(int d, int i)throws IllegalArgumentException{
        if(d < 0 || i < 0 || d > 9)throw new IllegalArgumentException();
        return contaInteiros2(d,i);
    }

    private int contaInteiros2(int d, int i){
        if(i == 0){
            return 0;
        }
        return i% 10 == d ? 10 + contaInteiros2(d, i/10) : contaInteiros2(d, i/10);
    }
}
