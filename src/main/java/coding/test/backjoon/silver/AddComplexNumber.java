package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class AddComplexNumber { // https://www.acmicpc.net/problem/2667, DFS | BFS
    private static int n;
    private static int complexNumber = 0;
    private static boolean[][] visited;
    private static final int[] dy = {0, 0, -1, 1};
    private static final int[] dx = {-1, 1, 0, 0};
    private static Queue<Integer> cntNote = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        int[][] complex = new int[n][n];

        boolean isFirst = false;
        for (int i = 0; i < n; i++) {
            String read = br.readLine();
            for (int j = 0; j < n; j++) {
                complex[i][j] = read.charAt(j) - '0';
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && complex[i][j] == 1) {
                    bfs(complex, i, j);
                    complexNumber++;
                }
            }
        }
        ans.append(complexNumber).append("\n");

        while (!cntNote.isEmpty()) {
            ans.append(cntNote.poll()).append("\n");
        }

        System.out.println(ans);
    }

    private static void bfs(int[][] complex, int y, int x) {
        Deque<Node> q = new ArrayDeque<>();
        q.offer(new Node(y, x));
        visited[y][x] = true;
        int complexCnt = 1;

        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        if (complex[ny][nx] == 1) {
                            complexCnt++;
                            q.offer(new Node(ny, nx));
                        }
                    }
                }
            }
        }

        cntNote.offer(complexCnt);
    }

    private static class Node {
        int y, x;
        private Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
