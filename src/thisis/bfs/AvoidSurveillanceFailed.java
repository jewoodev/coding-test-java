package thisis.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class AvoidSurveillanceFailed {
    private static int n;
    private static char[][] map;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        //맵 정보 저장
        for (int i = 0; i < n; i++) {
            map[i] = (br.readLine()).toCharArray();
        }

        Queue<Node> s = new LinkedList<>();
        Queue<Node> t = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'S') s.add(new Node(i, j));
                else t.add(new Node(i, j));
            }
        }

        while (!s.isEmpty()) {
            Node a = s.poll();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 'X') {

                    }
                }
            }
            for (int i = 0; i < t.size(); i++) {
                Node b = t.peek();
                if (a.x == b.x) {

                }
            }



        }
    }
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
