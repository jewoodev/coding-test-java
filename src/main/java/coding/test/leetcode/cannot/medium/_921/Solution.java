package coding.test.leetcode.cannot.medium._921;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;  // 현재 필요한 닫는 괄호의 수
        int close = 0; // 현재 필요한 여는 괄호의 수

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++; // 여는 괄호가 추가되었으니 닫는 괄호가 필요함
            } else if (c == ')') {
                if (open > 0) {
                    open--; // 닫는 괄호가 균형을 맞췄으므로 open 하나 감소
                } else {
                    close++; // 닫는 괄호가 추가 필요
                }
            }
        }

        // 남아 있는 open과 close가 추가로 필요한 괄호의 수
        return open + close;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minAddToMakeValid("())"));
        System.out.println(solution.minAddToMakeValid("((("));
    }
}