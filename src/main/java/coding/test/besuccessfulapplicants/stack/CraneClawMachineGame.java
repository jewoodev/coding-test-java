package coding.test.besuccessfulapplicants.stack;

import java.util.ArrayDeque;

class CraneClawMachineGame { // https://school.programmers.co.kr/learn/courses/30/lessons/64061
    public int solution(int[][] board, int[] moves) {
        ArrayDeque<Integer>[] lanes = new ArrayDeque[board.length];
        for (int i = 0; i < lanes.length; i++) {
            lanes[i] = new ArrayDeque<>();
        }

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) {
                    lanes[j].offerLast(board[i][j]);
                }
            }
        }

        var bucket = new ArrayDeque<Integer>();
        int answer = 0;

        for (int move : moves) {
            if (!lanes[move - 1].isEmpty()) {
                int doll = lanes[move - 1].pollLast();
                if (!bucket.isEmpty() && bucket.peekLast() == doll) {
                    bucket.pollLast();
                    answer += 2;
                }
                else  {
                    bucket.offerLast(doll);
                }
            }
        }

        return answer;
    }
}
