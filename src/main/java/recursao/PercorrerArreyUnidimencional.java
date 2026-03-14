package recursao;

public class PercorrerArreyUnidimencional {
    public static void main(String[] args) {
        int [] num = {1,2,3,4,5,6,7,8};
        int[] num2 = {23, 35, 16, 8, 13, 11, -10, 20, 9, 12};
//        acharMenorPosicao(num);
//        arr(num);
       PercorrerArreyUnidimencional p = new PercorrerArreyUnidimencional();
        System.out.println("O menor numero esta na posição: " + p.acharMenorPosicao(num2));
    }
//    Metodo para percorrer o array de tras para frente
    public static void arr(int[] numero)throws IllegalArgumentException{
        if(numero == null) throw new IllegalArgumentException();
        arr2(numero, numero.length-1);
    }
    private static void arr2(int[] numero, int indice){
        if(indice >= 0){
            System.out.println(numero[indice]);
            arr2(numero, indice-1);
        }
    }

    public int acharMenorPosicao(int[] arr)throws IllegalArgumentException{
        if(arr == null)throw new IllegalArgumentException();
            return acharMenorPosicao(arr,1,0);
    }
    private int acharMenorPosicao(int[] arr,int indice,int posicao){
        if(indice >= arr.length){
            return posicao;
        }
        if(arr[indice] < arr[posicao]){
        posicao = indice;
        }
        return acharMenorPosicao(arr,indice+1,posicao);
    }
}
