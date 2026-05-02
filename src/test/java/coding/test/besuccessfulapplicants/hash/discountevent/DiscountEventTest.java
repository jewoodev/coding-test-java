package coding.test.besuccessfulapplicants.hash.discountevent;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountEventTest {
    @Test
    void test() {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        int expected = 3;

        var sut = new DiscountEvent();
        assertThat(sut.solution(want, number, discount)).isEqualTo(expected);
    }
}