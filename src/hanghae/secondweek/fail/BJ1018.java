package hanghae.secondweek.fail;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BJ1018 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] chessBoard = new char[N][M];
        for (int i = 0; i < N; i++) {
            chessBoard[i] = br.readLine().toCharArray();
        }
        System.out.print(BFS(chessBoard));
    }

    //다시 칠해야 하는 곳을 체크하며 모든 곳을 체크하는 탐색
    private static int BFS(char[][] chessBoard) {
        int cnt = 0;
        boolean[][] vistited = new boolean[N][M];
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(0, 0));
        while (!q.isEmpty()) {
            Position p = q.poll();
            vistited[p.x][p.y] = true;
            for (int i = 0; i < 4; i++) {
                int nX = p.x + dx[i];
                int nY = p.y + dy[i];
                if (nX > -1 && nY > -1 && nX < N && nY < M && !vistited[nX][nY]) {
                    vistited[nX][nY] = true;
                    q.offer(new Position(nX, nY));
                    if (chessBoard[p.x][p.y] == chessBoard[nX][nY])
                        cnt++;
                }
            }
        }
        return cnt;
    }

    private static class Position {
        int x, y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}