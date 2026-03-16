package coding.test.besuccessfulapplicants.stack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CraneClawMachineGameTest {
    @Test
    void test() {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int result = 4;

        var sut = new  CraneClawMachineGame();
        assertThat(sut.solution(board, moves)).isEqualTo(result);
    }

}