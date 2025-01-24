package coding.test.datastructure_with.ch8;

import java.util.Random;

public class RandomizedQuickSort {
    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static int choosePivot(int[] arr, int low, int high) {
        Random random = new Random();
        int randomIndex = low + random.nextInt(high - low + 1);
        return randomIndex;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivotIndex = choosePivot(arr, low, high);
        int pivot = arr[pivotIndex];

        swap(arr, pivotIndex, high);

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    public static void randomizedQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            randomizedQuickSort(arr, low, pi - 1);
            randomizedQuickSort(arr, pi + 1, high);
        }
    }
}
