package coding.test.datastructure_with.ch8;

import java.util.Arrays;

public class QuickSort {
    public static int partition(int[] list, int left, int right) {
        int pivot = list[left];
        int low = left + 1; // 피벗 바로 다음 인덱스
        int high = right;

        while (low <= high) {
            // low가 피벗보다 큰 값을 찾을 때까지 이동
            while (low <= right && list[low] < pivot) {
                low++;
            }
            // high가 피벗보다 작은 값을 찾을 때까지 이동
            while (high >= left && list[high] > pivot) {
                high--;
            }
            // low와 high가 엇갈리지 않았으면 값 교환
            if (low < high) {
                swap(list, low, high);
            }
        }
        // 피벗을 제자리에 놓기
        swap(list, left, high);
        return high; // 피벗의 최종 위치 반환
    }

    public static int[] quickSort(int[] list, int left, int right) {
        if (left < right) {
            int q = partition(list, left, right); // 분할
            quickSort(list, left, q - 1); // 왼쪽 부분 재귀 정렬
            quickSort(list, q + 1, right); // 오른쪽 부분 재귀 정렬
        }
        return list;
    }

    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static void main(String[] args) {
        int[] list = {67, 90, 57, 25, 84, 32, 73, 54};
        quickSort(list, 0, list.length - 1);
        System.out.println(Arrays.toString(list)); // 정렬된 배열 출력
    }
}
