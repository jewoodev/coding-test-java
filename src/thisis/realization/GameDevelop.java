package thisis.realization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GameDevelop {

    static int[] dx = {-1, 0, 1, 0}; //북, 동, 남, 서
    static int[] dy = {0, -1, 0, 1};

    static int playerDir;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int mapRow = Integer.parseInt(st.nextToken()); //맵 크기
        int mapCol = Integer.parseInt(st.nextToken());

        int[][] map = new int[mapRow][mapCol]; //맵 생성
        boolean[][] visit = new boolean[mapRow][mapCol]; //상태 맵 생성

        st = new StringTokenizer(br.readLine());
        int curX = Integer.parseInt(st.nextToken()); //현재 x좌표
        int curY = Integer.parseInt(st.nextToken()); //현재 y좌표
        int nowDir = Integer.parseInt(st.nextToken()); //현재 방향

        visit[curX][curY] = true;

        for (int i = 0; i < mapRow; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < mapCol; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0; //각 방위로 회전하는 수
        int visitcnt = 1; //몇칸 방문했니?

        while (true) {
            turnAction(); //자 돌아보자

            if ((map[curX + dx[playerDir]][curY + dy[playerDir]] == 0) && (!visit[curX + dx[playerDir]][curY + dy[playerDir]])) { //바다가 아니고 방문한 적이 없다면
                visit[curX + dx[playerDir]][curY + dy[playerDir]] = true; //방문
                visitcnt++;

                curX += dx[playerDir]; //위치 최신화
                curY += dy[playerDir];
                cnt = 0;
            } else cnt++;

            if (cnt == 4) { //다 돌아보니
                if (map[curX - dx[playerDir]][curY - dy[playerDir]] == 1) { //갈 곳이 없으면
                    break; //끝
                } else { //아니면
                    cnt = 0;
                    curX -= dx[playerDir];
                    curY -= dy[playerDir]; //문워크
                }
            }
        }
        System.out.println(visitcnt);
    }

    private static void turnAction() {
        playerDir -= 1; //왼쪽으로 돌아보아요
        if (playerDir < 0) playerDir = 3;
    }
}
