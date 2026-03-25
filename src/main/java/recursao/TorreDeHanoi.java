package recursao;

public class TorreDeHanoi {
    public static void main(String[] args) {
        int discos = 3;
        hanoi(discos,'A','B','C');
    }

    public static void hanoi(int discos, char origem,char auxiliar,char destino){
        if(discos > 0){
            hanoi(discos-1,origem,destino,auxiliar);//Movimenta o disco menor do pina A para o pino de destino
            System.out.printf("O disco %s foi movido para o pino %s\n",origem,destino);//Movimenta o disco menor do pino A para o pino auxiliar
            hanoi(discos-1,auxiliar,origem,destino);//Movimenta o disco menor do auxiliar para o pino origem e dopois que ta pronto move para o pino de destino
        }
    }
}
