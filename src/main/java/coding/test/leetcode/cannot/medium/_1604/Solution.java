package coding.test.leetcode.cannot.medium._1604;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();

        // 1. 각 직원별로 시간을 분 단위로 변환하여 저장
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            int minutes = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));

            map.putIfAbsent(name, new ArrayList<>());
            map.get(name).add(minutes);
        }

        List<String> result = new ArrayList<>();

        // 2. 각 직원별로 시간을 정렬하고 1시간 이내 3번 이상 사용 확인
        for (String name : map.keySet()) {
            List<Integer> times = map.get(name);
            Collections.sort(times);

            // 슬라이딩 윈도우로 1시간 이내 3번 이상 사용 확인
            for (int i = 2; i < times.size(); i++) {
                if (times.get(i) - times.get(i - 2) <= 60) {
                    result.add(name);
                    break;
                }
            }
        }

        // 3. 결과를 사전순으로 정렬
        Collections.sort(result);
        return result;
    }
}