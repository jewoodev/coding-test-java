package hanghae.forthweek.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class BJ10282 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 총 감염되는 컴퓨터 수, 마지막 것까지 감염되는데 소요되는 시간
    static int totalCnt, totalTime, n;

    // 컴퓨터끼리의 의존 관계를 저장할 배열
    private static List<Computer>[] dependArr;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        // 테스트 케이스를 연산하는 루프
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수
            int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터의 번호


            dependArr = new List[n + 1]; // 의존성 정보를 저장하기 위해 초기 세팅
            for (int j = 1; j <= n; j++) {
                dependArr[j] = new ArrayList<>();
            }

            // 의존성 정보를 저장한다.
            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); // a가
                int b = Integer.parseInt(st.nextToken()); // b를 의존하고
                int s = Integer.parseInt(st.nextToken()); // b가 감염되면 a도 s초 후에 감염된다.
                dependArr[b].add(new Computer(a, s));
            }

            BFS(c);
            sb.append(totalCnt).append(" ").append(totalTime).append("\n");
        }
        System.out.print(sb);
    }

    static void BFS(int start) {
        Queue<Computer> q = new PriorityQueue<>();
        // 감염된 컴퓨터의 의존성 정보를 큐에 담는다.
        for (Computer computer : dependArr[start]) {
            q.offer(computer);
        }

        totalCnt = 1; // 총 감염된 컴퓨터 수
        totalTime = 0; // 감염이 완료되기까지 걸리는 시간
        while (!q.isEmpty()) {
            Computer now = q.poll();

            // s초가 걸려 end 번호 컴퓨터가 감염이 되면
            totalTime += now.time;
            totalCnt++; // 두 total 값을 갱신하고

            // 모든 컴퓨터의 감염이 끝났다면
            if (totalCnt == n) return; // 감염 연산을 끝낸다.

            // 이번에 감염된 컴퓨터의 의존성 정보도 큐에 담는다.
            for (Computer computer : dependArr[now.end]) {
                q.offer(computer);
            }
        }
    }

    static class Computer implements Comparable<Computer> {
        // 감염될 컴 번호, 소요 시간
        int end, time;
        Computer(int end, int time) {
            this.end = end;
            this.time = time;
        }

        @Override
        public int compareTo(Computer o) {
            return this.time - o.time;
        }
    }
}
