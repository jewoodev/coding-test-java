package coding.test.besuccessfulapplicants.stack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConvertDecimalToBinaryTest {
    @Test
    void test() {
        int[] decimal = { 10, 27, 12345, 13 };
        String[] expected = { "1010", "11011", "11000000111001", "1101" };

        ConvertDecimalToBinary sut = new ConvertDecimalToBinary();
        for(int i = 0; i < decimal.length; i++){
            assertThat(sut.solution(decimal[i])).isEqualTo(expected[i]);
        }
    }
}