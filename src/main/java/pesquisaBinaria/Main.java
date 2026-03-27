package pesquisaBinaria;

public class Main {
    public static void main(String[] args) {
        int[] ar = {1,2,3,4,5,6,7};
        int va = 7;
        System.out.println(binaria(ar,va));
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
}
