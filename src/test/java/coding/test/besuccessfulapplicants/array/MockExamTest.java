package coding.test.besuccessfulapplicants.array;

import org.junit.jupiter.api.Test;

class MockExamTest {
    @Test
    void test() {
        var sut = new MockExam();
        int[][] args = {
            {1,2,3,4,5},
            {1,3,2,4,2}
        };

        for (int[] arg : args) {
            sut.print(sut.solution(arg));
        }
    }
}