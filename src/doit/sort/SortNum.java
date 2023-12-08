package doit.sort;

import java.io.*;

public class SortNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n - 1; i++) {
            if (num[i] > num [i+1]) {
                int tmp = num[i];
                num[i] = num[i+1];
                num[i+1] = tmp;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for (int i : num) {
            sb.append(i).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
