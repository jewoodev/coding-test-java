package coding.test.hanghae.beforehand.day4.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//디펜스 게임
//도통 어떤 걸 잘못 구현한 건지 모르겠다
public class DefenceGame {
    public static int solution(int n, int k, int[] enemy) {
        //가장 적이 많이 출몰하는 라운드에서 무적권을 쓰기 위해 enemy 정렬
        Integer[] sorted = Arrays.stream(enemy)
                .boxed()
                .toArray(Integer[]::new);
        Arrays.sort(sorted, Collections.reverseOrder());
        List<Integer> list = new ArrayList<>();
        for (int i : enemy) {
            list.add(i);
        }
        for (int i = 0; i < k; i++) {
            list.remove(sorted[i]);
        }
        int round = 0;
        for (int i = 0; i < list.size(); i++) {
            n -= list.get(i);
            if (n <= 0) return round + k;
            round++;
        }

        return round + k;
    }

    public static void main(String[] args) {
//        System.out.println(solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));
//        System.out.println(solution(2, 4, new int[]{3, 3, 3, 3}));
//        System.out.println(solution(5, 2, new int[]{99,1,99}));
        System.out.println(solution(10, 1, new int[]{2, 2, 2, 2, 2, 10}));
    }
}
