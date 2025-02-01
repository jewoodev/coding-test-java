package coding.test.datastructure.with_java.ch8;

public class BubbleSort {
    public static void bubbleSort(int[] list, int n) {
        int temp;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list[j] > list[j + 1]) {
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }
}
