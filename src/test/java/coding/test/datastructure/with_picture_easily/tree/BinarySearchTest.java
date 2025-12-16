package coding.test.datastructure.with_picture_easily.tree;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class BinarySearchTest {
    @Test
    void test() {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};

        int idx = BinarySearch.search(arr, 7, 0, arr.length - 1);

        log.info("index: " + idx);
    }
}