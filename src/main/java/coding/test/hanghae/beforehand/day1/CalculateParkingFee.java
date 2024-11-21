package coding.test.hanghae.beforehand.day1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.sort;

//주차 요금 계산 https://school.programmers.co.kr/learn/courses/30/lessons/92341
public class CalculateParkingFee {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        Map<String, String> map = new HashMap<>(); //입출 시간 맵
        Map<String, Integer> feeMap = new HashMap<>(); //요금 맵

        //차량마다 시간을 임시 저장
        for (int i = 0; i < records.length; i++) {
            feeMap.put(records[i].split(" ")[1], 0);
        }

        //임시 저장한 데이터로 요금 맵과 입출 시간 맵 초기화
        for (int i = 0; i < records.length; i++) {
            String[] infos = records[i].split(" ");
            String carNum = infos[1]; //차 번호

            if (map.containsKey(carNum)) {
                String[] inTime = map.remove(carNum).split(":");
                String[] outTime = infos[0].split(":");

                int hour = Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]);
                int minute = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);

                feeMap.replace(carNum, feeMap.get(carNum) + 60 * hour + minute);

            } else {
                map.put(carNum, infos[0]); // 차 번호, 시간
            }
        }

        //입차 후 출차하지 않은 차량 연산
        for (String key : map.keySet()) {
            String[] inTime = map.get(key).split(":");

            int hour = 23 - Integer.parseInt(inTime[0]);
            int minute = 59 -Integer.parseInt(inTime[1]);

            feeMap.replace(key, feeMap.get(key) + 60 * hour + minute);
        }

        //차량번호를 기준으로 오름차순 정렬
        List<Map.Entry<String, Integer>> list = new ArrayList(feeMap.entrySet());
        sort(list, (o1, o2) -> {
            return Integer.parseInt(o1.getKey()) > Integer.parseInt(o2.getKey()) ? 1 :
                    Integer.parseInt(o1.getKey()) < Integer.parseInt(o2.getKey()) ? -1 : 0;
        });

        answer = new int[list.size()];

        //요금 계산
        for(int i = 0; i < answer.length; i++) {
            if(list.get(i).getValue() > fees[0]) { //기본 시간을 넘겼다면
                answer[i] = fees[1] + (int) Math.ceil((list.get(i).getValue() - fees[0]) / (double)fees[2]) * fees[3]; //연산
            } else {
                answer[i] = fees[1]; //그렇지 않으면 기본 요금
            }
        }

        return answer;
    }
}
