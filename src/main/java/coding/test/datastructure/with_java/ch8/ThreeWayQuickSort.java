package coding.test.datastructure.with_java.ch8;

public class ThreeWayQuickSort {
    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static int[] partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        int lt = low;
        int gt = high;
        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, i, lt);
                lt++;
                i++;
            } else if (arr[i] > pivot) {
                swap(arr, i, gt);
                gt--;
            } else {
                i++;
            }
        }
        int[] ret = {lt, gt};
        return ret;
    }

    public static void threeWayQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int left, right;
            int[] ret = partition(arr, low, high);
            left = ret[0];
            right = ret[1];
            threeWayQuickSort(arr, low, left - 1);
            threeWayQuickSort(arr, right + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,6,2,8,6,4,2,8,3,2,5};
        int n = arr.length;
        System.out.println("Original Array: ");
        for (int num : arr) {
            System.out.printf("%d ", num);
        }
        System.out.println("");
        threeWayQuickSort(arr, 0, n - 1);
        System.out.println("Sorted Array: ");
        for (int num : arr) {
            System.out.printf("%d ", num);
        }
        System.out.println("");
    }
}