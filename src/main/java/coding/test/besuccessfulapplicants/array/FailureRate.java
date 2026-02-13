package coding.test.besuccessfulapplicants.array;

import java.util.*;

public class FailureRate { // https://school.programmers.co.kr/learn/courses/30/lessons/42889
    public int[] solution(int N, int[] stages) {
        int[] c = new int[N + 2];

        for (int stage : stages) {
            c[stage]++;
        }

        double total = stages.length;
        Map<Integer, Double> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            if (c[i] == 0) map.put(i, 0.);
            else {
                map.put(i, c[i] / total);
                total -= c[i];
            }
        }

        return map.entrySet().stream()
                .sorted((e1, e2) -> {
                    var v1 = e1.getValue();
                    var v2 = e2.getValue();
                    return v1.equals(v2) ? Integer.compare(e1.getKey(), e2.getKey()) : Double.compare(v2, v1);
                })
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

//    public int[] solution(int N, int[] stages) { 실패
//        int[] l = new int[N];
//        int[] c = new int[N];
//
//        for (int stage : stages) {
//            for (int i = 1; i <= stage; i++) {
//                if (i > N) break;
//                l[i - 1]++;
//                if (i == stage) c[i - 1]++;
//            }
//        }
//
//        Map<Integer, BigDecimal> map = new HashMap<>();
//        for (int i = 0; i < N; i++) {
//            var numUp = BigDecimal.valueOf(c[i]);
//            var numDown = BigDecimal.valueOf(l[i]);
//            map.put(i + 1, numUp.divide(numDown, 5, RoundingMode.HALF_UP));
//        }
//
//        return map.entrySet().stream()
//                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
//                .mapToInt(e -> e.getKey().intValue())
//                .toArray();
//    }
}
