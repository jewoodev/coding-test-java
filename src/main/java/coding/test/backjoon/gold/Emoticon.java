package coding.test.backjoon.gold;

import java.util.*;

public class Emoticon { // https://www.acmicpc.net/problem/14226, BFS
    private static boolean[][] visited = new boolean[1001][1001];
    private static int s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextInt();

        bfs();
    }

    private static void bfs() {
        Deque<State> q = new ArrayDeque<>();

        visited[1][0] = true;
        q.offer(new State(1, 0, 0)); // 화면 1개, 클립보드 0개, 시간 0

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.screen == s) {
                System.out.println(cur.time);
                break;
            }

            copyToClipboard(cur, q);
            pasteToScreen(cur, q);
            deleteFromScreen(cur, q);
        }
    }

    private static void copyToClipboard(State cur, Deque<State> q) {
        if (!visited[cur.screen][cur.screen]) {
            visited[cur.screen][cur.screen] = true;
            q.offer(new State(cur.screen, cur.screen, cur.time + 1));
        }
    }

    private static void pasteToScreen(State cur, Deque<State> q) {
        if (cur.clipboard > 0 && cur.screen + cur.clipboard <= 1000) {
            if (!visited[cur.screen + cur.clipboard][cur.clipboard]) {
                visited[cur.screen + cur.clipboard][cur.clipboard] = true;
                q.offer(new State(cur.screen + cur.clipboard, cur.clipboard, cur.time + 1));
            }
        }
    }

    private static void deleteFromScreen(State cur, Deque<State> q) {
        if (cur.screen > 0 && !visited[cur.screen - 1][cur.clipboard]) {
            visited[cur.screen - 1][cur.clipboard] = true;
            q.offer(new State(cur.screen - 1, cur.clipboard, cur.time + 1));
        }
    }

    private static class State {
        int screen; // 화면의 이모티콘 개수
        int clipboard; // 클립보드의 ..
        int time;
        private State(int screen, int clipboard, int time) {
            this.screen = screen;
            this.clipboard = clipboard;
            this.time = time;
        }
    }
}
