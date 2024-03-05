package thisis.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AntWarrior {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] storage = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            storage[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = storage[0];
        dp[1] = Math.max(storage[0], storage[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + storage[i]);
        }
        System.out.println(dp[n - 1]);
        br.close();
    }
}
