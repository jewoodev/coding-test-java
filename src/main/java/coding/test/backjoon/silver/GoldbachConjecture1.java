package coding.test.backjoon.silver;

import java.io.*;

public class GoldbachConjecture1 { // https://www.acmicpc.net/problem/6588, 수학 && 골드바흐의 추측
    static int MAX = 1_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] check = new boolean[MAX]; // 에라토스테네스의 체를 쓰기 위한 체크 배열

        check[0] = check[1] = true; // 0과 1은 소수가 아님
        for (int i = 2; i * i < MAX; i++) {
            if (check[i] == true) continue;
            for (int j = i * i; j < MAX; j += i) {
                check[j] = true;
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            for (int p = 3; p < n; p++) {
                if (!check[p] && !check[n - p]) {
                    sb.append(n).append(" = ")
                            .append(p).append(" + ").append(n - p).append("\n");
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}
