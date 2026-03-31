package pesquisaBinaria;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] ar = {1,7,3,4,5,6,2};
        int[] ar2 = {1,3,5,6,7};
        Arrays.sort(ar);//ordenando em ordem crescente
        int va = 6;
        System.out.println(binaria(ar,va));
        try{
            System.out.println(sequencialOrdenado(ar2,4));
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
    public static int binaria(int[]arr,int valor)throws ArrayIndexOutOfBoundsException {
        /*
        * Somente pode ser feita essa pesquisa se o array estiver ordenado.
        * */
        int inferior = 0;
        int superior = arr.length - 1;
        while (inferior <= superior) {
            int meio = inferior +(superior - inferior) / 2;//Subtraindo o final do começo depois dividindo e soma tudo. Ajuda com arrays gigantescos.
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
    public static int sequencialOrdenado(int[]x,int num){
        /*
        * Este metodo funciona somente se o array estiver ordenado.
        * */
        for(int i = 0;(i < x.length)&&(x[i]<=num);i++){
            if(num == x[i]){
                System.out.printf("O numero %d foi encontrado.",num);
                return num;
            }
        }
        System.out.printf("O numero %d nao foi encontrado.",num);
        return -1;
    }

    public static int sequencialDesordenado(int[]arr,int num){
        /*
        * Este metodo funciona com array ordenado ou não.
        * */
        for(int i =0; i< arr.length;i++){
            if(arr[i]==num){
                return num;
            }
        }return num-1;
    }
}
