package coding.test.datastructure.with_picture_easily.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class SelectionSortTest {
    @Test
    void test() {
        int[] arr = new int[] {10, 33, 4, 2, 3, 1, 6};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append("\n");
        log.info("정렬 전: " + sb);

        SelectionSort.sort(arr);

        sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append("\n");
        log.info("정렬 후: " + sb);

        assertThat(arr).isSorted();
    }
}