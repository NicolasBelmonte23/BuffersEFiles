package recursao;

import java.sql.ClientInfoStatus;

public class BuscaOrdenada {
    public static void main(String[] args) {
        int[] linhas = {1,2,3,4,5,6,7};
        int alvo= 7;

        int ind = ordenada(linhas,alvo );

        if(ind != -1){
            System.out.println("O numero " + alvo+ " foi encontrado no index " + ind);
        }else{
            System.out.printf("O alvo %d não foi encotrado.", alvo);
        }
    }

    public static int ordenada(int[] elementos, int alvo){
        for(int index = 0; index < elementos.length; index++){
            if(elementos[index] == alvo){
                return index;
            }
        }
        return -1;
    }
}
