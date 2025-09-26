package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class BuyCard { // https://www.acmicpc.net/problem/11052, DP
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cost = new int[n]; // $P_{n}$ 카드팩의 가격
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int[] total = new int[n]; // n개의 카드를 사는데 드는 비용의 최대값
        for (int i = 0; i < n; i++) {
            total[i] = cost[i];
            for (int p = 0; p < i; p++) {
                int curBuy = total[i - p - 1] + cost[p]; // 역순으로 마지막에 산 카드팩이 $P_{1}$ 인 경우 드는 최대 비용부터
                total[i] = Math.max(total[i], curBuy); // $P_{i-1}$ 인 경우 드는 최대 비용까지 비교
            }
        }

        System.out.println(total[n - 1]);
    }
}
