package coding.test.besuccessfulapplicants.stack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StockPriceTest {
    @Test
    void test() {
        int[] prices = {1, 2, 3, 2, 3};
        int[] result = {4, 3, 1, 1, 0};
        
        var sut = new StockPrice();

        assertThat(sut.solution(prices)).isEqualTo(result);
    }
}