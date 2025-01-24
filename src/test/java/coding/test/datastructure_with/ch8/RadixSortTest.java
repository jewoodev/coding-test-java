package coding.test.datastructure_with.ch8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadixSortTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(
                        new int[]{170, 45, 75, 90, 892, 24, 2, 66}
                )
        );
    }

    private void test(int[] arr) throws Exception {
        int size = arr.length;
        System.out.printf("Original Array: ");
        for (int i = 0; i < size; i++) {
            System.out.printf("%d ", arr[i]);
        }
        RadixSort.radixSort(arr, size);
        System.out.printf("\nSorted Array: ");
        for (int i = 0; i < size; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }
}