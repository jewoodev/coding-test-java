package coding.test.hanghae.forthweek.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1238 {
    private static int N, M, X, answer;
    private static List<Load>[] loads;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] dR = {-1, 1, 0, 0};
    private static int[] dC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 마을 갯수
        M = Integer.parseInt(st.nextToken()); // 도로 개수
        X = Integer.parseInt(st.nextToken()); // 도착점
        init(); // 맵 정보 받기
        BFS();
        System.out.print(answer);
    }

    private static void init() throws IOException {
        loads = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            loads[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int timeRequired = Integer.parseInt(st.nextToken());
            loads[start].add(new Load(end, timeRequired));
        }
    }

    private static void BFS() {
        Queue<Person> q = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            q.offer(new Person(i, 0));
        }

        while (!q.isEmpty()) {
            Person now = q.poll();

            if (now.where == X) {
                answer = now.takeTimes;
                return;
            }
            for (Load load : loads[now.where]) {
                q.offer(new Person(load.end, now.takeTimes + load.timeRequired));
            }
        }
    }

    private static class Load {
        // 좌표 위치, 금액
        int end, timeRequired;
        private Load(int end, int timeRequired) {
            this.end = end;
            this.timeRequired = timeRequired;
        }
    }

    private static class Person implements Comparable<Person> {
        int where, takeTimes;
        private Person(int where, int takeTimes) {
            this.where = where;
            this.takeTimes = takeTimes;
        }

        @Override
        public int compareTo(Person p) {
            return p.takeTimes - this.takeTimes;
        }
    }
}