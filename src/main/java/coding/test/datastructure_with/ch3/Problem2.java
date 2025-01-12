package coding.test.datastructure_with.ch3;

import java.util.HashSet;
import java.util.Set;

public class Problem2 {
    public static Set<String> addOperators(String num, int target) {
        Set<String> result = new HashSet<>();
        dfs(result, num, target, "", 0, 0, 0);
        return result;
    }

    private static void dfs(Set<String> result, String num, int target, String expr, int pos, long currentValue, long prevOperand) {
        // Base case: 끝까지 탐색한 경우
        if (pos == num.length()) {
            if (currentValue == target) {
                result.add(expr);
            }
            return;
        }

        for (int i = pos; i < num.length(); i++) {
            // 숫자 분리
            String currentStr = num.substring(pos, i + 1);
            long currentNum = Long.parseLong(currentStr);

            // 숫자가 0으로 시작하는 경우 제외
            if (currentStr.length() > 1 && currentStr.charAt(0) == '0') break;

            if (pos == 0) {
                // 첫 번째 숫자: 연산자를 추가하지 않음
                dfs(result, num, target, currentStr, i + 1, currentNum, currentNum);
            } else {
                // '+' 연산자
                dfs(result, num, target, expr + "+" + currentStr, i + 1, currentValue + currentNum, currentNum);

                // '-' 연산자
                dfs(result, num, target, expr + "-" + currentStr, i + 1, currentValue - currentNum, -currentNum);

                // '*' 연산자
                dfs(result, num, target, expr + "*" + currentStr, i + 1,
                        currentValue - prevOperand + prevOperand * currentNum,
                        prevOperand * currentNum);
            }
        }
    }

    public static void main(String[] args) {
        String num = "123";
        int target = 6;
        Set<String> result = addOperators(num, target);
        System.out.println("Output: " + result);

        num = "125";
        target = 7;
        result = addOperators(num, target);
        System.out.println("Output: " + result);
    }
}
