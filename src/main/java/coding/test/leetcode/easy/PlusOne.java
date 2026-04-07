package coding.test.leetcode.easy;

class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length - 1;

        if (digits[len] != 9) {
            digits[digits.length - 1]++;
            return digits;
        }

        while (digits[len] == 9) {
            if (digits.length == 1) return new int[]{1, 0};
            digits[len] = 0;
            if (--len == -1) {
                int[] answer = new int[digits.length + 1];
                answer[0] = 1;
                return answer;
            }
        }

        digits[len]++;
        return digits;
    }
}
