package coding.test.thisis.sort;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class UpAndDown { //p178
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] input = new Integer[n];

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(input, Comparator.reverseOrder());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for (Integer s: input) {
            sb.append(s).append(" ");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
