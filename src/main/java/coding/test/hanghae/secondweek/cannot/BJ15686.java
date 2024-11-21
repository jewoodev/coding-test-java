package coding.test.hanghae.secondweek.cannot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*치킨 거리는 집과 가장 가까운 치킨집 사이의 거리, 도시의 치킨 거리는 모든 집의 치킨 거리의 합*/

public class BJ15686 {
    static int N, M;
    static int[][] map;
    static ArrayList<Point> person;
    static ArrayList<Point> chicken;
    static int ans;
    static boolean[] open;
    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        person = new ArrayList<>();
        chicken = new ArrayList<>();

        // 미리 집과 치킨집에 해당하는 좌표를 ArrayList에 넣어 둠.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    person.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        ans = Integer.MAX_VALUE;
        open = new boolean[chicken.size()];

        DFS(0, 0);
        bw.write(ans + "\n");
        bw.close();
        br.close();
    }

    public static void DFS(int start, int cnt) {
        if (cnt == M) {
            int res = 0;

            for (int i = 0; i < person.size(); i++) {
                int temp = Integer.MAX_VALUE;

                // 어떤 집과 치킨집 중 open한 치킨집의 모든 거리를 비교한다.
                // 그 중, 최소 거리를 구한다.
                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {
                        int distance = Math.abs(person.get(i).x - chicken.get(j).x)
                                + Math.abs(person.get(i).y - chicken.get(j).y);

                        temp = Math.min(temp, distance);
                    }
                }
                res += temp; // 그 집의 치킨 거리를 더해 도시의 치킨 거리를 구한다.
            }
            ans = Math.min(ans, res); // 치킨 집을 남기는 경우의 수를 모두 확인하며 그 중 가장 최소의 "도시의 치킨 거리"를 구한다.
            return;
        }

        // 백트래킹
        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
                DFS(i + 1, cnt + 1);
            open[i] = false;
        }
    }
}