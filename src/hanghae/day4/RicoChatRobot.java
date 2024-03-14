package hanghae.day4;

import java.util.LinkedList;
import java.util.Queue;

//리코쳇 로봇
//나중에 보니 이동할 때 벽을 만나기 전까지 안 멈추고 가야되는데 이렇게 경로에 조건을 달려면 DFS로 구현해야 한다.
//그냥 풀이를 보자. 시간을 너무 많이 썼다.
//아니었다!
public class RicoChatRobot {

    static boolean[][] visited;
    private static int R;
    private static int C;

    public static int solution(String[] board) {
        R = board.length;
        C = board[0].length();
        visited = new boolean[R][C];
        Robot robot = null; //로봇
        Robot goal = null; //도착 지점

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    robot = new Robot(i, j, 0);
                } else if (board[i].charAt(j) == 'G') {
                    goal = new Robot(i, j, 0);
                }
            }
        }

        return bfs(board, robot, goal);
    }

    private static int bfs(String[] board, Robot robot, Robot goal) {
        int[] dx = {-1, 1, 0, 0}; //위아래
        int[] dy = {0, 0, -1, 1}; //왼오

        Queue<Robot> q = new LinkedList<>();
        q.add(robot);
        visited[robot.x][robot.y] = true;

        while (!q.isEmpty()) {
            Robot rb = q.poll();

            if (rb.x == goal.x && rb.y == goal.y)
                return rb.depth;

            for (int i = 0; i < 4; i++) {
                int nx = rb.x;
                int ny = rb.y;

                //범위를 벗어나거나 장애물을 만날 때까지 돌진
                while (inRange(nx, ny) && board[nx].charAt(ny) != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }

                //벽과 하나되거나 게임판 밖으로 나가기 바로 직전 위치
                nx -= dx[i];
                ny -= dy[i];

                //방문을 하거나 같은 위치(끝에서 움직일 경우)일 경우 continue
                if (visited[nx][ny] || (nx == rb.x && ny == rb.y)) continue;

                visited[nx][ny] = true;
                q.offer(new Robot(nx, ny, rb.depth + 1));
            }
        }
        return -1;
    }

    private static boolean inRange(int x, int y) {
        return (x >= 0 && y >= 0 && x < R && y < C);
    }

    private static class Robot {
        int x, y, depth;

        public Robot(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
    }
}
