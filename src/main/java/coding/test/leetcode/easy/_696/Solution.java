package coding.test.leetcode.easy._696;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int countBinarySubstrings(String s) {
        Deque<String> dq = new ArrayDeque<>();
        for (int left = 0; left < s.length(); left++) {
            int right = left + 1;
            char first = s.charAt(left);
            int cnt = 1;
            boolean flag = false;
            while (right < s.length()) {
                if (s.charAt(right) == first) {
                    cnt++;
                    if (flag == true) {
                        break;
                    }
                } else {
                    cnt--;
                    flag = true;
                }
                if (cnt == 0) dq.offer(s.substring(left, right + 1));
                right++;
            }
        }
        return dq.size();
    }

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
    }
}