package desafioPlaca;

public class Placa {
    private String letras;
    private String numeros;

    public Placa(String letras, String numeros){
        this.letras = letras;
        this.numeros = numeros;
    }

    public String getLetras(){
        return letras;
    }
    public void setLetras(String letras){
        this.letras = letras;
    }

    public String getNumeros() {
        return numeros;
    }

    public void setNumeros(String numeros) {
        this.numeros = numeros;
    }

    @Override
    public String toString() {
        return "Placa{" +
                "letras='" + letras + '\'' +
                ", numeros='" + numeros + '\'' +
                '}';
    }
}
