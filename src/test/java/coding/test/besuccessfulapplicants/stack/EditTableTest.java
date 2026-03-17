package coding.test.besuccessfulapplicants.stack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EditTableTest {
    @Test
    void test() {
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
        var result = "OOXOXOOO";

        var sut = new EditTable();
        assertThat(sut.solution(8,2,cmd)).isEqualTo(result);
    }
}