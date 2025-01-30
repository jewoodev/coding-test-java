package coding.test.leetcode.cannot.medium._79;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void testAll() {
        assertThat(
                test(new char[][]{{'A','B','C','E'}, {'S','F','C','S'},{'A','D','E','E'}}, "ABCCED")
        ).isTrue();
    }

    private boolean test(char[][] board, String word) {
        Solution solution = new Solution();
        return solution.exist(board, word);
    }
}