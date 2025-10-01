package coding.test.backjoon.silver;

//import java.io.*;
//import java.util.*;
//
//public class LongestDecreasingSubsequence { // https://www.acmicpc.net/problem/11722, DP
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int[] a = Arrays.stream(br.readLine().split(" "))
//                .mapToInt(Integer::parseInt).toArray();
//        int[] d = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            d[i] = 1;
//            for (int j = 0; j <= i; j++) {
//                if (a[i] < a[j] && d[i] < d[j] + 1) {
//                    d[i] = d[j] + 1;
//                }
//            }
//        }
//
//        int ans = d[0];
//        for (int i = 1; i < n; i++) {
//            if (ans < d[i]) ans = d[i];
//        }
//        System.out.println(ans);
//    }
//}


// ----------- 다른 풀이 ↓ ----------- //
import java.io.*;
import java.util.*;

public class LongestDecreasingSubsequence { // https://www.acmicpc.net/problem/11722, DP
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1; // 수열의 시작하는 원소를 기준으로 점화식을 세움
        }

        for (int i = n - 1; i >= 0; i--) { // 그렇기에 dp 배열을 채워나가는 방향이 역순으로 바뀜(d[1]로 d[2]가 구해지는 것의 반대)
            for (int j = i - 1; j >= 0; j--) {
                if (a[i] < a[j] && dp[j] < dp[i] + 1) {
                    dp[j] = dp[i] + 1;
                }
            }
        }

        int ans = dp[0];
        for (int i = 0; i < n; i++) {
            if (ans < dp[i]) ans = dp[i];
        }
        System.out.println(ans);
    }
}