package coding.test.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindTheIndexOfTheFirstOccurrenceInAStringTest {
    @Test
    void test() {
        String[] haystack = {"mississippi"};
        String[] needle = {"issipi"};
        int[] output = {-1};

        var sut = new FindTheIndexOfTheFirstOccurrenceInAString();
        for (int i = 0; i <= haystack.length - 1; i++) {
            assertThat(sut.strStr(haystack[i], needle[i])).isEqualTo(output[i]);
        }
    }
}