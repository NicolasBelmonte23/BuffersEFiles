package recursao;

public class TorreDeHanoi {
    public static void main(String[] args) {
        int discos = 3;
//        hanoi(discos,'A','B','C');
//        System.out.println(fibo2(6));
        System.out.println(ackermann(3,4));
    }

    public static void hanoi(int discos, char origem,char auxiliar,char destino){
        if(discos > 0){
            hanoi(discos-1,origem,destino,auxiliar);//Movimenta o disco menor do pina A para o pino de destino
            System.out.printf("O disco %s foi movido para o pino %s\n",origem,destino);//Movimenta o disco menor do pino A para o pino auxiliar
            hanoi(discos-1,auxiliar,origem,destino);//Movimenta o disco menor do auxiliar para o pino origem e dopois que ta pronto move para o pino de destino
        }
    }

    public static int fibo2(int n){
        if(n == 0)return 0;
        if(n == 1)return 1;
        if(n == 2)return 2;
           return fibo2(n-1) + fibo2(n-2) + fibo2(n-3);
    }

    public static int ackermann(int m, int n){
        if(m == 0){
            return n+1;
        }
        if(m> 0 && n ==0){
            return ackermann(m-1,1);
        }
        return ackermann(m-1,ackermann(m,n-1));
    }
}
