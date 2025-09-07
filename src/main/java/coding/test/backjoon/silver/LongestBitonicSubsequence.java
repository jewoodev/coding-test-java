package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class LongestBitonicSubsequence { // https://www.acmicpc.net/problem/11054, DP
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        String[] read = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            a[i] = Integer.parseInt(read[i]);

        int[] d1 = new int[N];
        for (int i = N-1; i >= 0; i--) { // i번째에서 끝나는 부분 수열의 최대 길이
            d1[i] = 1;
            for (int j = i+1; j < N; j++) {
                if (a[j] < a[i] && d1[i] < d1[j] + 1) {
                    d1[i] = d1[j] + 1;
                }
            }
        }

        int[] d2 = new int[N];
        for (int i = 0; i < N; i++) { // 0부터 i까지의 가장 긴 증가하는 수열의 길이
            d2[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && d2[i] < d2[j] + 1) {
                    d2[i] = d2[j] + 1;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, d1[i] + d2[i] - 1);
        }

        System.out.println(ans);
    }
}


// ----------- 오답 노트 ↓ ----------- //
//import java.io.*;
//import java.util.*;
//
//public class LongestBitonicSubsequence { // https://www.acmicpc.net/problem/11054, DP
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//        int[] a = new int[N];
//        String[] read = br.readLine().split(" ");
//        for (int i = 0; i < N; i++)
//            a[i] = Integer.parseInt(read[i]);
//
//        int[] d1 = new int[N];
//        for (int i = 0; i < N; i++)
//            d1[i] = 1; // // 1을 미리 세팅해서 루프에서 시작점이 되는 i 인덱스가 아닌 탐색해나가는 j 인덱스의 값에 누적해나가려는 전략이었으나,
//        // 즉, 부분 수열의 마지막 부분으로 세운 점화식이 아닌 부분 수열의 시작 부분으로 세운 점화식을 사용하려 했으나
//
//        for (int i = N-1; i >= 0; i--) { // -- i부터 0까지의 가장 긴 감소하는 수열의 길이
//            for (int j = i-1; j >= 0; j--) {
//                if (a[j] < a[i] && d1[j] < d1[i] + 1) {
//                    d1[j] = d1[i] + 1; // 그러한 방법에서 D[N]은 '그 위치에서 시작되는 부분 수열의 최대 길이'가 아닌
//                    // '그 위치에서 끝나는 부분 수열의 최대 길이'가 됨. 그래서 이 방법으로는 $S_{k}$값을 구할 수 없음.
//                }
//            }
//        }
//
//        int[] d2 = new int[N];
//        for (int i = 0; i < N; i++)
//            d2[i] = 1;
//        for (int i = 0; i < N; i++) { // -- 0부터 i까지의 가장 긴 증가하는 수열의 길이
//            for (int j = i+1; j < N; j++) {
//                if (a[j] > a[i] && d2[j] < d2[i] + 1) {
//                    d2[j] = d2[i] + 1;
//                }
//            }
//        }
//
//        int ans = 0;
//        for (int i = 0; i < N; i++) {
//            ans = Math.max(ans, d1[i] + d2[i] - 1);
//        }
//
//        System.out.println(ans);
//    }
//}