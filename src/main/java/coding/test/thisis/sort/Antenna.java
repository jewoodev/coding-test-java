package coding.test.thisis.sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Antenna { //p360
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] home = new int[n];

        for (int i = 0; i < n; i++) {
            home[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(home);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if (n % 2 == 0) bw.write(String.valueOf(home[n / 2 - 1]));
        else bw.write(String.valueOf(home[n / 2]));
        bw.close();
        br.close();
    }
}
