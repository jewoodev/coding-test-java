package coding.test.datastructure.with_picture_easily.sort;

public class InsertionSort {
    public static void sort(int[] arr) { // O(N^2)
        for (int i = 1; i < arr.length; i++) {
            int insertingNum = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > insertingNum) {
                    arr[j + 1] = arr[j];
                } else break;
            }
            arr[j + 1] = insertingNum;
        }
    }
}

/** 삽입 정렬의 장단점
 * - 장점
 *  - 이해와 구현이 간단함
 * - 단점
 *  - 성능이 좋지 않음
 */