package coding.test.leetcode.cannot.Hard._212;

import java.util.*;

class Solution {

    List<String> output = new ArrayList<>();
    int m, n;
    char[][] board;
    int[] dR = {-1, 1, 0, 0};
    int[] dC = {0, 0, -1, 1};
    Set<String> set = new HashSet<>();
    boolean[][] checked;

    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        checked = new boolean[m][n];

        for (String word : words) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        dfs(i, j, word, 0);
                    }
                }
            }
        }
        return set.stream().toList();
    }


    private void dfs(int r, int c, String word, int depth) {
        if (r < 0 || c < 0 || r >= m || c >= n || depth >= word.length() || checked[r][c]) return;

        if (board[r][c] == word.charAt(depth)) {
            ++depth;
            checked[r][c] = true;
            if (depth == word.length()) set.add(word);
        } else return;

        dfs(r - 1, c, word, depth);
        dfs(r + 1, c, word, depth);
        dfs(r, c - 1, word, depth);
        dfs(r, c + 1, word, depth);
        checked[r][c] = false;
    }
}