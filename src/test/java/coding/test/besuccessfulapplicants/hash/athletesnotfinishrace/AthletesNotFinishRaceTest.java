package coding.test.besuccessfulapplicants.hash.athletesnotfinishrace;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AthletesNotFinishRaceTest {
    @Test
    void test() {
        String[][] participant = {
                {"leo", "kiki", "eden"},
                {"marina", "josipa", "nikola", "vinko", "filipa"},
                {"mislav", "stanko", "mislav", "ana"}
        };
        String[][] completion = {
                {"eden", "kiki"},
                {"josipa", "filipa", "marina", "nikola"},
                {"stanko", "ana", "mislav"}
        };
        String[] expected = {
                "leo",
                "vinko",
                "mislav"
        };

        var sut = new AthletesNotFinishRace();
        for (int i = 0; i < expected.length; i++) {
            assertThat(sut.solution(participant[i], completion[i])).isEqualTo(expected[i]);
        }
    }
}