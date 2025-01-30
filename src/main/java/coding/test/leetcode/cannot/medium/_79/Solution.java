package coding.test.leetcode.cannot.medium._79;

class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }

        // 범위 밖이거나, 문자가 일치하지 않거나, 방문한 경우 중단
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        // 현재 셀을 방문했다고 표시 (임시 변경)
        char temp = board[row][col];
        board[row][col] = '#';

        // 4방향 탐색
        boolean found = dfs(board, word, row + 1, col, index + 1) ||
                dfs(board, word, row - 1, col, index + 1) ||
                dfs(board, word, row, col + 1, index + 1) ||
                dfs(board, word, row, col - 1, index + 1);

        // 백트래킹 (원래 문자 복원)
        board[row][col] = temp;

        return found;
    }
}