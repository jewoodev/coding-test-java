package coding.test.datastructure.with_picture_easily.sort;

public class BubbleSort {
    public static void sort(int[] arr) { // O(n^2)
        int lastIdx = arr.length - 1;
        for (int i = 0; i < lastIdx; i++) {
            for (int j = 0; j < lastIdx - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
/** 버블 정렬의 장단점
 * - 장점
 *  - 이해와 구현이 간단함
 * - 단점
 *  - 성능이 좋지 않음
 */