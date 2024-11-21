package coding.test.doit.number.theory;

import java.io.IOException;
import java.util.Scanner;

public class GetNotSquare { /* P227 문제 40. 제곱이 아닌 수 찾기 */
    /* 책보고 풀다가 풀이 원리가 이해 안가서 구글링하다가 문제에서 답을 주고 있다는 걸 깨달았다. */
    /* https://github.com/jewoodev/coding_test/commit/438c518a0e75bc7cfb7cb68df6077d9087b0f27a
    * 위의 코드는 시간 복잡도가 188ms로 더 짧은 것으로 더 좋은 코드라고 생각되는데, 이유를 모르겠다. */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long Min = sc.nextLong();
        long Max = sc.nextLong();
        boolean[] check = new boolean[(int) (Max - Min + 1)];

        for (long i = 2; i <= Max; i++) {
            long pow = i * i;
            if (pow > Max) break; /* 이 연산으로 시간초과를 없앨 수 있었다. 높은 수의 곱연산이 백준 채첨서버에 시간초과를 일으키는듯 */
            long start_index = Min / pow;
            if (Min % pow != 0) start_index++;
            for (long j = start_index; pow * j <= Max; j++) {
                check[(int) ((j * pow) - Min)] = true;
            }
        }
        int count = 0;
        for (int i = 0; i <= Max - Min; i++) {
            if (!check[i]) count++;
        }
        System.out.println(count);
    }
}
    /* 범위가 저런데 long으로 풀어야 하나? 메모리 초과되었다.
    public static void Main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        ArrayList<Long> al = new ArrayList<>();
        for (long i = 0; i <= max; i++) {
            al.add(i);
        }
        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (al.get(i) == 0){
                continue;
            }
            for (int j = i * i; j <= max; j *= i) {
                if (al.get(j) == 0) {
                    continue;
                } else {
                    al.set(j, 0L);
                }
            }
        }
        int result = 0;
        for (Long l : al) {
            if (l != 0) result++;
        }
        System.out.println(result);
    }
}*/
