package coding.test.leetcode.medium._921;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int answer = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        char c0 = charArray[0];
        for (int i = 0; i < charArray.length; i++) {
            if (c0 == charArray[i]) {
                count++;
            } else {
                dq.offer(count);
                count = 1;
                c0 = charArray[i];
            }

            if (i == charArray.length - 1 && count > 0) {
                dq.offer(Math.abs(count));
            }

            if (dq.size() == 2) {
                answer += Math.abs(dq.poll() - dq.poll());
            } else if (i == charArray.length - 1 && !dq.isEmpty()) {
                answer += Math.abs(dq.poll());
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minAddToMakeValid("())"));
        System.out.println(solution.minAddToMakeValid("((("));
    }
}