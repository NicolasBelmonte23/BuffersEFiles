package ListsJ;

public class Exercicios {
    public int contaNegativos(StaticList<Integer>negativos)throws IllegalArgumentException{
        if(negativos == null)throw new IllegalArgumentException();
        return contaNegativos(negativos,0);
    }
    private int contaNegativos(StaticList<Integer>negativos, int indice){
        if(indice == negativos.numElements()) {
            return 0;
        }
        int incremento = (negativos.get(indice) < 0) ? 1 : 0;
        return incremento + contaNegativos(negativos,indice+1);
    }
    public boolean numeroPrimo(int n)throws IllegalArgumentException{
        if(n <=1)throw new IllegalArgumentException();
        return numeroPrimo(n,2);
    }

    private boolean numeroPrimo(int n, int divisor) {
        if (divisor * divisor > n) {
            return true;
        }
        if (n % divisor == 0) {
            return false;
        }
        return numeroPrimo(n, divisor + 1);
    }
    public void removePrimos(StaticList<Integer>num) {
        for (int i = num.numElements() - 1; i >= 0; i--) {
            int elemento = num.get(i);

            if (numeroPrimo(elemento)) {
                num.remove(i); // Remove o elemento na posição i
            }
        }
    }
}
