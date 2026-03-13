package recursao;

public class PercorrerArreyUnidimencional {
    public static void main(String[] args) {
        int [] num = {1,2,3,4,5,6,7,8};
        arr(num,6);
    }
//    Metodo para percorrer o array de tras para frente
    public static void arr(int[] numero,int indice){
        if(indice < 0){
            return;
        }
        System.out.println(numero[indice]);
        arr(numero, indice-1);
    }
}
