package doit.number.theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GetAlmostPrimeNum { /* P220 문제 38. 거의 소수 구하기 */
    public static int solution(long a, long b) {
        // 에라토스테네스의 체
        long[] arr = new long[10_000_001];
        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(arr.length); i++) { // 제곱근 까지만 수행
            if (arr[i] == 0) {
                continue;
            }
            for (int j = i + i; j < arr.length; j = j + i) { // 배수 지우기
                arr[j] = 0;
            }
        }

        // 거의소수
        int count = 0;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != 0) {
                long temp = arr[i];
                while ((double) arr[i] <= (double) b / (double) temp) {
                    if ((double) arr[i] >= (double) a / (double) temp) {
                        count++;
                    }
                    temp = temp * arr[i];
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        System.out.println(solution(a, b));
    }
}

    /* 책의 풀이, 이것도 오답이였다. */
    /*
    public static void Main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        ArrayList<Long> arr = new ArrayList<>();
        for (long i = 0; i < max+1; i++) {
            arr.add(i);
        }
        for (int i = 2; i <= Math.sqrt(arr.size()); i++) {
            if (arr.get(i) == 0) continue;
            for (int j = i+i; j < arr.size(); j+=i) {
                if (arr.get(j) != 0) arr.set(j, 0L);
            }
        }
        int cnt = 0;
        for (int i = 2; i < max; i++) {
            if (arr.get(i) == 0) {
                long temp = arr.get(i);
                while ((double) arr.get(i) <= (double) max/(double) temp) {
                    if ((double) arr.get(i) >= (double) min/(double) temp) {
                        cnt++;
                    }
                    temp = temp * arr.get(i);
                }
            }
        }
        System.out.println(cnt);
    }
}
*/


    /* 어디가 틀린 건지 모르겠다. */
    /* 책 풀이로 이해 시도 후 -> 2가 2 제곱의 결과만 while문 조건에서 확인하고 넘어가버리는 연산을 하고 있는 문제 발견 */
    /*
    public static void Main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] arr = new int[b+1];
        for (int i = 2; i < b+1; i++) {
            arr[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(b); i++) {
            if (arr[i] == 0) continue;
            for (int j = i+i; j <= b; j+=i) {
                if (arr[j] != 0) arr[j] = 0;
            }
        }
        int result = 0;
        for (int i = 2; i <= Math.sqrt(b); i++) {
            if (arr[i] != 0) {
                int exponent = 2;
                while (Math.pow(i, exponent) <= b && Math.pow(i, exponent) >= a) {
                    result++;
                    exponent++;
                }
            }
        }
        System.out.println(result);
    }
}
     */


    /* 놓치고 있는 게 뭔지 몰라서 못 풀었다. */
/*
    public static void Main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] arr = new int[b+1];
        for (int i = 2; i < b+1; i++) {
            arr[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(b); i++) {
            if (arr[i] == 0) continue;
            for (int j = i+i; j <= b; j+=i) {
                if (arr[j] != 0) arr[j] = 0;
            }
        }
        int result = 0;
        for (int i = 2; i <= Math.sqrt(b); i++) {
            if (arr[i] != 0) {
                if (Math.pow(i, 2) <= b) result++;
                else break;
            }
        }
        System.out.println(result);
    }
}
*/

