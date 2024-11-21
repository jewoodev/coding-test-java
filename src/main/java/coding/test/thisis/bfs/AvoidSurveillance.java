package coding.test.thisis.bfs;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AvoidSurveillance { //p351
    private static int n;
    private static char[][] map;
    private static ArrayList<Node> s = new ArrayList<>();
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        //맵 정보 저장
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'S') s.add(new Node(i, j));
            }
        }
        dfs(0);
    }

    static void dfs(int wallCnt) throws IOException {
        if (wallCnt == 3) {
            bfs(); //장애물 설치가 완료될 때마다 문제의 결과 확인
            return;
        }
        //장애물을 설치할 수 있는 모든 경우의 수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = '0';
                    dfs(wallCnt + 1);
                    map[i][j] = 'X';
                }
            }
        }
    }

    static void bfs() throws IOException {
        Queue<Node> t = new LinkedList<>();
        //각 경우의 수마다 확인하기위해 copyMap 사용
        char[][] copyMap = new char[n][n];
        //교사의 시선이 방문가능한지 나타낸 배열
        boolean[][] visited = new boolean[n][n];

        //원본을 가져온다.
        for (int i = 0; i < n; i++) {
                copyMap[i] = map[i].clone();
        }
        //1. 교사의 시선이 방문하는 BFS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (copyMap[i][j] == 'T') {
                    t.add(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }
        while (!t.isEmpty()) {
            Node a = t.poll();
            int x = a.x;
            int y = a.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                while (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (copyMap[nx][ny] != '0') {
                        visited[nx][ny] = true;
                        nx += dx[i];
                        ny += dy[i];
                    } else break;
                }
            }
        }

        //2. 시선에 닿는지 확인값 출력
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
        if (!canAvoid(visited)) {
            br.write("YES");
        } else {
            br.write("NO");
        }
        br.close();
    }

    private static boolean canAvoid(boolean[][] visited) {
        for (Node node : s) {
            if (visited[node.x][node.y] == true) return false;
        }
        return true;
    }
}
