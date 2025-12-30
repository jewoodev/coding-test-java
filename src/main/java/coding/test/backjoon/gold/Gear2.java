package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class Gear2 {
    public static void main(String[] args) throws IOException { // https://www.acmicpc.net/problem/15662, 구현 & 시뮬레이션
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[][] gears = new int[T][8];

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                gears[i][j] = input[j] - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int gearNum = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            gears = rolling(gears, gearNum, dir);
        }

        int ans = 0;
        for (int i = 0; i < T; i++) {
            if (gears[i][0] == 1) ans++;
        }
        System.out.println(ans);
    }

    private static int[][] rolling(int[][] gears, int gearNum, int dir) {
        int[] dirs = new int[gears.length];

        dirs[gearNum] = dir;

        // searching left gear
        int leftDir = dir;
        for (int i = gearNum; i > 0; i--) {
            if (gears[i - 1][2] != gears[i][6]) {
                leftDir *= -1;
                dirs[i - 1] = leftDir;
            } else break;
        }

        // searching right gear
        int rightDir = dir;
        for (int i = gearNum; i < gears.length - 1; i++) {
            if (gears[i][2] != gears[i + 1][6]) {
                rightDir *= -1;
                dirs[i + 1] = rightDir;
            } else break;
        }

        gears = doRolling(gears, dirs);
        return gears;
    }

    private static int[][] doRolling(int[][] gears, int[] dirs) {
        int[][] temp = new int[gears.length][8];
        for (int i = 0; i < dirs.length; i++) {
            if (dirs[i] == 1) {
                temp[i] = clockwise(gears[i]);
            } else if (dirs[i] == -1) {
                temp[i] = counterclockwise(gears[i]);
            } else {
                temp[i] = gears[i];
            }
        }
        return temp;
    }

    private static int[] counterclockwise(int[] gear) {
        int[] temp = new int[8];
        for (int i = 0; i < 8; i++) {
            temp[i] = gear[(i + 1) % 8];
        }
        return temp;
    }

    private static int[] clockwise(int[] gear) {
        int[] temp = new int[8];
        for (int i = 0; i < 8; i++) {
            temp[i] = gear[(i + 7) % 8];
        }
        return temp;
    }
}
