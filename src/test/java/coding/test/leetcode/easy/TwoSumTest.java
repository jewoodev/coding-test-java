package coding.test.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumTest {
    @Test
    void test() {
        int[][] nums = {
                {0,4,3,0}
        };
        int[] target = {0};
        int[][] output = {{0,3}};

        var sut =  new TwoSum();
        for (int i = 0; i < nums.length; i++) {
            assertThat(sut.twoSum(nums[i], target[i])).isEqualTo(output[i]);
        }
    }
}