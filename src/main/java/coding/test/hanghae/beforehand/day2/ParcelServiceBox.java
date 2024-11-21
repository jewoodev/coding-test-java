package coding.test.hanghae.beforehand.day2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//택배상자
public class ParcelServiceBox {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 1, 2, 5}));
    }
    public static int solution(int[] order) {
        int answer = 0;
        Stack<Integer> belt = new Stack<>();
        Queue<Integer> seq = new LinkedList<>();

        for(int i = 0; i < order.length; i++) {
            seq.offer(order[i]);
        }
        int i = 0;
        while (!(seq.isEmpty())){
            if(i < order.length) {
                i++;
                belt.push(i);
                while (seq.peek().intValue() == belt.peek().intValue()) {
                    seq.poll();
                    belt.pop();
                    answer++;
                    if (belt.isEmpty()) {
                        break;
                    }
                }
            }
            else {
                break;
            }
        }
        return answer;
    }
}
