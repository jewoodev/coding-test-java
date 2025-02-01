package coding.test.datastructure.with_java.ch8;

public class SelectionSort {
    public static void selectionSort(int[] list, int n) {
        int min, temp;

        for (int i = 0; i < n - 1; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (list[j] < list[min])
                    min = j;
            }
            temp = list[i];
            list[i] = list[min];
            list[min] = temp;
        }
    }
}
