package hanghae.day4;

import java.util.ArrayList;
import java.util.List;

//우박수열 정적분
//접근 방법 조차 떠올리지 못한 문제
public class DefiniteIntegralOfHailSequence {
    public static double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];

        // 콜라츠 추측 리스트
        List<Integer> list = new ArrayList<>();
        list.add(k);

        // 콜라츠 추측 나머지 구하기
        while(k > 1) {
            if(k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            list.add(k);
        }

        for(int i = 0; i < ranges.length; i++) {
            // 현재 ranges의 정적분 범위 구하기
            int start = ranges[i][0];
            int end = list.size() - 1 + ranges[i][1];

            // 시작 범위가 끝 범위 보다 크다면
            if(start > end) {
                answer[i] = -1;
                continue;
            }

            // 시작 범위부터 x를 1씩 증가시키며 사다리꼴 넓이 구하고 sum에 더하기
            double sum = 0;
            for(int j = start; j < end; j++) {
                double now = list.get(j);
                double target = list.get(j + 1);
                sum += (now + target) / 2;
            }
            answer[i] = sum;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(
                solution(5, new int[][]{{0,0},{0,-1},{2,-3},{3,-3}})
                        .equals(new double[]{33.0,31.5,0.0,-1.0}));
    }
}
