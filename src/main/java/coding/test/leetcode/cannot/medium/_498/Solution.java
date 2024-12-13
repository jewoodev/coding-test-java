package coding.test.leetcode.cannot.medium._498;

class Solution {
    int row, col;
    int[][] moveVertical = new int[][]{{-1, 1}, {1, -1}};
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] arr = new int[m * n];
        row = col = 0;
        int idx = 0;
        int direction = 0;

        while (idx < m * n) {
            arr[idx++] = mat[row][col];

            row += moveVertical[direction][0];
            col += moveVertical[direction][1];

            if (row < 0 || row >= m || col < 0 || col >= n) {
                if (direction == 0) {
                    if (col >= n) {
                        row += 2;
                        col -= 1;
                    } else if (row < 0) {
                        row = 0;
                    }
                    direction = 1;
                } else {
                    if (row >= m) {
                        col += 2;
                        row -= 1;
                    } else if (col < 0) {
                        col = 0;
                    }
                    direction = 0;
                }
            }
        }
        return arr;
    }
}
