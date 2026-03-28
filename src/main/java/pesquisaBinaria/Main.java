package pesquisaBinaria;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] ar = {1,7,3,4,5,6,2};
        int[] ar2 = {1,3,5,6,7};
//        Arrays.sort(ar);//ordenando em ordem crescente
//        int va = 7;
//        System.out.println(binaria(ar,va));
        System.out.println(sequencial(ar2,4));
    }
    public static int binaria(int[]arr,int valor) {
        int inferior = 0;
        int superior = arr.length - 1;
        while (inferior <= superior) {
            int meio = (inferior + superior) / 2;
            if (arr[meio] == valor) {
                return meio;
            } else if (valor < arr[meio]) {
                superior = meio - 1;
            } else {
                inferior = meio + 1;
            }
        }
            return -1;
    }
    public static int sequencial(int[]x,int num){
        for(int i = 0;(i < x.length)&&(x[i]<=num);i++){
            if(num == x[i]){
                System.out.printf("O numero %d foi encontrado.",num);
                return num;
            }
        }
        System.out.printf("O numero %d nao foi encontrado.",num);
        return -1;
    }
}
