package thisis.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FrozenDrinkEat { //p151
    /**
     * 시간 제한 1초
     * 각 칸이 이어져 있는 것을 노드를 이용해 구현하고 연결되는 구멍 칸을 하나의 덩어리로 센 후
     * 더 이상 이어지는 칸이 없으면 구멍 칸을 찾는 dfs를 만든다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] frame = new int[row+1][col];
        boolean[][] visited = new boolean[row+1][col];
        int[][] dfsGraph = new int[row+1][col];

        for (int i = 1; i < row + 1; i++) {
            String[] strArr = br.readLine().split("");
            for (int j = 0; j < col; j++) {
                frame[i][j] = Integer.parseInt(strArr[j]);
            }
        }


    }

    static void makeDfsGraph(int[][] frame, int[][] dfsgraph, int row, int col) {
        for (int i = 1; i < row + 1; i++) {
            for (int j = 0; j < col; j++) {
                if (frame[i][j] == 0) {

                }
            }
        }
    }
}
