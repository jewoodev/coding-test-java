package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class Resignation { // https://www.acmicpc.net/problem/14501, DP || 브루트포스
    private static Counsel[] schedule;
    private static int n, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ans = 0;
        n = Integer.parseInt(br.readLine());
        schedule = new Counsel[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            schedule[i] = new Counsel(time, money);
        }
        go(0, 0);
        System.out.println(ans);
    }

    private static void go(int date, int money) {
        if (date <= n) { // 상담을 하는데 쓰이는 시간이 흐른 뒤가 date 값이 되므로 가능 범위에 n 값을 포함
            ans = Math.max(ans, money);
        }

        for (int d = date; d < n; d++) {
            if (d + schedule[d].time > n) continue;
            go(d + schedule[d].time, money + schedule[d].money);
        }
    }

    private static class Counsel {
        int time;
        int money;
        private Counsel(int time, int money) {
            this.time = time;
            this.money = money;
        }
    }
}