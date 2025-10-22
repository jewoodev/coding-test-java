package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class HideAndSeek { // https://www.acmicpc.net/problem/1697, BFS
    private static int start, dest, maxLen = 100_000;
    private static boolean[] visited = new boolean[maxLen + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());

        bfs();
    }

    private static void bfs() {
        Deque<Subin> q = new ArrayDeque<>();
        q.offer(new Subin(start, 0));

        while (!q.isEmpty()) {
            Subin now = q.poll();

            if (now.position == dest) { // 동생을 찾는 경우의 처리 로직
                System.out.println(now.time);
                System.exit(0);
            }

            if (!visited[now.position]) { // 방문 처리가 안된 경우만 방문 시작
                visited[now.position] = true; // 방문 처리

                if (now.position - 1 >= 0 && now.position - 1 <= maxLen) { // 방문 후 -1로 이동 가능하면 이동할 곳으로 큐에 저장
                    q.offer(new Subin(now.position - 1, now.time + 1));
                }

                if (now.position + 1 >= 0 && now.position + 1 <= maxLen) {
                    q.offer(new Subin(now.position + 1, now.time + 1));
                }

                if (now.position * 2 >= 0 && now.position * 2 <= maxLen) {
                    q.offer(new Subin(now.position * 2, now.time + 1));
                }
            }
        }
    }

    private static class Subin {
        int position, time;
        private Subin(int position, int time) {
            this.position = position;
            this.time = time;
        }
    }
}
