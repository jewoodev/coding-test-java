package thisis.sort;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SwapTwoArraysElem { //p182
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] f = new int[n];
        Integer[] t = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            f[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            t[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(f);
        Arrays.sort(t, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            if (f[i] < t[i]) f[i] = t[i];
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += f[i];
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
