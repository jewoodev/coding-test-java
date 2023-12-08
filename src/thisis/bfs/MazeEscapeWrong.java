package thisis.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MazeEscapeWrong {
    static int row;
    static int col;
    static int[][] graph;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        graph = new int[row][col];
        for (int i = 0; i < row; i++) {
            String[] splitStr = br.readLine().split("");
            for (int j = 0; j < col; j++) {
                graph[i][j] = Integer.parseInt(splitStr[j]);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (bfs(i, j));
            }
        }
        System.out.println("cnt = " + cnt);
    }

    private static boolean bfs(int i, int j) {
        if (i < 0 || i > row - 1 || j < 0 || j > col - 1) return false;
        if (graph[i][j] == 1) {
            graph[i][j]++;
            cnt++;
            bfs(i-1,j);
            bfs(i+1,j);
            bfs(i,j-1);
            bfs(i,j+1);
            return true;
        }
        return false;
    }
}
