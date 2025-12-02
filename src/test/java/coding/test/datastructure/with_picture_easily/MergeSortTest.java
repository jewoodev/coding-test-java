package coding.test.datastructure.with_picture_easily;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class MergeSortTest {
    @Test
    void test() {
        int[] arr = new int[] {10, 33, 4, 2, 3, 1, 6};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append("\n");
        log.info("정렬 전: " + sb);

        MergeSort.sort(arr, 0, arr.length - 1);

        sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append("\n");
        log.info("정렬 후: " + sb);

        assertThat(arr).isSorted();
    }
}