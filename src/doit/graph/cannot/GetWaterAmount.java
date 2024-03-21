package doit.graph.cannot;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GetWaterAmount { /* P274 문제 49, 백준 2251번. 물의 양 구하기 */
    private static int[] sender = {0, 0, 1, 1, 2, 2};
    private static int[] receiver = {1, 2, 0, 2, 0, 1};
    private static boolean[][] visited;
    private static boolean[] answer;
    private static int[] now;

    /* 풀 엄두가 안나서 풀이 확인 */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        now = new int[3];
        now[0] = sc.nextInt();
        now[1] = sc.nextInt();
        now[2] = sc.nextInt();
        visited = new boolean[201][201];
        answer = new boolean[201];
        bfs();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 201; i++) {
            if (answer[i]) bw.write(i + " ");
        }
        bw.close();
    }

    private static void bfs() {
        Queue<AB> q = new LinkedList<>();
        q.add(new AB(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;
        while (!q.isEmpty()) {
            AB p = q.poll();
            int a = p.a;
            int b = p.b;
            int c = now[2] - a - b;
            for (int i = 0; i < 6; i++) {
                int[] next = {a, b, c};
                next[receiver[i]] += next[sender[i]];
                next[sender[i]] = 0;
                if (next[receiver[i]] > now[receiver[i]]) {
                    next[sender[i]] = next[receiver[i]] - now[receiver[i]];
                    next[receiver[i]] = now[receiver[i]];
                }
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    q.add(new AB(next[0], next[1]));
                    if (next[0] == 0) answer[next[2]] = true;
                }
            }
        }
    }

    private static class AB {
        int a;
        int b;

        public AB(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
