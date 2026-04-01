package desafioPlaca;

public class OrdenaPlaca {

    public void ordena(Placa[] placas) {
        // Se o erro estiver sublinhado aqui,
        // é porque ele não reconhece o tipo 'Placa'
        algoritmoDeOrdenacao1(placas);
        algoritmoDeOrdenacao2(placas);
    }

    private void algoritmoDeOrdenacao1(Placa[] placas) {
        // ... seu código da seleção ...
        for (int i = 0; i < placas.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < placas.length; j++) {
                if (placas[j].getNumeros().compareTo(placas[min].getNumeros()) < 0) {
                    min = j;
                }
            }
            Placa temp = placas[i];
            placas[i] = placas[min];
            placas[min] = temp;
        }
    }

    private void algoritmoDeOrdenacao2(Placa[] placas) {
        // ... seu código da inserção ...
        for (int i = 1; i < placas.length; i++) {
            Placa pivo = placas[i];
            int j = i - 1;
            while (j >= 0 && placas[j].getLetras().compareTo(pivo.getLetras()) > 0) {
                placas[j + 1] = placas[j];
                j--;
            }
            placas[j + 1] = pivo;
        }
    }
}
