package coding.test.leetcode.cannot.medium._1347;

class Solution {
    public int minSteps(String s, String t) {
        int[] c = new int[26];
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 'a']++;
            c[t.charAt(i) - 'a']--;
        }

        for (int i : c) {
            if (i > 0) result += i;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSteps("bab", "aba"));
    }
}
