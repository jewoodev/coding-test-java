package doit.number.theory;

import java.util.Scanner;

public class GetMinPrimeAndPalindrome { /* P224 문제 39. 소수 & 팰린드롬 수 중에서 최솟값 찾기 */
    /* 책 풀이 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[10_000_001]; //n의 범위까지 소수 구하기 시작
        for (int i = 2; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = 2; i < Math.sqrt(a.length); i++) {
            if (a[i] == 0) {
                continue;
            }
            for (int j = i + i; j < a.length; j += i) {
                a[j] = 0;
            }
        } //여기까지 n의 범위까지 소수 구하기 끝
        int i = n;
        //n부터 소수이면서 팰린드룸 수인지 확인
        while (true) {
            if (a[i] != 0) {
                int result = a[i];
                if (isPalindrome(result)) {
                    System.out.println(result);
                    break;
                }
            }
            i++;
        }
    }

    private static boolean isPalindrome(int target) {
        char[] c = String.valueOf(target).toCharArray();
        int s = 0;
        int e = c.length - 1;
        while (s < e) {
            if (c[s] != c[e]) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}


    /* 어디서 틀린 건지 모르겠다
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[1_000_001];
        for (int i = 2; i < a.length; i++) {
            a[i] = i;
        }
        solution(n, a);
    }

    private static void solution(int startNum, int[] a) {
        sieveOfEratosthenes(a);
        for (int i = startNum; i < a.length; i++) {
            if (a[i] != 0) {
                char[] c = Integer.toString(i).toCharArray();
                if (c.length < 3) {
                    continue;
                }
                boolean isPalindrome = true;
                for (int j = 0; j <= c.length / 2; j++) {
                    if (c[j] != c[c.length - 1 - j]) {
                        isPalindrome = false;
                    }
                }
                if (isPalindrome == true) {
                    System.out.println(i);
                    System.exit(0);
                }
            }
        }
    }

    private static void sieveOfEratosthenes(int[] a) {
        for (int i = 2; i < Math.sqrt(a.length); i++) {
            if (a[i] == 0) continue;
            for (int j = i + i; j < a.length; j += i) {
                if (a[i] == 0) continue;
                else a[j] = 0;
            }
        }
    }
}*/
