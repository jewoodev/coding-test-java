package coding.test.besuccessfulapplicants.stack;

import java.util.ArrayDeque;
import java.util.HashMap;

class EditTable { // https://school.programmers.co.kr/learn/courses/30/lessons/81303
    private static int K;
    private static HashMap<Integer, Boolean> board = new HashMap<>();
    private static ArrayDeque<Integer> dq = new ArrayDeque<>();
    private static int N;

    public String solution(int n, int k, String[] cmd) {
        N = n;
        K = k;
        for (int i = 0; i < n; i++) {
            board.put(i, true);
        }

        for (String c : cmd) {
            work(c);
        }

        var sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (board.get(i) == null) sb.append("X");
            else sb.append("O");
        }

        return sb.toString();
    }

    private void work(String cmd) {
        switch (cmd.charAt(0)) {
            case 'U' -> K = K - Character.getNumericValue(cmd.charAt(2));
            case 'D' -> K = K + Character.getNumericValue(cmd.charAt(2));
            case 'C' -> {
                board.remove(K);
                dq.offerLast(K);

                if (K == N) K--;
                else K++;
            }
            case 'Z' -> {
                int revive = dq.pollLast();
                board.put(revive, true);
            }
        }
    }
}
