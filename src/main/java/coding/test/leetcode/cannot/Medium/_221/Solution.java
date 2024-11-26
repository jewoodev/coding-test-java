package coding.test.leetcode.cannot.Medium._221;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        // 왼, 위, 왼 대각선 위
        int[] dR = {-1, -1, 0};
        int[] dC = {-1,  0, -1};

        int max = 0;

        int[][] dp = new int[R][C];

        for (int i = 0; i < R; i++) {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(dp[i][0], max);
        }

        for (int i = 0; i < C; i++) {
            dp[0][i] = matrix[0][i] - '0';
            max = Math.max(dp[0][i], max);
        }

        int nR, nC, value;

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][j] == '1') {
                    value = R + C;
                    for (int k = 0; k < 3; k++) {
                        nR = i + dR[k];
                        nC = j + dC[k];
                        value = Math.min(value, dp[nR][nC]);
                    }
                    dp[i][j] = value + 1; // 탐색한 것 중 가장 작은 것에 1을 더한다.
                }

                else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}
