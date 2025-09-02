package coding.test.backjoon.silver;

import java.io.*;

public class NextPermutation { // https://www.acmicpc.net/problem/10972, 순열
    static boolean nextPermutation(int[] a) {
        int i = a.length - 1;
        while(i > 0 && a[i-1] >= a[i])
            i -= 1;

        if (i <= 0) return false;

        int j = a.length - 1;
        while(a[i-1] >= a[j])
            j -= 1;

        int tmp = a[i-1];
        a[i-1] = a[j];
        a[j] = tmp;

        j = a.length - 1;
        while (i < j) {
            tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i += 1;
            j -= 1;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] read = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(read[i]);
        }

        if (nextPermutation(a)) {
            for (int i = 0; i < n; i++) {
                bw.write((a[i]) + " ");
            }
            bw.write("\n");
        } else {
            bw.write("-1");
        }

        bw.flush();
    }
}
