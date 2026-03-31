package ordenacao;

public class InsercaoDireta {

    static void main() {
        int[] a = {18,15,7,9,23,16,14};

    }
    public static void insercao(int[]a){
        for(int i = 1;i < a.length;i++){
            int j = i;//posicao do primeiro elemento no seg. nao ordenado.
            int x = a[i];//primeiro elemento no seg.nao ordenado.

            while((j > 0)&& (a[j-1]>x)){//buscando a posicao do primeiro elemento do segmento
                a[j]=a[j-1];            //nao ordenado no segmento ordenado.
                j--;
            }
            a[j] = x;
        }
    }
}
