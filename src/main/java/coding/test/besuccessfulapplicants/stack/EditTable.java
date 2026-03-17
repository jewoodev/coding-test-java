package coding.test.besuccessfulapplicants.stack;

import java.util.ArrayDeque;

class EditTable { // https://school.programmers.co.kr/learn/courses/30/lessons/81303
    public String solution(int n, int k, String[] cmd) {
        // 양방향 연결 리스트: prev[i], next[i]
        int[] prev = new int[n];
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        // 경계값: prev[0] = -1, next[n-1] = n (존재하지 않는 노드)

        ArrayDeque<Integer> deleted = new ArrayDeque<>();
        int cur = k;

        for (String c : cmd) {
            char op = c.charAt(0);
            if (op == 'U') {
                int x = Integer.parseInt(c.substring(2));
                for (int i = 0; i < x; i++) {
                    cur = prev[cur];
                }
            } else if (op == 'D') {
                int x = Integer.parseInt(c.substring(2));
                for (int i = 0; i < x; i++) {
                    cur = next[cur];
                }
            } else if (op == 'C') {
                deleted.push(cur);

                // 연결 리스트에서 cur 제거
                if (prev[cur] != -1) next[prev[cur]] = next[cur];
                if (next[cur] != n) prev[next[cur]] = prev[cur];

                // 다음 선택 행 결정
                if (next[cur] == n) {
                    cur = prev[cur]; // 마지막 행이었으면 위로
                } else {
                    cur = next[cur]; // 아니면 아래로
                }
            } else { // Z
                int restore = deleted.pop();

                // 연결 리스트에 restore 복구
                if (prev[restore] != -1) next[prev[restore]] = restore;
                if (next[restore] != n) prev[next[restore]] = restore;
            }
        }

        // 결과 생성: 기본 O, 삭제된 것만 X
        char[] result = new char[n];
        for (int i = 0; i < n; i++) result[i] = 'O';
        for (int d : deleted) result[d] = 'X';

        return new String(result);
    }
}
