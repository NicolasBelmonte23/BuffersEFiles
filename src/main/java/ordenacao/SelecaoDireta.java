package ordenacao;

import java.util.Arrays;

public class SelecaoDireta {
    public static void main(String[]args) {
        // 1. Criamos um array de teste desordenado
        int[] meuArray = {64, 25, 12, 22, 11, 1, 90};
        int alvo = 1;

        int pos = psqSequencialNOrdenada(meuArray,alvo);
        imprimeResultado(alvo,pos);
        // 2. Imprimimos o array ANTES para conferir
//        System.out.println("Antes da ordenação: " + Arrays.toString(meuArray));
//
//        // 3. Chamamos o seu método de ordenação
//        selecaoDireta(meuArray,22);
//
//        // 4. Imprimimos o array DEPOIS para validar o sucesso
//        System.out.println("Depois da ordenação: " + Arrays.toString(meuArray));
    }

    public static void selecaoDireta(int[]a){
        int min = 0;
        for(int i = 0; i < a.length-1; i++){
            min = i;
            for(int j = i+1; j < a.length; j++)
                if(a[j] < a[min])
                    min = j;
            int t = a[i];
            a[i] = a[min];
            a[min] = t;
        }
    }

    public static int psqSequencialNOrdenada(int[]a,int alvo){
        if(a == null)return -1;
        return psqSequencialNOrdenada(a,alvo,0);
    }

    private static int psqSequencialNOrdenada(int[]a,int alvo,int i){
        if(a[i] == alvo){
            return i;
        }
        if(alvo > a.length){
            return -1;
        }
        return psqSequencialNOrdenada(a,alvo,i+1);
    }

    public static void imprimeResultado(int alvo, int i){
        if(alvo != -1){
            System.out.printf("Sucesso. o alvo %d foi encontrado na pocisão %d.",alvo,i);
        }else{
            System.out.println("O alvo não foi encontrado.");
        }
    }

    public static int psqSequencialOrdenado(int[] a,int alvo){
        if(a == null)return -1;
        return psqSequencialOrdenado(a,alvo,0);
    }

    private static int psqSequencialOrdenado(int[]a,int alvo,int i){
        if (i >= a.length) {
            return -1;
        }
        if (a[i] == alvo) {
            return i;
        }
        if (a[i] > alvo) {
            return -1;
        }

        return psqSequencialOrdenado(a, alvo, i + 1);
    }

}
