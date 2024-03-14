package hanghae.day3.supplement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//시소 짝꿍
public class PairSeesaw {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{100,180,360,100,270}));
    }

    public static long solution(int[] weights) {
        long answer = 0;

        /* ==!Map을 이용==
         사람들의 무게를 맵에 key로, value는 사람 수를 입력해서
        * 짝꿍의 경우를 센다. */
        Map<Double, Integer> map = new HashMap<>();
        Arrays.sort(weights);
        for(int weight : weights) {
            answer += helper(weight, map);
        }
        return answer;
    }

    public static long helper(int w, Map<Double, Integer> map) {
        long answer = 0;
        //오름차순 되어 있으므로 1:1, 2:3, 1:2, 3:4 비율의 경우 짝꿍이 될 수 있다.
        double d1 = w*1.0;
        double d2 = (w*2.0)/3.0;
        double d3 = (w*1.0)/2.0;
        double d4 = (w*3.0)/4.0;
        //그 비율의 몸무게를 갖는 사람이 있다면, 그 사람 수만큼 경우의 수를 늘려준다.
        if(map.containsKey(d1)) answer += map.get(d1);
        if(map.containsKey(d2)) answer += map.get(d2);
        if(map.containsKey(d3)) answer += map.get(d3);
        if(map.containsKey(d4)) answer += map.get(d4);
        //확인 후 현재 확인한 몸무게를 map에 알맞게 저장한다.
        map.put(w*1.0, map.getOrDefault(w*1.0, 0)+1);
        return answer;
    }
}
