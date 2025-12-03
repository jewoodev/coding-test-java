package coding.test.datastructure.with_picture_easily.sort;

public class QuickSort {
    public static void sort(int[] arr, int leftIdx, int rightIdx) { // O(n^2), 세타(NlogN)
        if (leftIdx <= rightIdx) {
            int pivot = divide(arr, leftIdx, rightIdx);
            sort(arr, leftIdx, pivot - 1);
            sort(arr, pivot + 1, rightIdx);
        }
    }

    private static int divide(int[] arr, int leftIdx, int rightIdx) {
        int pivot = arr[leftIdx];
        int leftStartIdx = leftIdx + 1;
        int rightStartIdx = rightIdx;

        while (leftStartIdx <= rightStartIdx) {
            while (leftStartIdx <= rightIdx && pivot >= arr[leftStartIdx]) {
                leftStartIdx++;
            }

            while (rightStartIdx >= (leftIdx + 1) && pivot <= arr[rightStartIdx]) {
                rightStartIdx--;
            }

            if (leftStartIdx <= rightStartIdx) {
                swap(arr, leftStartIdx, rightStartIdx);
            }
        }

        swap(arr, leftIdx, rightStartIdx);
        return rightStartIdx;
    }

    private static void swap(int[] arr, int idxA, int idxB) {
        int temp = arr[idxA];
        arr[idxA] = arr[idxB];
        arr[idxB] = temp;
    }
}
/** 퀵 정렬의 장단점
 * - 장점
 *  - 성능이 좋음
 * - 단점
 *  - 이해와 구현이 어려움
 */