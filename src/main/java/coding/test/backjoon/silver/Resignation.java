package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class Resignation { // https://www.acmicpc.net/problem/14501, DP || 브루트포스
    private static int N;
    private static int[] t = new int[16];
    private static int[] p = new int[16];
    private static int[] d = new int[16];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            int[] read = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            t[i] = read[0];
            p[i] = read[1];
            d[i] = -1;
        }

        System.out.println(go(1));
    }

    private static int go(int day) {
        if (day == N + 1)
            return 0;

        if (day > N + 1)
            return Integer.MIN_VALUE;

        if (d[day] != -1)
            return d[day];

        int t1 = go(day + 1); // x
        int t2 = p[day] + go(day + t[day]); // 0
        d[day] = Math.max(t1, t2);
        return d[day];
    }
}

//public class Resignation { // 브루트 포스
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static int answer = 0, N;
//    static int[][] schedule;
//
//    static void go(int day, int profit) {
//        answer = Math.max(answer, profit);
//
//        // 모든 날짜를 확인했으면 종료
//        if (day >= N) return;
//
//        // day부터 시작하는 모든 상담을 확인
//        for (int i = day; i < N; i++) {
//            // i번째 상담을 선택할 수 있는지 확인,
//            // 상담이 N+1일 전에 끝나야 함
//            if (i + schedule[i][0] <= N) {
//                // i번째 상담을 선택하고 다음 가능한 날짜로 이동
//                go(i + schedule[i][0], profit + schedule[i][1]);
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        N = Integer.parseInt(br.readLine());
//        schedule = new int[N][2];
//        for (int i = 0; i < N; i++) {
//            schedule[i] = Arrays.stream(br.readLine().split(" "))
//                    .mapToInt(Integer::parseInt).toArray();
//        }
//
//
//        go(0, 0);
//
//        bw.write(String.valueOf(answer));
//        bw.flush();
//    }
//}
