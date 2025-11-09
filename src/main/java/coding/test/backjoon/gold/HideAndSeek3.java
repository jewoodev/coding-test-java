package coding.test.backjoon.gold;

import java.util.*;

public class HideAndSeek3 { // https://www.acmicpc.net/problem/13549, BFS
    private static final int MAX = 1_000_000;
    private static boolean[] visited = new boolean[MAX + 1];
    private static int n, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        bfs();
    }

    private static void bfs() {
        Deque<Subin> dq = new ArrayDeque<>();
        visited[n] = true;
        dq.offer(new Subin(n, 0));

        while (!dq.isEmpty()) {
            Subin cur = dq.poll();

            if (cur.x == k) {
                System.out.print(cur.time);
                break;
            }

            teleport(cur, dq);
            goBack(cur, dq);
            goForward(cur, dq);
        }
    }

    private static void goBack(Subin subin, Deque<Subin> dq) {
        int next = subin.x - 1;
        if (next >= 0 && !visited[next]) {
            visited[next] = true;
            dq.offer(new Subin(next, subin.time + 1));
        }
    }

    private static void goForward(Subin subin, Deque<Subin> dq) {
        int next = subin.x + 1;
        if (next <= MAX && !visited[next]) {
            visited[next] = true;
            dq.offer(new Subin(next, subin.time + 1));
        }
    }

    private static void teleport(Subin subin, Deque<Subin> dq) {
        int next = subin.x * 2;
        if (next <= MAX && !visited[next]) {
            visited[next] = true;
            dq.offer(new Subin(next, subin.time));
        }
    }

    private static class Subin {
        int x;
        int time;
        private Subin(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
