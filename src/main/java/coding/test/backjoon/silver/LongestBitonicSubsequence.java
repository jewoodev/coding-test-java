package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class LongestBitonicSubsequence { // https://www.acmicpc.net/problem/11054, DP
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] read = br.readLine().split(" ");
        int max = 0;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(read[i]);
            if (max <= a[i]) max = a[i];
        }
        List<Integer> maxRecord = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (a[i] == max) maxRecord.add(i);
        }

        int[] d = new int[N];
        int ans = 0;
        for (int k = 0; k < maxRecord.size(); k++) {
            Integer maxIdx = maxRecord.get(k);

            for (int i = 0; i < N; i++)
                d[i] = 1;

            for (int i = N-1; i > maxIdx; i--) {
                for (int j = i-1; j >= maxIdx; j--) {
                    if (a[i] < a[j] && d[j] < d[i] + 1) {
                        d[j] = d[i] + 1;
                    }
                }
            }

            for (int i = 0; i < maxIdx; i++) {
                for (int j = i+1; j <= maxIdx; j++) {
                    if (a[i] < a[j] && d[j] < d[i] + 1) {
                        d[j] = d[i] + 1;
                    }
                }
            }

            int curAns = d[maxIdx] + (d[maxIdx-1] < d[maxIdx+1] ? d[maxIdx-1] : d[maxIdx+1]);
            ans = Math.max(ans, curAns);
        }

        System.out.println(ans);
    }
}
