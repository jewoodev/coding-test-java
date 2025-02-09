package coding.test.leetcode.cannot.medium._62;

class Solution{
    public static int uniquePaths(int m, int n) {
        return combination(m + n - 2, Math.min(m - 1, n - 1));
    }

    private static int combination(int total, int select) {
        long result = 1;
        for (int i = 0; i < select; i++) {
            result = result * (total - i) / (i + 1);
        }
        return (int) result;
    }
}
