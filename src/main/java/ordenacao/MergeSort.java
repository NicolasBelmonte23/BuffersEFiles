package ordenacao;

public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) { // Verifica se o array tem mais de um elemento
            int mid = (left + right) / 2; // Encontra o ponto médio

            // Chama mergeSort recursivamente para a primeira metade
            mergeSort(arr, left, mid);
            // Chama mergeSort recursivamente para a segunda metade
            mergeSort(arr, mid + 1, right);

            // Mescla as duas metades ordenadas
            merge(arr, left, mid, right);
        }
    }

    // Função que mescla duas metades do array ordenadamente
    public static void merge(int[] arr, int left, int mid, int right) {
        // Tamanhos dos sub-arrays temporários
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Arrays temporários
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia os dados para os arrays temporários
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[mid + 1 + j];
        }

        // Índices iniciais dos sub-arrays e do array principal
        int i = 0, j = 0;
        int k = left;

        // Mescla os arrays temporários de volta no array principal
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copia os elementos restantes do L[], se houver algum
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copia os elementos restantes do R[], se houver algum
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7}; // Define o array de exemplo
        mergeSort(array, 0, array.length - 1); // Chama a função mergeSort para ordenar o array
        System.out.println("Array ordenado:");
        for (int i = 0; i < array.length; i++) { // Imprime os elementos ordenados
            System.out.print(array[i] + " ");
        }
    }
}
