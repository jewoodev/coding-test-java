package coding.test.thisis.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class FrozenDrinkEatCorrect { //p151
    /**
     * 시간 제한 1초
     * 각 칸이 이어져 있는 것을 노드를 이용해 구현하고 연결되는 구멍 칸을 하나의 덩어리로 센 후
     * 더 이상 이어지는 칸이 없으면 구멍 칸을 찾는 dfs를 만든다.
     */

    static int[][] frame;
    static int row;
    static int col;

    public static boolean dfs(int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col) return false; //얼음 틀 벗어나는 범위
        if (frame[i][j] == 0) {
            frame[i][j] = 1; //해당 노드 방문처리
            //인접한 부분도 얼릴 수 있는 칸인지 확인(재귀 함수)
            dfs(i + 1, j);
            dfs(i, j + 1);
            dfs(i - 1, j);
            dfs(i, j - 1);

            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken()); //얼음 틀의 행 갯수
        col = Integer.parseInt(st.nextToken()); //얼음 틀의 열 갯수
        frame = new int[row][col]; //주어지는 모양에 맞는 얼음 틀 생성
        int answer = 0;

        for (int i = 0; i < row; i++) {
            String[] strArr = br.readLine().split("");
            for (int j = 0; j < col; j++) {
                frame[i][j] = Integer.parseInt(strArr[j]); //틀 모양 적용
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i, j)) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
        br.close();
    }
}
