package recursao;

public class BinarioParaDecimal {
    public static void main(String[] args) {
        String s = "11111111";
        BinarioParaDecimal b = new BinarioParaDecimal();
        System.out.println(b.binary(s));
    }

    public int binary(String s)throws IllegalArgumentException{
        if(s == null || s.length() != 8)throw new IllegalArgumentException();
        return binary(s,0);
    }
    private int binary(String s, int i){
        if(i >= s.length())return 0;
        char digito = s.charAt(s.length()-1-i);
        if(digito == '1')return (int)Math.pow(2,i) + binary(s,i+1);
        return binary(s,i+1);

    }
}
