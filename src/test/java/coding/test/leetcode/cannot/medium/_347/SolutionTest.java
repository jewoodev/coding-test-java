package coding.test.leetcode.cannot.medium._347;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void testAll() {
        assertThat(test(new int[]{1, 1, 1, 2, 2, 3}, 2)).containsExactly(1, 2);
        assertThat(test(new int[]{1}, 1)).containsExactly(1);
    }

    private int[] test(int[] nums, int k) {
        return new Solution().topKFrequent(nums, k);
    }
}