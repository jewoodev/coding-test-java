package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class FindPrime { // https://www.acmicpc.net/problem/1929, 수학 && 에라토스테네스의 체
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[m + 1];

        check[0] = check[1] = true;

        for (int i = 2; i * i <= m; i++) {
            if (check[i] == true) continue;

            for (int j = i * i; j <= m; j += i) {
                check[j] = true;
            }
        }

        for (int i = n; i <= m; i++) {
            if (check[i] == false) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }
}
