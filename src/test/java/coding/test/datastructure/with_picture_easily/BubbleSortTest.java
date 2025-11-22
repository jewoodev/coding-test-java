package coding.test.datastructure.with_picture_easily;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class BubbleSortTest {
    @Test
    void test() {
        int[] arr = new int[] {4, 2, 3, 1};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append("\n");
        log.info("정렬 전: " + sb);

        BubbleSort.sort(arr);
        sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append("\n");
        log.info("정렬 후: " + sb);
        assertThat(arr).isSorted();
    }
}