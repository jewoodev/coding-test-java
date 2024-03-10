package doit.number.theory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class GetGcd { /* P240 문제 43. 최대공약수 구하기 */
    /* 책의 풀이보고 고친 풀이 */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long gcd = gcd(a, b);
        for (long i = 0; i < gcd; i++) {
            bw.write('1');
        }
        bw.close();
    }

    private static long gcd(long a, long b) {
        if (a % b == 0) return b;
        else return gcd(b, a % b);
    }


    /* 틀린 풀이 */
    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();

        System.out.println(gcd(a, b));
    }

    private static long gcd(long a, long b) {
        if (a % b == 0) return b;
        else return gcd(b, a % b);
    }
     */
}
