package coding.test.besuccessfulapplicants.hash.openchattingroom;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void test() {
        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };
        String[] expected = {
                "Prodo님이 들어왔습니다.",
                "Ryan님이 들어왔습니다.",
                "Prodo님이 나갔습니다.",
                "Prodo님이 들어왔습니다."
        };

        var sut = new Solution();
        assertThat(sut.solution(record)).isEqualTo(expected);
    }
}