package coding.test.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidParenthesesTest {
    @Test
    void test() {
        var input = "([])";
        var expected = true;

        var sut = new ValidParentheses();
        assertThat(sut.isValid(input)).isEqualTo(expected);
    }
}