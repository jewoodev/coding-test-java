package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class DragonCurve { // https://www.acmicpc.net/problem/15685, 구현
    private static boolean[][] check = new boolean[101][101];
    private static int[] dy = {0, -1, 0, 1};
    private static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int gen = Integer.parseInt(st.nextToken());

            List<Integer> dirs = recordDirs(dir, gen);
            check[y][x] = true;
            for (int i : dirs) {
                y += dy[i];
                x += dx[i];
                check[y][x] = true;
            }
        }

        int ans = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (check[i][j] && check[i][j + 1] &&
                        check[i + 1][j] && check[i + 1][j + 1]) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    private static List<Integer> recordDirs(int dir, int gen) {
        List<Integer> ans = new ArrayList<>();
        ans.add(dir);
        for (int i = 1; i <= gen; i++) {
            List<Integer> temp = new ArrayList<>(ans);
            Collections.reverse(temp);
            for (int j = 0; j < temp.size(); j++) {
                temp.set(j, (temp.get(j) + 1) % 4);
            }

            ans.addAll(temp);
        }
        return ans;
    }
}
