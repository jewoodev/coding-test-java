package hanghae.beforehand.day3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

//거리두기 확인하기
public class CheckDistancing {

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) { //대기실 loop
            String[] p = places[i]; //대기실

            boolean isOk = true; //거리두기 지킴 여부
            for (int r = 0; r < 5 && isOk; r++) { //행 loop
                for (int c = 0; c < 5 && isOk; c++) { //열 loop
                    if (p[r].charAt(c) == 'P') { //사람을 찾아서
                        if (!bfs(r, c, p)) //bfs
                            isOk = false;
                    }
                }
            }
            answer[i] = isOk ? 1 : 0;
        }

        return answer;
    }

    private static boolean bfs(int r, int c, String[] p) {
        int[] UD = { -1, 1, 0, 0 }; //위아래
        int[] LD = { 0, 0, -1, 1 }; //왼오

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { r, c }); //사람 위치를 큐에 삽입

        while (!queue.isEmpty()) { //확인된 위치에서 bfs
            int[] position = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = position[0] + UD[i];
                int nc = position[1] + LD[i];

                if (nr < 0 || nc < 0 || nr > 4 || nc > 4 || (nr == r && nc == c))
                    continue;

                int d = Math.abs(nr - r) + Math.abs(nc - c); //이동 거리

                if (p[nr].charAt(nc) == 'P' && d <= 2) //사람과의 거리가 맨허튼 거리 이하의 거리이면
                    return false;
                else if (p[nr].charAt(nc) == 'O' && d < 2) //아니면
                    queue.offer(new int[] { nr, nc });
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[][] places = new String[][]{
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        String s = Arrays.stream(solution(places)).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("["+s+"]");
    }
}
