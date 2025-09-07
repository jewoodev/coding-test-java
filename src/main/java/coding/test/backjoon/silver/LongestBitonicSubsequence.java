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
//        String[] read = br.readLine().split(" ");
//        int max = 0;
//        int[] a = new int[N];
//        for (int i = 0; i < N; i++) {
//            a[i] = Integer.parseInt(read[i]);
//            if (max <= a[i]) max = a[i];
//        }
//        List<Integer> maxRecord = new ArrayList<>();
//        for (int i = 0; i < N; i++) {
//            if (a[i] == max) maxRecord.add(i);
//        }
//
//        int[] d = new int[N];
//        int ans = 0;
//        for (int k = 0; k < maxRecord.size(); k++) {
//            Integer maxIdx = maxRecord.get(k);
//
//            for (int i = 0; i < N; i++)
//                d[i] = 1; // 1을 미리 세팅해서 루프에서 시작점이 되는 i 인덱스가 아닌 탐색해나가는 j 인덱스의 값에 누적해나가려는 전략이었으나,
//            // 즉, 부분 수열의 마지막 부분으로 세운 점화식이 아닌 부분 수열의 시작 부분으로 세운 점화식을 사용하려 했으나
//
//            for (int i = N-1; i > maxIdx; i--) {
//                for (int j = i-1; j >= maxIdx; j--) {
//                    if (a[i] < a[j] && d[j] < d[i] + 1) { // 그러한 점화식을 사용하면 D[N]의 값을 증가시킬 조건을 작성하는게 불가능함.
//                        d[j] = d[i] + 1; // 되는 것 같아보여서 더 위험. 되는 줄 알고 한참 해맸음. 될 수도 있는데 적어도 내 기준에선 안된다고 봄.
//                    }
//                }
//            }
//
//            for (int i = 0; i < maxIdx; i++) {
//                for (int j = i+1; j <= maxIdx; j++) {
//                    if (a[i] < a[j] && d[j] < d[i] + 1) {
//                        d[j] = d[i] + 1;
//                    }
//                }
//            }
//
//            int curAns = d[maxIdx] + (d[maxIdx-1] < d[maxIdx+1] ? d[maxIdx-1] : d[maxIdx+1]);
//            ans = Math.max(ans, curAns);
//        }
//
//        System.out.println(ans);
//    }
//}