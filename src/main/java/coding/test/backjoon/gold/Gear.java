package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class Gear { // https://www.acmicpc.net/problem/14891, 구현
    private static int[][] gears = new int[4][8];
    private static int k;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        rotateGear();
        calculatePoint();
    }

    private static void init() throws IOException {
        for (int i = 0; i < 4; i++) {
            String gearInfo = br.readLine();
            for (int j = 0; j < 8; j++) {
                gears[i][j] = gearInfo.charAt(j) - '0';
            }
        }

        k = Integer.parseInt(br.readLine());
    }

    private static void rotateGear() throws IOException {
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken()) - 1;
            int rotateDir = Integer.parseInt(st.nextToken());
            int[] rotateDirs = new int[4];
            rotateDirs[target] = rotateDir;

            checkLeftRotateDir(target, rotateDir, rotateDirs);
            chckRightRotateDir(target, rotateDir, rotateDirs);
            rotateEntirely(rotateDirs);
        }
    }

    private static void checkLeftRotateDir(int target, int rotateDir, int[] rotateDirs) {
        while (target > 0) {
            if (gears[target][6] != gears[--target][2]) {
                rotateDir *= -1;
                rotateDirs[target] = rotateDir;
            } else {
                break;
            }
        }
    }

    private static void chckRightRotateDir(int target, int rotateDir, int[] rotateDirs) {
        while (target < 3) {
            if (gears[target][2] != gears[++target][6]) {
                rotateDir *= -1;
                rotateDirs[target] = rotateDir;
            } else {
                break;
            }
        }
    }

    private static void rotateEntirely(int[] rotateDirs) {
        for (int i = 0; i < 4; i++) {
            if (rotateDirs[i] == 1) {
                rotate(i, 7);
            } else if (rotateDirs[i] == -1) {
                rotate(i, 1);
            }
        }
    }

    private static void rotate(int target, int moveIdx) {
        // 시계방향으로 회전시키려면 배열 인덱스를 오른쪽으로 1칸씩 밀어야함.
        // 반시계방향은 왼쪽으로 1칸씩 밀어야함.
        int[] temp = new int[8];
        for (int i = 0; i < 8; i++) {
            temp[i] = gears[target][(i + moveIdx) % 8];
        }
        gears[target] = temp;
    }

    private static void calculatePoint() {
        int point = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i][0] == 1)
                point += Math.pow(2, i);
        }
        System.out.print(point);
    }
}
