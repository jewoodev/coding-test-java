package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

// '내리는 위치'를 halfN으로 코딩하여 오답처리된 것으로 오랫동안 헤맨 문제
public class RobotOnConveyorBelt { // https://www.acmicpc.net/problem/20055, 구현 & 시뮬레이션
    private static int N, falling;
    private static int[] durability; // 각 칸의 내구도
    private static boolean[] hasRobot;
    private static Deque<Integer> robots = new ArrayDeque<>(); // 로봇들의 위치;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int halfN = Integer.parseInt(st.nextToken());
        N = 2 * halfN;
        falling = halfN - 1;
        int K = Integer.parseInt(st.nextToken());
        durability = new int[N];
        hasRobot = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            durability[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int step = 0;
        while (true) {
            step++;

            rotateBelt();
            moveRobots();
            addRobots();

            if (countZeroDurability() >= K) { // 4.의 조건
                System.out.println(step);
                break;
            }
        }
    }

    private static void rotateBelt() {
        int endIdx = N - 1;
        int temp = durability[endIdx]; // 마지막 칸 -> 첫 칸 이동을 처리하기 위해 저장

        // 첫 칸 ~ 마지막 칸 한 칸씩 이동
        for (int curIdx = endIdx; curIdx > 0; curIdx--) {
            int prevIdx = curIdx - 1;
            durability[curIdx] = durability[prevIdx]; // 벨트만 이동
            if (hasRobot[prevIdx] && !hasRobot[curIdx]) { // 이전 칸에 로봇이 있었고 현재 칸에 없었다면
                if (curIdx != falling) { // curIdx 칸이 '내리는 칸'이 아니면
                    hasRobot[prevIdx] = false;
                    hasRobot[curIdx] = true; // 로봇이 이동되며
                    robots.poll();
                    robots.offer(curIdx); // 위치됨
                } else { // curIdx 칸이 '내리는 칸'이면
                    hasRobot[prevIdx] = false;
                    robots.poll(); // 로봇이 이동 후 내려짐
                }
            }
        }
        // 마지막 칸 -> 첫 칸 이동
        durability[0] = temp;
        // 로봇이 마지막 칸까지 올 수가 없기에 연산 x
    }

    private static void moveRobots() {
        int rCnt = robots.size(); // 벨트에 올라가 있는 로봇 수
        while (rCnt-- > 0) {
            int curIdx = robots.poll(); // 가장 먼저 벨트에 올라간 로봇부터
            int nextIdx = curIdx + 1; // 이동할 수 있는지 판단해본다
            if (!hasRobot[nextIdx] && durability[nextIdx] > 0) { // 다음 칸에 로봇이 없고 내구도가 1 이상인데
                if (nextIdx != falling) { // 다음 칸이 내리는 칸이 아니면
                    durability[nextIdx]--;
                    hasRobot[curIdx] = false;
                    hasRobot[nextIdx] = true;
                    robots.offer(nextIdx); // 로봇이 이동 후 위치됨
                } else { // 내리는 칸이면
                    durability[nextIdx]--;
                    hasRobot[curIdx] = false; // 로봇이 이동 후 내려짐
                }
            } else { // 다음 칸에 로봇이 있거나 내구도가 1 미만이면
                robots.offer(curIdx); // 가만히 있는다
            }
        }
    }

    private static void addRobots() {
        if (durability[0] > 0 && !hasRobot[0]) { // '올리는 칸'의 내구도가 0이 아니고 로봇이 없으면
            durability[0]--;
            robots.offer(0);
            hasRobot[0] = true; // 로봇을 올린다
        }
    }

    private static int countZeroDurability() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (durability[i] == 0) cnt++;
        }
        return cnt;
    }
}
