package doit.number.theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ImplementEulerTotientMethod { /* P233 문제 41. 오일러 피 함수 구현하기 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long pi = n;
        for (long i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                pi = pi - pi / i;
            }
            while(n % i == 0) {
                n /= i;
            }

        }
        if (n != 1) {
            pi = pi - pi / n;
        }
        System.out.println(pi);
    }
}
/* 책 풀이 , 오답
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long result = n;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                result = result - result / i;
                while (n % i == 0) n /= i;
            }
        }
        if (n > 1) result = result - result/ n;
        System.out.println(result);
    }
}
 */

    /* 메모리 초과로 오답
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        if (n == 1) {
            System.out.println(1);
            System.exit(0);
        }
        ArrayList<Long> a = new ArrayList<>();
        for (long i = 0; i < n + 1; i++) {
            a.add(i);
        }
        for (int i = 2; i < n + 1; i++) {
            for (int j = 2; j < n + 1; j++) {
                if (a.get(i) % j == 0) {
                    a.set(i, a.get(i) - (a.get(i) / j));
                }
            }
        }
        System.out.println(a.get((int) n));
    }
}*/

    /* 오일러 피 함수 원리를 이해 못했다. GCD(n, k) 이게 n과 k의 최대공약수를 표현한 것이라고 한다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        ArrayList<Long> a = new ArrayList<>();
        for (long i = 0; i < n + 1; i++) {
            a.add(i);
        }
        long answer = 1;
        for (int i = 2; i < n; i++) {
            for (int j = 2; j < n + 1; j++) {
                if (a.get(i) % j == 0) {
                    a.set(i, a.get(i) - (a.get(i) / j));
                    answer ++;
                }
            }
        }
        System.out.println(answer);
    }
}*/
