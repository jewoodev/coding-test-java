package hanghae.day2.fail;

import java.util.Stack;

//택배상자
public class ParcelServiceBox {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 1, 2, 5}));
    }
    public static int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 1;
        while (i <= order.length) {
            for (int n : order) {
                if (i != n) {
                    if (!stack.empty()) {
                        if (stack.peek() == i) {
                            stack.pop();
                            answer++;
                            i++;
                        } else {
                            if (n == order[order.length - 1])
                                return answer;
                            else stack.push(n);
                        }
                    } else stack.push(n);
                } else {
                    answer++;
                    i++;
                }
            }
        }
        return answer;
    }
}
