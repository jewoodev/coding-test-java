package coding.test.hanghae.beforehand.day2.supplement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//무인도 여행
public class DesertIslandTrip {
    static int X = 0;
    static int Y = 0;
    static int day = 0;

    public static int[] solution(String[] maps) {
        X = maps.length;
        Y = maps[0].length();

        //maps -> 2차원 int 배열
        int[][] maps2 = new int[X][Y];
        for (int i = 0; i < X; i++) {
            char[] chars = maps[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == 'X')
                    maps2[i][j] = 0;
                else
                    maps2[i][j] = chars[j] - '0';
            }
        }

        List<Integer> days = new ArrayList<>();
        boolean[][] visited = new boolean[X][Y];
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                //방문 이력이 없고 섬이면
                if (!visited[i][j] && maps2[i][j] > 0) {
                    dfs(maps2, visited, i, j);
                    days.add(day);
                    day = 0;
                }
            }
        }
        if (days.isEmpty())
            return new int[]{-1};

        //오름차순 정렬
        Collections.sort(days);
        int[] answer = new int[days.size()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = days.get(i);
        return answer;
    }

    private static void dfs(int[][] map, boolean[][] visited, int x, int y) {
        day += map[x][y];
        visited[x][y] = true;
        //상하좌우 이동
        int[] UD = {1, -1, 0, 0};
        int[] LR = {0, 0, 1, -1};
        for (int i = 0; i < 4; i++) {
            int newX = x + UD[i];
            int newY = y + LR[i];
            //범위 체크
            if (newX < 0 || newY < 0 || newX >= X || newY >= Y)
                continue;
            //방문 이력이 없으면서 섬이면
            if (!visited[newX][newY] && map[newX][newY] > 0)
                dfs(map, visited, newX, newY);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"X591X","X1X5X","X231X", "1XXX1"}));
    }
}
