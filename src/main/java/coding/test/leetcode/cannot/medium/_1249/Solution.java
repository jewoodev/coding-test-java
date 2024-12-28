package coding.test.leetcode.cannot.medium._1249;


import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static String minRemoveToMakeValid(String s) {
        // 스택을 사용해 괄호의 인덱스를 저장
        Deque<Integer> dq = new ArrayDeque<>();
        // StringBuilder를 사용해 문자열을 수정
        StringBuilder sb = new StringBuilder(s);

        // 문자열을 순회하면서 괄호의 짝을 검사
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                dq.push(i); // 열린 괄호의 인덱스를 저장
            } else if (c == ')') {
                if (!dq.isEmpty()) {
                    dq.pop(); // 짝이 맞는 열린 괄호를 제거
                } else {
                    sb.setCharAt(i, '*'); // 유효하지 않은 닫힌 괄호를 임시로 표시
                }
            }
        }

        // 스택에 남아 있는 열린 괄호를 처리
        while (!dq.isEmpty()) {
            sb.setCharAt(dq.pop(), '*'); // 유효하지 않은 열린 괄호를 임시로 표시
        }

        // 임시로 표시된 '*' 문자를 제거
        return sb.toString().replaceAll("\\*", "");
    }

    public static void main(String[] args) {
        // 테스트 케이스
        String s1 = "lee(t(c)o)de)";
        String s2 = "a)b(c)d";
        String s3 = "))((";

        System.out.println(minRemoveToMakeValid(s1)); // "lee(t(c)o)de"
        System.out.println(minRemoveToMakeValid(s2)); // "ab(c)d"
        System.out.println(minRemoveToMakeValid(s3)); // ""
    }
}