package coding.test.besuccessfulapplicants.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class ConvertDecimalToBinary {
    static String solution(int decimal) {
        Deque<Integer> stack = new ArrayDeque<>();

        int cur = decimal;
        while (true) {
            int temp = cur / 2;
            if (temp != 0) {
                stack.push(cur % 2);
                cur = temp;
            }
            else {
                stack.push(cur);
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
        // return Integer.toBinaryString(decimal);
    }
}
