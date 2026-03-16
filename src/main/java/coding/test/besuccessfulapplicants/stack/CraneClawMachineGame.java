package coding.test.besuccessfulapplicants.stack;

import java.util.ArrayDeque;

class CraneClawMachineGame { // https://school.programmers.co.kr/learn/courses/30/lessons/64061
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
//        int[] height = new int[board[0].length];
        var dq = new ArrayDeque<Integer>();

        for (int i = 0; i < moves.length; i++) {
//            if (height[i] == board[0].length) continue;
            int[] cur = board[moves[i] - 1];
            int target = 0;
            for (int j = 0; j < cur.length; j++) {
                if (cur[j] != 0) {
                    target = cur[j];
                    cur[j] = 0;
                    break;
                }
            }

            if (!dq.isEmpty() && dq.peekLast() == target) {
                dq.pollLast();
                answer++;
            } else if (target != 0) {
                dq.offerLast(target);
            }
        }

        return answer;
    }
}
