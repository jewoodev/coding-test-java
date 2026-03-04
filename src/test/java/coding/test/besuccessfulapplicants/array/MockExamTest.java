package coding.test.besuccessfulapplicants.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MockExamTest {
    @Test
    void test() {
        int[][] answers = {
                {1, 2, 3, 4, 5},
                {1, 3, 2, 4, 2}
        };
        int[][] expected = {
                {1},
                {1, 2, 3}
        };
        var sut = new MockExam();

        for (int i = 0; i < answers.length; i++) {
            assertThat(sut.solution(answers[i])).isEqualTo(expected[i]);
        }
    }
}