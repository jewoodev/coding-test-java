package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class RotateArray6 { // https://www.acmicpc.net/problem/20327, 구현
    private static int ORIGIN_SIZE;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        ORIGIN_SIZE = 1 << N;

        map = new int[ORIGIN_SIZE][ORIGIN_SIZE];

        for (int i = 0; i < ORIGIN_SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < ORIGIN_SIZE; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            excute(k, l);
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ORIGIN_SIZE; i++) {
            for (int j = 0; j < ORIGIN_SIZE; j++) {
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static void excute(int k, int l) {
        int blockSize = 1 << l;

        int[][] tmp = new int[ORIGIN_SIZE][ORIGIN_SIZE];

        for (int startY = 0; startY < ORIGIN_SIZE; startY += blockSize) {
            for (int startX = 0; startX < ORIGIN_SIZE; startX += blockSize) {

                for (int innerY = 0; innerY < blockSize; innerY++) {
                    for (int innerX = 0; innerX < blockSize; innerX++) {
                        int ny = startY, nx = startX;

                        switch (k) {
                            case 1:
                                ny = startY + (blockSize - 1 - innerY);
                                nx = startX + innerX;
                                break;
                            case 2:
                                ny = startY + innerY;
                                nx = startX + (blockSize - 1 - innerX);
                                break;
                            case 3:
                                ny = startY + innerX;
                                nx = startX + (blockSize - 1 - innerY);
                                break;
                            case 4:
                                ny = startY + (blockSize - 1 - innerX);
                                nx = startX + innerY;
                                break;
                            case 5:
                                ny = (ORIGIN_SIZE - blockSize) - startY + innerY;
                                nx = startX + innerX;
                                break;
                            case 6:
                                ny = startY + innerY;
                                nx = (ORIGIN_SIZE - blockSize) - startX + innerX;
                                break;
                            case 7:
                                ny = startX + innerY;
                                nx = (ORIGIN_SIZE - blockSize) - startY + innerX;
                                break;
                            case 8:
                                ny = (ORIGIN_SIZE - blockSize) - startX + innerY;
                                nx = startY + innerX;
                        }

                        tmp[ny][nx] = map[startY + innerY][startX + innerX];
                    }
                }
            }
        }

        map = tmp;
    }
}
