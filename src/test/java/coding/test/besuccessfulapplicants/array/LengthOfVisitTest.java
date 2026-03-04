package coding.test.besuccessfulapplicants.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LengthOfVisitTest {
    @Test
    void test() {
        String[] dirs = {"ULURRDLLU", "LULLLLLLU"};
        int[] answer = {7, 7};

        var sut = new LengthOfVisit();
        for (int i = 0; i < dirs.length; i++) {
            assertThat(sut.solution(dirs[i])).isEqualTo(answer[i]);
        }
    }
}