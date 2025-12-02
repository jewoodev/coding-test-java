package coding.test.datastructure.with_picture_easily.sort;

public class MergeSort {
    public static void sort(int[] arr, int leftIdx, int rightIdx) { // O(nlogn)
        if (leftIdx < rightIdx) {
            int middleIdx = (leftIdx + rightIdx) / 2;
            sort(arr, leftIdx, middleIdx);
            sort(arr, middleIdx + 1, rightIdx);
            merge(arr, leftIdx, middleIdx, rightIdx);
        }
    }

    private static void merge(int[] arr, int leftIdx, int middleIdx, int rightIdx) {
        int leftAreaIdx = leftIdx;
        int rightAreaIdx = middleIdx + 1;

        int[] tempArr = new int[rightIdx + 1];
        int tempArrIdx = leftIdx;

        while (leftAreaIdx <= middleIdx && rightAreaIdx <= rightIdx) {
            if (arr[leftAreaIdx] <= arr[rightAreaIdx]) {
                tempArr[tempArrIdx] = arr[leftAreaIdx++];
            } else {
                tempArr[tempArrIdx] = arr[rightAreaIdx++];
            }
            tempArrIdx++;
        }

        if (leftAreaIdx > middleIdx) {
            for (int i = rightAreaIdx; i <= rightIdx; i++) {
                tempArr[tempArrIdx++] = arr[i];
            }
        } else {
            for (int i = leftAreaIdx; i <= middleIdx; i++) {
                tempArr[tempArrIdx++] = arr[i];
            }
        }

        for (int i = leftIdx; i <= rightIdx; i++) {
            arr[i] = tempArr[i];
        }
    }
}

/** 병합 정렬의 장단점
 * - 장점
 *  - 성능이 좋음
 * - 단점
 *  - 이해와 구현이 어려움
 */