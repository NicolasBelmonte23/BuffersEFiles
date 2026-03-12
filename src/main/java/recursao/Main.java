package recursao;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------recursao----------"+recursao(5));
        System.out.println("---------iteralção----------"+cal(5));
    }

    public static int recursao(int numero){
        if(numero <= 1){
            return 1;
        }
        else{
            System.out.println("---------recursao----------"+numero);
            return numero * recursao(numero - 1);
        }
    }

    public static int cal(int numero) {
        int resultado = 1;
        for (int i = numero; i > 0; i--) {
            resultado = resultado * i;
            System.out.println("---------iteralção----------"+resultado);
        }
        return resultado;
     }

}


