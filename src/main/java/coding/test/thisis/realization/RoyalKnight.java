package coding.test.thisis.realization;

import java.io.*;

public class RoyalKnight {
    static int[][] move = new int[][] { //나이트가 이동할 수 있는 경우의 수
            {-1, 2}, {-1, -2}, {1, 2}, {1, -2}, {-2, 1}, {-2, -1}, {2, 1}, {2, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String sPoint = br.readLine(); //입력되는 시작점
        int cnt = 0;

        int x = sPoint.charAt(1) - '1'; //x좌표
        int y = sPoint.charAt(0) - 'a'; //y좌표

        for (int i = 0; i < 8; i++) {
            int curX = x + move[i][0]; //이동했을 때
            int curY = y + move[i][1];

            if (curX < 0 || curX > 7 || curY < 0 || curY > 7) continue; // 체스판을 벗어나지 않을 때마다
            cnt++; //횟수를 추가
        }

        bw.write(""+cnt);
        br.close();
        bw.close();
    }
}
