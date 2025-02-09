package coding.test.leetcode.cannot.medium._57;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InsertIntervalTest {
    @Test
    void test() {
        InsertInterval it = new InsertInterval();
        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        assertThat(it.insert(intervals1, newInterval1)).isDeepEqualTo(new int[][]{{1,5}, {6,9}});

        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        assertThat(it.insert(intervals2, newInterval2)).isDeepEqualTo(new int[][]{{1, 2}, {3, 10}, {12, 16}});
    }
}