package coding.test.programmers.two.friends4block;

import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        while (true) {
            boolean deleted = false;
            char[][] copied = copy(map);

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (Character.isLetter(map[i][j])
                            && map[i][j] == map[i][j + 1]
                            && map[i][j] == map[i + 1][j + 1]
                            && map[i][j] == map[i + 1][j]) {
                        copied[i][j] = '_';
                        copied[i][j + 1] = '_';
                        copied[i + 1][j] = '_';
                        copied[i + 1][j + 1] = '_';
                        deleted = true;
                    }
                }
            }

            if (!deleted) break;
            map = copied;

            for (int j = 0; j < map[0].length; j++) {
                Queue<Integer> q = new LinkedList<>();

                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] == '_') {
                        map[i][j] = '!';
                        q.add(i);
                        answer++;
                    } else if (!q.isEmpty()) {
                        map[q.poll()][j] = map[i][j];
                        q.add(i);
                    }
                }
            }
        }

        return answer;
    }

    private char[][] copy(char[][] board) {
        char[][] copied = new char[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            copied[i] = board[i].clone();
        }

        return copied;
    }
}

