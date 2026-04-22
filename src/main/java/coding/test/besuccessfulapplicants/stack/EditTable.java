package coding.test.besuccessfulapplicants.stack;

import java.util.ArrayDeque;

class EditTable { // https://school.programmers.co.kr/learn/courses/30/lessons/81303
    public String solution(int n, int k, String[] cmd) {
        int HEAD = n;
        int TAIL = n + 1;
        int[] prev = new int[n+2];
        int[] next = new int[n+2];
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        prev[0] = HEAD;
        next[n-1] = TAIL;

        ArrayDeque<Integer> deleted = new ArrayDeque<>();

        for (String c : cmd) {
            if (c.startsWith("C")) {
                next[prev[k]] = next[k];
                prev[next[k]] = prev[k];
                deleted.push(k);
                if (next[k] == TAIL) k = prev[k];
                else k = next[k];
            } else if (c.startsWith("Z")) {
                int restore = deleted.pop();
                next[prev[restore]] = restore;
                prev[next[restore]] = restore;
            } else {
                String[] s = c.split(" ");
                var x = Integer.parseInt(s[1]);
                for (int i = 0; i < x; i++) {
                    k = s[0].equals("U") ? prev[k] : next[k];
                }
            }
        }

        char[] result = new char[n];
        for (int i = 0; i < n; i++) result[i] = 'O';
        for (int d : deleted) result[d] = 'X';

        return new String(result);
    }
}
