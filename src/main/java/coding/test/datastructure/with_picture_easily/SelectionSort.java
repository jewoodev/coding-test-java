package coding.test.datastructure.with_picture_easily;

public class SelectionSort {
    public static void sort(int[] arr) { // O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            int minValIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minValIdx] > arr[j]) {
                    minValIdx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minValIdx];
            arr[minValIdx] = temp;
        }
    }
}
/** 선택 정렬의 장단점
 * - 장점
 *  - 이해와 구현이 간단함
 * - 단점
 *  - 성능이 좋지 않음
 */
