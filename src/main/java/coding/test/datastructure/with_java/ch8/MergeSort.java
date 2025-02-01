package coding.test.datastructure.with_java.ch8;

import java.util.Arrays;

public class MergeSort {
    public static void merge(int[] list, int left, int mid, int right) {
        int[] sorted = new int[list.length];

        int i = left; // 왼쪽 배열 포인터
        int j = mid + 1; // 오른쪽 배열 포인터
        int k = left; // 병합 배열 포인터

        while (i <= mid && j <= right) {
            if (list[i] <= list[j])
                sorted[k++] = list[i++];
            else
                sorted[k++] = list[j++];
        }

        if (i > mid)
            for (int m = j; m <= right; m++)
                sorted[k++] = list[m];
        else
            for (int m = i; m <= mid; m++)
                sorted[k++] = list[m];

        for (int m = left; m <= right; m++)
            list[m] = sorted[m];
    }

    public static int[] mergeSort(int[] list, int left, int right) {
        int mid;
        if (left < right) {
            mid = (left + right) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
        return list;
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        StringBuilder sb = new StringBuilder();
        int[] list = {26, 5, 37, 1, 61, 11, 59, 15, 48, 19};
        Arrays.stream(ms.mergeSort(list, 0, list.length - 1)).forEach((i) -> sb.append(i).append(" "));
        System.out.println(sb);
    }
}
