package coding.test.datastructure_with.ch8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

class RandomizedQuickSortTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(
                        new int[]{12, 5, 9, 3, 14, 10, 6, 2}
                )
        );
    }

    private void test(int[] arr) {
        RandomizedQuickSort rq = new RandomizedQuickSort();
        StringBuilder sb = new StringBuilder();
        int n = arr.length;

        sb.append("Original Array: \n");
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append("\n");

        rq.randomizedQuickSort(arr, 0, n - 1);

        sb.append("Sorted Array: \n");
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}