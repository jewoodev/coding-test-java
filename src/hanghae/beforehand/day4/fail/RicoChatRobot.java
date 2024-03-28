package hanghae.beforehand.day4.fail;

import java.util.LinkedList;
import java.util.Queue;

//리코쳇 로봇
//나중에 보니 이동할 때 벽을 만나기 전까지 안 멈추고 가야되는데 이렇게 경로에 조건을 달려면 DFS로 구현해야 한다.
//그냥 풀이를 보자. 시간을 너무 많이 썼다.
public class RicoChatRobot {

    static int move;
    static boolean[][] visited;
    private static int R;
    private static int C;

    public static int solution(String[] board) {
        boolean isFound = false;
        R = board.length;
        C = board[0].length();
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    bfs(board, i, j);
                    isFound = true;
                    break;
                }
            }
            if (isFound == true)
                break;
        }
        return move;
    }

    private static void bfs(String[] board, int r, int c) {
        int[] UD = {-1, 1, 0, 0}; //위아래
        int[] LR = {0, 0, -1, 1}; //왼오

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c}); //시작 위치를 삽입
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] position = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = position[0] + UD[i];
                int nc = position[1] + LR[i];

                if (nr < 0 || nc < 0 || nr >= R || nc >= C || visited[nr][nc])
                    continue;

                move = Math.abs(nr - r) + Math.abs(nc - c);

                if (board[nr].charAt(nc) == 'G')
                    return;
                if (board[nr].charAt(nc) == '.') {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nc,nr});

                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
    }
}
