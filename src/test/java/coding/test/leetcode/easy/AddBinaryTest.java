package coding.test.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AddBinaryTest {
    @Test
    void test() {
        String[][] input = {
                {"11", "1"},
                {"1010", "1011"}
        };
        String[] output = {
                "100", "10101"
        };

        var sut = new AddBinary();
        for (int i = 0; i < input.length; i++) {
            assertThat(sut.addBinary(input[i][0], input[i][1])).isEqualTo(output[i]);
        }
    }
}