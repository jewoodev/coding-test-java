package coding.test.besuccessfulapplicants.hash.menurenewal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void test() {
        var orders = new String[]{
                "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"
        };
        var course = new int[]{2,3,4};
        var expected = new String[]{"AC", "ACDE", "BCFG", "CDE"};

        var sut = new Solution();
        assertThat(sut.solution(orders, course)).isEqualTo(expected);
    }
}