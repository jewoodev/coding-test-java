package coding.test.thisis.realization;

import java.io.*;

public class ViewPoint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int hour = 0; hour < n + 1; hour++) {
            for (int min = 0; min < 60; min++) {
                for (int sec = 0; sec < 60; sec++) {
                    StringBuilder sb = new StringBuilder();
                    String temp = sb.append(hour).append(min).append(sec).toString();
                    if (temp.contains("3")) cnt++;
                }
            }
        }

        bw.write("cnt = " + cnt);
        br.close();
        bw.close();
    }
}
