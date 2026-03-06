package coding.test.besuccessfulapplicants.stack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RotateParenthesesTest {
    @Test
    void test() {
        String[] s = {
                "[](){}", "}]()[{", "[)(]", "}}}"
        };

        int[] result = {3, 2, 0, 0};

        var sut =  new RotateParentheses();
        for (int i = 0; i < s.length; i++) {
            assertThat(sut.solution(s[i])).isEqualTo(result[i]);
        }
    }
}