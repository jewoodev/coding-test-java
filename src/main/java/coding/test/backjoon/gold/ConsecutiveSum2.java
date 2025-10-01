package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class ConsecutiveSum2 { // https://www.acmicpc.net/problem/13398, DP
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] d1 = new int[n]; // 0 ~ n-1 인덱스의 최대 연속합.
        d1[0] = a[0];
        for (int i = 1; i < n; i++) {
            d1[i] = d1[i-1] + a[i]; // 일단 해당 인덱스에서 시작하는 연속합을 넣고
            if (d1[i] < a[i]) d1[i] = a[i]; // 해당 인덱스 까지의 연속합이 더 크면, 그 연속합으로 갱신.
        }

        int[] d2 = new int[n]; // n-1 ~ 0 인덱스의 최대 연속합.
        d2[n-1] = a[n-1];
        for (int i = n-2; i >= 0; i--) {
            d2[i] = d2[i+1] + a[i];
            if (d2[i] < a[i]) d2[i] = a[i];
        }

        int ans = d1[0];
        for (int i = 1; i < n; i++)
            if (d1[i] > ans) ans = d1[i];

        for (int i = 1; i < n-1; i++) {
            int cur = d1[i-1] + d2[i+1];
            if (cur > ans) ans = cur;
        }

        System.out.println(ans);
    }
}


// ----------- 오답 노트 ↓ ----------- //
//import java.io.*;
//import java.util.*;
//
//public class ConsecutiveSum2 { // https://www.acmicpc.net/problem/13398, DP
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int[] a = Arrays.stream(br.readLine().split(" "))
//                .mapToInt(Integer::parseInt).toArray();
//
//        int[] d1 = new int[n]; // 0 ~ n-1 인덱스의 최대 연속합.
//        d1[0] = a[0];
//        for (int i = 1; i < n; i++) {
//            d1[i] = d1[i-1] + a[i]; // 일단 해당 인덱스에서 시작하는 연속합을 넣고
//            if (d1[i] < a[i]) d1[i] = a[i]; // 해당 인덱스 까지의 연속합이 더 크면, 그 연속합으로 갱신.
//        }
//
//        int[] d2 = new int[n]; // n-1 ~ 0 인덱스의 최대 연속합.
//        d2[n-1] = a[n-1];
//        for (int i = n-2; i >= 0; i--) {
//            d2[i] = d2[i+1] + a[i];
//            if (d2[i] < a[i]) d2[i] = a[i];
//        }
//
//        int ans = Integer.MIN_VALUE;
//        for (int i = 1; i < n-1; i++) {
//            int cur = d1[i-1] + d2[i+1];
//            if (cur > ans) ans = cur;
//        } // 제거하지 않아도 되는데 그 경우가 포함되지 않았음.
//        System.out.println(ans);
//    }
//}
