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

    public int exercicio4(StaticList<Integer>list1,StaticList<Integer>list2)throws IllegalArgumentException{
        if(list1 == null || list2 == null || list1.isEmpty() || list2.isEmpty())throw new IllegalArgumentException();
        return exercicio4(list1,0) + exercicio4(list2,0);
    }
    private int exercicio4(StaticList<Integer>list1, int index1){
        if(index1 == list1.numElements()){
            return 0;
        }
        return list1.get(index1) + exercicio4(list1,index1+1);

    }


}
