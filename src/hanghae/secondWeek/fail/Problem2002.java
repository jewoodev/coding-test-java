package hanghae.secondWeek.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Problem2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] in = new String[n];
        String[] out = new String[n];
        for (int i = 0; i < n; i++)
            in[i] = br.readLine();
        for (int i = 0; i < n; i++)
            out[i] = br.readLine();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!in[i].equals(out[n-i-1])) cnt++;
        }
        System.out.print(cnt / 2);
    }
}