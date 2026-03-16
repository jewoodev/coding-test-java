package coding.test.besuccessfulapplicants.stack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RemovePairsTest {
    @Test
    void test() {
        String[] s = { "baabaa", "cdcd" };
        int[] result = { 1, 0 };

        var sut = new RemovePairs();
        for (int i = 0; i < s.length; i++) {
            assertThat(sut.solution(s[i])).isEqualTo(result[i]);
        }
    }
}