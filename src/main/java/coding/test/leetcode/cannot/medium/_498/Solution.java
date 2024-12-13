package coding.test.leetcode.cannot.medium._498;

class Solution {
    int m, n;
    int i, j;
    int[] arr;
    public int[] findDiagonalOrder(int[][] mat) {
        m = mat.length - 1;
        n = mat[0].length - 1;
        arr = new int[(m + 1) * (n + 1)];
        i = j = 0;
        while (i != m || j != n) {
            leftDiagonal(i, j);
            rightDiagonal(i, j);
        }
        return arr;
    }


    private void leftDiagonal(int i, int j) {

    }
    private void rightDiagonal(int i, int j) {
    }
}
