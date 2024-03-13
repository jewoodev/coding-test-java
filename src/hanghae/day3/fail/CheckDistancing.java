package hanghae.day3.fail;

import java.util.Arrays;

//거리두기 확인하기
public class CheckDistancing {

    static int[] UD = new int[]{-1,1,0,1};
    static int[] LR = new int[]{0,0,-1,1};

    public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        //대기실 하나씩 char 배열로 만들어 dfs 탐색
        for (int i = 0; i < 5; i++) {
            char[][] place = new char[5][5];
            int k = 0;
            for (int j = 0; j < 5; j++) {
                place[k] = places[i][j].toCharArray();
                k++;
                //한 대기실의 변환이 완료되었음이 확인되면 탐색 시작
                if (j == 4)
                    answer[i] = dfs(place, 0, 0, 0);
            }
        }

        return answer;
    }

    private static int dfs(char[][] place, int curX, int curY, int distance) {
        boolean[][] visited = new boolean[5][5];
        visited[curX][curY] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = curX + UD[i];
            int nextY = curY + LR[i];
            //탐색 시작
            if (nextX < 0 || nextY < 0 || nextX > 4 || nextY > 4
                    || place[nextX][nextY] == 'X' || visited[nextX][nextY])
                continue;
            else if (place[nextX][nextY] == 'O') {
                visited[nextX][nextY] = true;
                distance++;
                dfs(place, nextX, nextY, distance);
            }
            //사람과의 거리가 2이면 규칙을 어긴 것, 0을 반환
            else if (distance == 2 && place[nextX][nextY] == 'P')
                return 0;
            //거리가 2가 아닌데 사람을 만나면, 그 사람을 기준으로 다시 탐색
            else if (place[nextX][nextY] == 'P') {
                dfs(place, nextX, nextY, 0);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        String[][] places = new String[][]{
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        Arrays.stream(solution(places)).forEach(System.out::println);
    }
}
