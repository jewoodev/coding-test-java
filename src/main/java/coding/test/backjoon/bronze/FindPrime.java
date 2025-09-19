package coding.test.backjoon.bronze;

import java.io.*;

public class FindPrime { // https://www.acmicpc.net/problem/1978
    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) { // i * i == n 조건이 포함되지 않으면 안됨
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        br.readLine();

        String[] s = br.readLine().split(" ");
        int n;
        for (String string : s) {
            n = Integer.parseInt(string);
            if (isPrime(n)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
