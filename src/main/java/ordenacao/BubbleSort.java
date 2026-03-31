package ordenacao;

public class BubbleSort {

    public void bublleSort(int[]a) {
        int i = a.length - 1;
        while (i < 0) {
            int ultimaTroca = 0;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                    ultimaTroca = j;
                }
            }i = ultimaTroca;
        }

    }
}
