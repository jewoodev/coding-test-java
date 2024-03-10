package doit.number.theory;

import java.io.*;
import java.util.StringTokenizer;

public class AxPBy { /* P250 문제 45 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        br.close();
        long gcd = gcd(a, b); //최대공약수
        if (c % gcd != 0) bw.write(-1); //해가 없는 경우
        else {
            int quotient = (int) (c / gcd); //
            long[] ret = excute(a, b);
            bw.write(ret[0] * quotient + " " + ret[1] * quotient);
        }
        bw.close();
    }

    //확장 유클리드 호제법 함수
    private static long[] excute(long a, long b) {
        long[] ret = new long[2];
        if (b == 0) {
            ret[0] = 1;
            ret[1] = 0;
            return ret;
        }
        long q = a / b;
        long[] v = excute(b, a % b);
        ret[0] = v[1];
        ret[1] = v[0] - v[1] * q;
        return ret;
    }

    //최대공약수 함수
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return Math.abs(a);
    }
}


    /* 설명이 이해가 안간다 */
    /*
    private static ArrayList<Result> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int x = 1;
        int y = 0;
        if (c % gcd(a, b) == 0) {
            int s = result.size();
            for (int i = 0; i < s; i++) {
                result.get(s - 1)
            }
        } else System.out.println(-1);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        else {
            result.add(new Result(a % b, a / b));
            return gcd(b, a % b);
        }
    }

    private static class Result {
        int remainder;
        int quotient;

        public Result(int remainder, int quotient) {
            this.remainder = remainder;
            this.quotient = quotient;
        }
    }
}*/
