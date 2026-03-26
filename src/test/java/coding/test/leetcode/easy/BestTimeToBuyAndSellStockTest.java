package coding.test.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BestTimeToBuyAndSellStockTest {
    @Test
    void test() {
        int[] input = {7, 1, 5, 3, 6, 4};
        int output = 5;

        var sut = new BestTimeToBuyAndSellStock();
        assertThat(sut.maxProfit(input)).isEqualTo(output);
    }
}