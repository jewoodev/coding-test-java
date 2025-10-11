package coding.test.backjoon.silver;

import java.io.*;

public class GoldbachConjecture2 { // https://www.acmicpc.net/problem/9020, 에라토스테네스의 체
    static int MAX = 10_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 에라토스테네스의 체를 쓰기 위한 체크 배열
        boolean[] check = new boolean[MAX]; // false면 소수
        check[0] = check[1] = true; // 0과 1은 소수가 아님

        for (int i = 2; i * i < MAX; i++) {
            if (check[i] == true) continue;
            for (int j = i * i; j < MAX; j += i) {
                check[j] = true;
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            // n/2부터 역순으로 탐색하여 차이가 가장 작은 골드바흐 파티션 찾기
            for (int p = n / 2; p >= 2; p--) {
                if (!check[p] && !check[n - p]) {
                    sb.append(p).append(" ").append(n - p).append("\n");
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}
